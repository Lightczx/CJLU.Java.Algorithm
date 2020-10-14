package DGP.CJLU.Experiment3.Lab2;

import DGP.CJLU.Utils.Implementation.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private final E[] array;
    private int availableIndex = 0;
    private final int arraySize;

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
        MoveLeft();
        return e;
    }

    @Override
    public E peek() {
        return array[0];
    }

    private void MoveLeft() {
        for (int i = 0; i < availableIndex; i++) {
            array[i] = array[i + 1];
        }
        availableIndex--;
    }

    @Override
    public String toString() {
        int iMax = array.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(" , ");
        }

    }
}
