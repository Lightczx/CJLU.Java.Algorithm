package DGP.CJLU.Experiment5.Lab1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 16861
 */
public class SeparateChainingHashTable<T> implements HashTable<T> {
    protected static final int TABLE_SIZE = 11;
    /**
     * The array of Lists.
     */
    protected List<T>[] data;
    protected int size;

    /**
     * Construct the hash table.
     */
    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable() {
        data = new LinkedList[TABLE_SIZE];
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
        for (List<T> datum : data) {
            datum.clear();
        }
        size = 0;
    }

    protected int hashToIndex(T x) {
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
