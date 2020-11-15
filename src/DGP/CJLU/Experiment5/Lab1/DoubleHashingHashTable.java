package DGP.CJLU.Experiment5.Lab1;

import java.util.Arrays;

/**
 * @author 16861
 */
public class DoubleHashingHashTable<T> extends AbstractHashTable<T> {
    private final int prevPrime = 7;
    /**
     * Construct the hash table.
     */
    public DoubleHashingHashTable() {
        allocateArray();
        clear();
    }

    /**
     * Method that performs double hashing resolution.
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

    @Override
    public String toString() {
        return "DoubleHashingHashTable:\n" + Arrays.toString(data);
    }
}
