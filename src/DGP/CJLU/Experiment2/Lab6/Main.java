package DGP.CJLU.Experiment2.Lab6;

import DGP.CJLU.Utils.ExecuteTime;
import DGP.CJLU.Utils.Implementation.Rand;
import DGP.CJLU.Utils.Implementation.SingleLinkedList;

/**
 * Write a nonrecursive procedure to reverse a singly linked list in O(N) time.
 */
public class Main {
    public static void main(String[] args) {
        new ExecuteTime().run(() -> {
            InitializeSingleLinkedList().reverse();
        });
    }

    private static SingleLinkedList<Integer> InitializeSingleLinkedList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int j = 1; j <= 10; j++)
            list.add(Rand.randInt(1, 10));
        return list;
    }

}
