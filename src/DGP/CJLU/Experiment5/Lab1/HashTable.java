package DGP.CJLU.Experiment5.Lab1;

/**
 * @author 16861
 */
public interface HashTable<T> {
    /**
     * Insert into the hash table. If the item is already present, do nothing.
     *
     * @param value the value to insert
     * @return {@code true}if success
     */
    boolean insert(T value);

    /**
     * Remove from the hash table.
     *
     * @param value the value to remove
     * @return {@code true}if success
     */
    boolean remove(T value);

    /**
     * check if an item in the hash table.
     *
     * @param value the value to search
     * @return {@code true}if success
     */
    boolean contains(T value);

    /**
     * Make the hash table logically empty.
     */
    void clear();
}
