package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;

/**
 * @author 16861
 */
public abstract class AbstractHashTable<T> implements HashTable<T> {
    protected static final int TABLE_SIZE = 11;
    /**
     * The array of elements
     */
    protected HashEntry<T>[] data;
    /**
     * The number of occupied cells
     */
    protected int occupied;
    /**
     * Current size
     */
    protected int size;

    public AbstractHashTable() {
        allocateArray();
        clear();
    }

    /**
     * Method that performs finding hashing resolution.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    protected abstract int resolve(T x);

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     * @return true if item removed
     */
    @Override
    public boolean remove(T x) {
        int currentPos = resolve(x);
        if (isActive(currentPos)) {
            data[currentPos].isActive = false;
            size--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     *
     * @param x the item to insert.
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
        data[currentPos] = new HashEntry<>(x, true);
        size++;

        return true;
    }

    /**
     * Return true if currentPos exists and is active.
     *
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    protected boolean isActive(int currentPos) {
        return data[currentPos] != null && data[currentPos].isActive;
    }

    /**
     * Get current size.
     *
     * @return the size.
     */
    public int size() {
        return size;
    }

    /**
     * Get length of internal table.
     *
     * @return the size.
     */
    public int capacity() {
        return data.length;
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return the matching item.
     */
    @Override
    public boolean contains(T x) {
        int currentPos = resolve(x);
        return isActive(currentPos);
    }

    /**
     * Make the hash table logically empty.
     */
    @Override
    public void clear() {
        occupied = 0;
        Arrays.fill(data, null);
    }

    /**
     * Internal method to allocate array.
     */
    @SuppressWarnings("unchecked")
    protected void allocateArray() {
        data = new HashEntry[TABLE_SIZE];
    }


    /**
     * @return
     */
    protected int hash(T x) {
        int hashVal = x.hashCode();

        hashVal %= data.length;
        if (hashVal < 0) {
            hashVal += data.length;
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
        b.append(getClass().getSimpleName() + ":\n");
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(data[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(",");
        }
    }

    protected static class HashEntry<E> {
        /**
         * the element
         */
        public E element;
        /**
         * false if marked deleted
         */
        public boolean isActive;

        public HashEntry(E e) {
            this(e, true);
        }

        public HashEntry(E e, boolean i) {
            element = e;
            isActive = i;
        }

        @Override
        public String toString() {
            return isActive ? element.toString() : "";
        }
    }
}
