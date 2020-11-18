package DGP.CJLU.Experiment5.Lab1;

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
    protected int resolve(T x) {
        int currentPos = hash(x);

        while (data[currentPos] != null && !data[currentPos].element.equals(x)) {
            // Compute its probe
            currentPos += 1;

            if (currentPos >= data.length) {
                currentPos -= data.length;
            }
        }

        return currentPos;
    }
}
