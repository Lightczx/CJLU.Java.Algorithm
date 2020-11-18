package DGP.CJLU.Experiment5.Lab1;

/**
 * @author 16861
 */
public class QuadraticProbingHashTable<T> extends AbstractHashTable<T> {
    /**
     * Construct the hash table.
     */
    public QuadraticProbingHashTable() {
        allocateArray();
        clear();
    }

    /**
     * Method that performs quadratic probing resolution.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    @Override
    protected int resolve(T x) {
        int offset = 1;
        int currentPos = hash(x);

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
}
