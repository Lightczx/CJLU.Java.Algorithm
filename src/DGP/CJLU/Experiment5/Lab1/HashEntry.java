package DGP.CJLU.Experiment5.Lab1;

public class HashEntry<E> {
    /**
     * the element
     */
    public E element;
    /**
     * false if marked deleted
     */
    public boolean isActive;

    public HashEntry(E e) {
        this(e, true);
    }

    public HashEntry(E e, boolean i) {
        element = e;
        isActive = i;
    }

    @Override
    public String toString() {
        return "{" + element + ',' + isActive + '}';
    }
}
