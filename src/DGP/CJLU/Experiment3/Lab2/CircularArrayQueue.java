package DGP.CJLU.Experiment3.Lab2;

import DGP.CJLU.Utils.Implementation.Queue;

public class CircularArrayQueue<E> implements Queue<E> {
    private final E[] array;
    private int begin = 0;
    private int availableIndex = 0;
    private final int arraySize;
    private int count = 0;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int arraySize) {
        this.arraySize = arraySize;
        array = (E[]) new Object[arraySize];
    }

    @Override
    public boolean offer(E e) {
        //empty : add
        if (count == 0) {
            array[availableIndex++] = e;
            count++;
            return true;
        }
        //full : return
        if (isFull())
            return false;

        array[availableIndex++] = e;
        //circle to 0
        if (availableIndex == arraySize) {
            availableIndex = 0;
        }
        count++;
        return true;
    }

    public boolean isFull() {
        if (count > 0)
            return availableIndex == begin;
        return false;
    }


    @Override
    public E poll() {
        if (begin != availableIndex) {//ensure not null
            E e = array[begin];
            array[begin++] = null;
            if (begin == arraySize)
                begin = 0;
            count--;
            return e;
        }
        return null;
    }

    @Override
    public E peek() {
        return begin != availableIndex ? array[begin] : null;
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
                return b.append("] ").append(begin).append(" | ").append(availableIndex).toString();
            b.append(" , ");
        }
    }
}
