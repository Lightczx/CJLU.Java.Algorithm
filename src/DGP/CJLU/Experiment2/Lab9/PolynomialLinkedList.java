package DGP.CJLU.Experiment2.Lab9;

/**
 * attempt to use unique linked list
 */
public class PolynomialLinkedList {
    private class Node{
        int coefficient;
        int exponent;
        Node next;
        Node(int c,int e){
            coefficient=c;
            exponent=e;
        }
    }

    private Node head;
    public int size;

    PolynomialLinkedList(){
        head=new Node(0,0);
        size=0;
    }

    void add(int c,int e){
        Node n=new Node(c,e);
        head.next=n;
    }
}
