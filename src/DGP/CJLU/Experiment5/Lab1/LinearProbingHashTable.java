package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;

/**
 * @author 16861
 */
public class LinearProbingHashTable<T> extends AbstractHashTable<T> {
    /**
     * Construct the hash table.
     */
    public LinearProbingHashTable() {
        allocateArray();
        clear();
    }

    /**
     * Method that performs linear probing resolution.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    @Override
    protected int findPos(T x) {
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
        return "LinearProbingHashTable:\n" + Arrays.toString(data);
    }
}
