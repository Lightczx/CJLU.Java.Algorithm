package DGP.CJLU.Experiment5.Lab1;

import java.util.LinkedList;
import java.util.List;

/**
 * Separate chaining table implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 *
 * @author 16861
 */
public class SeparateChainingRehashingHashTable<T> extends SeparateChainingHashTable<T> {
    private static final int TABLE_SIZE = 11;

    /**
     * Construct the hash table.
     */
    @SuppressWarnings("unchecked")
    public SeparateChainingRehashingHashTable() {
        data = new LinkedList[nextPrime(TABLE_SIZE)];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

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
     * Insert into the hash table. If the item is
     * already present, then do nothing.
     *
     * @param x the item to insert.
     */
    @Override
    public boolean insert(T x) {
        List<T> whichList = data[hashToIndex(x)];
        boolean result = false;
        if (!whichList.contains(x)) {
            result = whichList.add(x);

            // Rehash; see Section 5.5
            if (++size > data.length) {
                rehash();
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        List<T>[] oldLists = data;

        // Create new double-sized, empty table
        data = new List[nextPrime(2 * data.length)];
        for (int j = 0; j < data.length; j++) {
            data[j] = new LinkedList<>();
        }

        // Copy table over
        size = 0;
        for (List<T> list : oldLists) {
            for (T item : list) {
                insert(item);
            }
        }
    }
}


