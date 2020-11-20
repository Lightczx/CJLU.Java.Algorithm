package DGP.CJLU.Experiment5.Lab1;

/**
 * @author 16861
 */
public class DoubleHashingHashTable<T> extends AbstractHashTable<T> {
    private final int prevPrime = 7;
    /**
     * Method that performs double hashing resolution.
     * used to call findPos
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    @Override
    protected int resolve(T x) {
        int currentPos = hash(x);
        int i = 1;
        while (data[currentPos] != null && !data[currentPos].element.equals(x)) {
            // Compute its probe
            currentPos = hash2(x) * i++;
            if (currentPos >= data.length) {
                currentPos -= data.length;
            }
        }

        return currentPos;
    }

    private int hash2(T x) {
        int hashVal = x.hashCode();

        hashVal = prevPrime - (hashVal % prevPrime);
        return hashVal;
    }
}
