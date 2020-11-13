package DGP.CJLU.Experiment2.Lab2;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.Rand;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given two sorted lists, L1 and L2, write a procedure to compute L1∩ L2 using only the basic list
 * operations. What is the time complexity of your procedure? Compare the running times of your
 * implementation with retainAll.LinkedList and ArrayList should be used.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        TwoList arrayLists = initializeArrayList();
        TwoList linkedLists = initializeLinkedList();
        //we don't want to count the initialize time
        new Dispatcher().run(() -> {
            getIntersection(arrayLists);
        }).run(() -> {
            arrayLists.l1.retainAll(arrayLists.l2);
        }).run(() -> {
            getIntersection(linkedLists);
        }).run(() -> {
            linkedLists.l1.retainAll(linkedLists.l2);
        });
    }

    private static TwoList initializeArrayList() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }
        for (int j = 5; j <= 15; j++) {
            list2.add(j);
        }
        return new TwoList(list1, list2, new ArrayList<>());
    }

    private static TwoList initializeLinkedList() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }
        for (int j = 1; j <= 5; j++) {
            list2.add(Rand.randInt(1, 10));
        }
        return new TwoList(list1, list2, new LinkedList<>());
    }

    private static void getIntersection(TwoList twoList) {
        for (int num : twoList.l1) {
            if (twoList.l2.contains(num)) {
                twoList.result.add(num);
            }
        }
    }

}
