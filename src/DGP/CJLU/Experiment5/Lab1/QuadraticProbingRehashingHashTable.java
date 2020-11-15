package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;

/**
 * @author 16861
 */
public class QuadraticProbingRehashingHashTable<T> extends RehashingHashTable<T> {
    /**
     * Construct the hash table.
     */
    public QuadraticProbingRehashingHashTable() {
        this(TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size the approximate initial size.
     */
    private QuadraticProbingRehashingHashTable(int size) {
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
        int offset = 1;
        int currentPos = hashToIndex(x);

        while (data[currentPos] != null && !data[currentPos].element.equals(x)) {
            // Compute its probe
            currentPos += offset;
            offset += 2;
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

    @Override
    public String toString() {
        return "QuadraticProbingRehashingHashTable:\n" + Arrays.toString(data);
    }
}
