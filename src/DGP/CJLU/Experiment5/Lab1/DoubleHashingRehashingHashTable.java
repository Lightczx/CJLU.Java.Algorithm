package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;

/**
 * @author 16861
 */
public class DoubleHashingRehashingHashTable<T> extends AbstractRehashingHashTable<T> {
    private static final int TABLE_SIZE = 11;
    private int prevPrime = 7;
    /**
     * The array of elements
     */
    private HashEntry<T>[] data;
    /**
     * The number of occupied cells
     */
    private int occupied;
    /**
     * Current size
     */
    private int size;

    /**
     * Construct the hash table.
     */
    public DoubleHashingRehashingHashTable() {
        this(TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size the approximate initial size.
     */
    private DoubleHashingRehashingHashTable(int size) {
        allocateArray(size);
        clear();
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

        // Rehash; see Section 5.5
        if (occupied > data.length / 2) {
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
     * Method that performs quadratic probing resolution.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos(T x) {
        int currentPos = hashToIndex(x);

        while (data[currentPos] != null && !data[currentPos].element.equals(x)) {
            // Compute its probe
            currentPos += 1;
            if (currentPos >= data.length) {
                currentPos -= data.length;
            }
        }

        return currentPos;
    }

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
     * Return true if currentPos exists and is active.
     *
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive(int currentPos) {
        return data[currentPos] != null && data[currentPos].isActive;
    }

    /**
     * Make the hash table logically empty.
     */
    @Override
    public void clear() {
        occupied = 0;
        Arrays.fill(data, null);
    }

    private int hashToIndex(T x) {
        int hashVal = x.hashCode();

        hashVal %= data.length;
        if (hashVal < 0) {
            hashVal += data.length;
        }

        return hashVal;
    }

    private int hash2(T x) {
        int hashVal = x.hashCode();

        hashVal = prevPrime - (hashVal % prevPrime);
        return hashVal;
    }

    /**
     * Internal method to allocate array.
     *
     * @param arraySize the size of the array.
     */
    @SuppressWarnings("unchecked")
    private void allocateArray(int arraySize) {
        //record the previous prime number
        prevPrime = arraySize;
        data = new HashEntry[nextPrime(arraySize)];
    }

    @Override
    public String toString() {
        return "DoubleHashingHashTable:\n" + Arrays.toString(data);
    }
}
