package DGP.CJLU.Experiment3.Lab2;

/**
 * @author 16861
 */
public class ArrayQueue<E> implements Queue<E> {
    private final E[] array;
    private final int arraySize;
    private int availableIndex = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int arraySize) {
        this.arraySize = arraySize;
        array = (E[]) new Object[arraySize];
    }

    @Override
    public boolean offer(E e) {
        if (availableIndex < arraySize) {
            array[availableIndex++] = e;
            return true;
        }
        return false;
    }

    @Override
    public E poll() {
        E e = array[0];
        moveLeft();
        return e;
    }

    @Override
    public E peek() {
        return array[0];
    }

    private void moveLeft() {
        /*
          If the src and dest arguments refer to the
          same array object, then the copying is performed as if the
          components at positions srcPos through
          srcPos+length-1 were first copied to a temporary
          array with length components and then the contents of
          the temporary array were copied into positions
          destPos through destPos+length-1 of the
          destination array.
         */
        if (availableIndex >= 0) {
            System.arraycopy(array, 1, array, 0, availableIndex);
        }
        availableIndex--;
    }

    @Override
    public String toString() {
        int iMax = array.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(" , ");
        }

    }
}
