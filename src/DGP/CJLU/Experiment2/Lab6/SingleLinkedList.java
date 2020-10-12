package DGP.CJLU.Experiment2.Lab6;

/**
 * single linked list custom implementation
 *
 * @param <E> the stored value type
 */
public class SingleLinkedList<E> {
    private class Node {
        private final E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

    }

    /**
     * dummy head
     */
    private Node dummyHead;
    private Node dummyTail;
    private int size;

    public int getSize() {
        return this.size;
    }

    public SingleLinkedList() {
        this.dummyTail = new Node(null, null);
        this.dummyHead = new Node(null, dummyTail);
        this.size = 0;
    }

    /**
     * O(1)
     *
     * @param e
     */
    public void addFirst(E e) {
        Node node = new Node(e, dummyHead.next);
        this.dummyHead.next = node;
        this.size++;
    }

    public void reverse() {
        Node pre = null;
        Node cur = dummyHead;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //swap head and tail
        Node tmp = dummyHead;
        dummyHead = dummyTail;
        dummyTail = tmp;
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        sb.append("head -> ");
        while (!cur.equals(dummyTail)) {
            sb.append(cur.e);
            sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("tail");
        return sb.toString();
    }
}
