package DGP.CJLU.Utils.Implementation;

/**
 * Random number class, using a 31-bit
 * linear congruential generator.
 * Note that java.util contains a class Random,
 * so watch out for name conflicts.
 *
 * @author Mark Allen Weiss
 */
public class Rand {
    private static final int A = 48271;
    private static final int M = 2147483647;
    private static final int Q = M / A;
    private static final int R = M % A;

    private int state;

    /**
     * Construct this Random object with
     * initial state obtained from system clock.
     */
    public Rand() {
        this((int) (System.currentTimeMillis() % Integer.MAX_VALUE));
    }

    /**
     * Construct this Random object with
     * specified initial state.
     *
     * @param initialValue the initial state.
     */
    public Rand(int initialValue) {
        if (initialValue < 0) {
            initialValue += M;
        }

        state = initialValue;
        if (state == 0) {
            state = 1;
        }
    }

    /**
     * Randomly rearrange an array.
     * The random numbers used depend on the time and day.
     *
     * @param a the array.
     */
    public static void permute(Object[] a) {
        Rand r = new Rand();

        for (int j = 1; j < a.length; j++) {
            Sorting.swapReferences(a, j, r.randomInt(0, j));
        }
    }

    /**
     * Return a pseudorandom int, and change the
     * internal state.
     *
     * @return the pseudorandom int.
     */
    public int randomInt() {
        int tmpState = A * (state % Q) - R * (state / Q);
        if (tmpState >= 0) {
            state = tmpState;
        } else {
            state = tmpState + M;
        }

        return state;
    }

    /**
     * Return an int in the closed range [low,high], and
     * change the internal state.
     *
     * @param low  the minimum value returned.
     * @param high the maximum value returned.
     * @return the pseudorandom int.
     */
    public int randomInt(int low, int high) {
        double partitionSize = (double) M / (high - low + 1);

        return (int) (randomInt() / partitionSize) + low;
    }

    /**
     * Return an long in the closed range [low,high], and
     * change the internal state.
     *
     * @param low  the minimum value returned.
     * @param high the maximum value returned.
     * @return the pseudorandom long.
     */
    public long randomLong(long low, long high) {
        long longVal = ((long) randomInt() << 31) + randomInt();
        long longM = ((long) M << 31) + M;

        double partitionSize = (double) longM / (high - low + 1);
        return (long) (longVal / partitionSize) + low;
    }

}