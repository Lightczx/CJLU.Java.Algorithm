package DGP.CJLU.Experiment2.Lab6;

import DGP.CJLU.Utils.Dispatcher;
import DGP.CJLU.Utils.Implementation.Rand;

/**
 * Write a nonrecursive procedure to reverse a singly linked list in O(N) time.
 */
public class Main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = InitializeSingleLinkedList();
        //System.out.println(singleLinkedList.toString());
        new Dispatcher().run(singleLinkedList::reverse);
        //System.out.println(singleLinkedList.toString());
    }

    private static SingleLinkedList<Integer> InitializeSingleLinkedList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int j = 1; j <= 1000000; j++)
            list.addFirst(Rand.randInt(1, 1000000));
        return list;
    }
}
