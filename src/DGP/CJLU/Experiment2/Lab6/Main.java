package DGP.CJLU.Experiment2.Lab6;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.Rand;

/**
 * Write a non-recursive procedure to reverse a singly linked list in O(N) time.
 *
 * @author 16861
 */
public class Main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = initializeSingleLinkedList();

        new Dispatcher().run(singleLinkedList::reverse);
    }

    private static SingleLinkedList<Integer> initializeSingleLinkedList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int j = 1; j <= 1000000; j++) {
            list.addFirst(new Rand().randomInt(1, 1000000));
        }
        return list;
    }
}
