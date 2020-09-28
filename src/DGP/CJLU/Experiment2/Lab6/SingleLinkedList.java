package DGP.CJLU.Experiment2.Lab6;

/**
 * single linked list custom implementation
 * @param <E> the stored value type
 */
public class SingleLinkedList<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
    }

    private Node head;
    private int size;

    public int getSize() {
        return this.size;
    }

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(E e) {
        this.head = new Node(e, head);
        this.size++;
    }

    /**
     * 向链表尾部插入元素
     */
    public void add(E e) {
        this.add(e, this.size);
    }

    /**
     * 向链表中间插入元素
     */
    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        if (index == 0)
            this.addFirst(e);

        Node pre = this.head;
        //找到要插入节点的前一个节点
        for (int i = 0; i < index - 1; i++)
            pre = pre.next;

        Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;
        this.size++;
    }

    public E removeFirst() {
        if (this.head == null) {
            //no element to remove
            return null;
        }
        Node delNode = this.head;
        this.head = this.head.next;
        delNode.next = null;
        this.size--;
        return delNode.e;
    }

    public E removeLast() {
        if (this.head == null) {
            return null;
        }
        //只有一个元素
        if (this.size == 1) {
            return this.removeFirst();
        }
        Node cur = this.head;    //记录当前结点
        Node pre = this.head;    //记录要删除结点的前一个结点
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        this.size--;
        return cur.e;
    }

    public void remove(E e) {
        Node dummy = new Node(e, this.head);
        Node cur = dummy;

        while (cur.next != null) {
            if (cur.next.e.equals(e)) {
                cur.next = cur.next.next;
                this.size--;
            } else cur = cur.next;
        }

        this.head = dummy.next;
    }

    /**
     * @param e:插入在t元素的位置
     * @param destination：要插入的元素
     */
    public void insert(E e, E destination) {
        Node dummy = new Node(null, this.head);
        Node dNode = new Node(destination);

        Node cur = dummy;
        while (cur.next != null) {
            if (cur.next.e.equals(e)) {
                dNode.next = cur.next;
                cur.next = dNode;
                this.size++;
                break;
            } else cur = cur.next;
        }

        this.head = dummy.next;
    }

    public boolean contains(E t) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.e.equals(t)) {
                return true;
            } else cur = cur.next;
        }
        return false;
    }

    public void reverse() {
        Node head = this.head;
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}
