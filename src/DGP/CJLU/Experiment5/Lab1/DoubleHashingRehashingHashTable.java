package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;

/**
 * @author 16861
 */
public class DoubleHashingRehashingHashTable<T> extends RehashingHashTable<T> {
    private int prevPrime = 7;
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
     * Method that performs quadratic probing resolution.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    @Override
    protected int findPos(T x) {
        int currentPos = hashToIndex(x);
        int i=1;
        while (data[currentPos] != null && !data[currentPos].element.equals(x)) {
            // Compute its probe
            currentPos = hash2(x)*i++;
            if (currentPos >= data.length) {
                currentPos -= data.length;
            }
        }

        return currentPos;
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
    @Override
    @SuppressWarnings("unchecked")
    protected void allocateArray(int arraySize) {
        //record the previous prime number
        prevPrime = arraySize;
        data = new HashEntry[nextPrime(arraySize)];
    }

    @Override
    public String toString() {
        return "DoubleHashingRehashingHashTable:\n" + Arrays.toString(data);
    }
}
