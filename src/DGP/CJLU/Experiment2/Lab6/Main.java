package DGP.CJLU.Experiment2.Lab6;

import DGP.CJLU.Utils.ExecuteTime;
import DGP.CJLU.Utils.Implementation.Rand;

/**
 * Write a nonrecursive procedure to reverse a singly linked list in O(N) time.
 */
public class Main {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = InitializeSingleLinkedList();
        System.out.println(singleLinkedList.toString());
        new ExecuteTime().run(() -> {

            singleLinkedList.reverse();
        });
        System.out.println(singleLinkedList.toString());
    }

    private static SingleLinkedList<Integer> InitializeSingleLinkedList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int j = 1; j <= 10; j++)
            list.addFirst(Rand.randInt(1, 10));
        return list;
    }

}
