package DGP.CJLU.Experiment5.Lab1;

/**
 * @author 16861
 */
public class DoubleHashingHashTable<T> extends AbstractHashTable<T> {
    /**
     * Method that performs double hashing resolution.
     * used to call findPos
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    @Override
    protected int resolve(T x) {
        int currentPos = hash(x);
        int i = 1;
        while (data[currentPos] != null && !data[currentPos].element.equals(x)) {
            // Compute its probe
            currentPos = (currentPos + hash2(x) * i++) % TABLE_SIZE;
            if (currentPos >= data.length) {
                currentPos -= data.length;
            }
        }
        return currentPos;
    }

    private int hash2(T x) {
        return 7 - (x.hashCode() % 7);
    }
}
