package DGP.CJLU.Experiment5.Lab1;

/**
 * @author 16861
 */
public abstract class RehashingHashTable<T> extends AbstractHashTable<T> {
    /**
     * Internal method to find a prime number at least as large as n.
     *
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    protected static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }

        for (; !isPrime(n); n += 2) {
        }

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     *
     * @param n the number to test.
     * @return the result of the test.
     */
    protected static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n == 1 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * insert with rehash support
     *
     * @param x the item to insert.
     * @return
     */
    @Override
    public boolean insert(T x) {
        // Insert x as active
        int currentPos = resolve(x);
        if (isActive(currentPos)) {
            return false;
        }

        if (data[currentPos] == null) {
            ++occupied;
        }
        data[currentPos] = new HashEntry<T>(x, true);
        size++;

        // Rehash; see Section 5.5
        if (++size > data.length) {
            rehash();
        }

        return true;
    }

    /**
     * Expand the hash table.
     */
    private void rehash() {
        HashEntry<T>[] oldArray = data;

        // Create a new double-sized, empty table
        allocateArray(2 * oldArray.length);
        occupied = 0;
        size = 0;

        // Copy table over
        for (HashEntry<T> entry : oldArray) {
            if (entry != null && entry.isActive) {
                insert(entry.element);
            }
        }
    }

    /**
     * Internal method to allocate array.
     *
     * @param arraySize the size of the array.
     */
    @SuppressWarnings("unchecked")
    protected void allocateArray(int arraySize) {
        //record the previous prime number

        data = new HashEntry[nextPrime(arraySize)];
    }
}
