package DGP.CJLU.Experiment3.Lab2;

import DGP.CJLU.Utils.Implementation.Queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private final LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public boolean offer(E e) {
        return linkedList.add(e);
    }

    @Override
    public E poll() {
        E first = linkedList.getFirst();//Returns the first element in this list.
        linkedList.removeFirst();
        return first;
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        Iterator<E> it = linkedList.iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            E e = it.next();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(" , ");
        }
    }
}
