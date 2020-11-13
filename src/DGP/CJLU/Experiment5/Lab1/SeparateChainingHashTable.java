package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Separate chaining table implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 * @author 16861
 */
public class SeparateChainingHashTable<T> {
    /**
     * The array of Lists.
     */
    private List<T>[] dataLists;
    private int currentSize;

    private static final int TABLE_SIZE = 11;

    /**
     * Construct the hash table.
     */
    public SeparateChainingHashTable() {
        this(TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size approximate table size.
     */
    @SuppressWarnings("unchecked")
    private SeparateChainingHashTable(int size) {
        dataLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < dataLists.length; i++) {
            dataLists[i] = new LinkedList<>();
        }
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then do nothing.
     *
     * @param x the item to insert.
     */
    public void insert(T x) {
        List<T> whichList = dataLists[hashToIndex(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);

            /*// Rehash; see Section 5.5
            if (++currentSize > dataLists.length) {
                rehash();
            }*/
        }
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     */
    public void remove(T x) {
        List<T> whichList = dataLists[hashToIndex(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return true if x is not found.
     */
    public boolean contains(T x) {
        List<T> whichList = dataLists[hashToIndex(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        for (int i = 0; i < dataLists.length; i++) {
            dataLists[i].clear();
        }
        currentSize = 0;
    }

    private int hashToIndex(T x) {
        //Integer's hashCode equals the value itself
        int hashVal = x.hashCode();

        hashVal %= TABLE_SIZE;
        if (hashVal < 0) {
            hashVal += TABLE_SIZE;
        }

        return hashVal;
    }

    /**
     * Internal method to find a prime number at least as large as n.
     *
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }
        for (; !isPrime(n); n += 2) {
            ;
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
    private static boolean isPrime(int n) {
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

    @Override
    public String toString() {
        if (dataLists == null) {
            return "null";
        }

        int iMax = dataLists.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append("ThisTable:\n");
        for (int i = 0; ; i++) {
            b.append(i).append(":\t").append(dataLists[i]);
            if (i == iMax) {
                return b.append("\n").toString();
            }
            b.append("\n");
        }
    }
}


