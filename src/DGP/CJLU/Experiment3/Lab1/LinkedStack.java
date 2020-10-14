package DGP.CJLU.Experiment3.Lab1;

import java.util.LinkedList;

public class LinkedStack<E> {
    private final LinkedList<E> linkedList = new LinkedList<>();

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        E first = linkedList.getFirst();//Returns the first element in this list.
        linkedList.removeFirst();
        return first;
    }

    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ top -> ");
        for (E e : linkedList)
            sb.append(e).append(" -> ");

        sb.append("bottom ]");
        return sb.toString();
    }
}
