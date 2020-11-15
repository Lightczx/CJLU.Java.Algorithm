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

    protected abstract int findPos(T x);

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     * @return true if item removed
     */
    @Override
    public boolean remove(T x) {
        int currentPos = findPos(x);
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
        int currentPos = findPos(x);
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
        int currentPos = findPos(x);
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
}
