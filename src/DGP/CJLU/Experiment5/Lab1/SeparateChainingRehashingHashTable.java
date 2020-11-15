package DGP.CJLU.Experiment5.Lab1;

import java.util.LinkedList;
import java.util.List;

/**
 * Separate chaining table implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 *
 * @author 16861
 */
public class SeparateChainingRehashingHashTable<T> extends AbstractRehashingHashTable<T> {
    private static final int TABLE_SIZE = 11;
    /**
     * The array of Lists.
     */
    private final List<T>[] data;
    private int size;

    /**
     * Construct the hash table.
     */
    public SeparateChainingRehashingHashTable() {
        this(TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size approximate table size.
     */
    @SuppressWarnings("unchecked")
    private SeparateChainingRehashingHashTable(int size) {
        data = new LinkedList[nextPrime(size)];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
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
        if (!whichList.contains(x)) {
            return whichList.add(x);

            /*// Rehash; see Section 5.5
            if (++currentSize > dataLists.length) {
                rehash();
            }*/
        }
        return false;
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     */
    @Override
    public boolean remove(T x) {
        List<T> whichList = data[hashToIndex(x)];
        if (whichList.contains(x)) {
            size--;
            return whichList.remove(x);
        }
        return false;
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return true if x is not found.
     */
    @Override
    public boolean contains(T x) {
        List<T> whichList = data[hashToIndex(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hash table logically empty.
     */
    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i].clear();
        }
        size = 0;
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

    @Override
    public String toString() {
        if (data == null) {
            return "null";
        }

        int iMax = data.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append("SeparateChainingHashTable:\n");
        for (int i = 0; ; i++) {
            b.append(i).append(":\t").append(data[i]);
            if (i == iMax) {
                return b.append("\n").toString();
            }
            b.append("\n");
        }
    }
}


