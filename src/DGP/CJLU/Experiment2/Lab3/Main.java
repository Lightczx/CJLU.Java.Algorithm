package DGP.CJLU.Experiment2.Lab3;

import DGP.CJLU.Utils.Dispatcher;
import DGP.CJLU.Utils.Implementation.Rand;
import DGP.CJLU.Experiment2.Lab2.TwoList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 3.	Given two sorted lists, L1 and L2, write a procedure to compute L1∪ L2 using only the basic
 * list operations.What is the time complexity of your procedure? Compare the running times of your
 * implementation with removeAll + addAll. LinkedList and ArrayList should be used.
 */
public class Main {
    public static void main(String[] args) {

        TwoList arrayLists = InitializeArrayList();
        TwoList linkedLists = InitializeLinkedList();
        //we don't want to count the initialize time
        new Dispatcher().run(() -> {
            GetUnion(arrayLists);
        }).run(() -> {
            arrayLists.L1.removeAll(arrayLists.L2);
            arrayLists.L1.addAll(arrayLists.L2);
        }).run(() -> {
            GetUnion(linkedLists);
        }).run(() -> {
            linkedLists.L1.removeAll(linkedLists.L2);
            linkedLists.L1.addAll(linkedLists.L2);
        });
    }

    private static TwoList InitializeArrayList() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            list1.add(i);
        for (int j = 5; j <= 15; j++)
            list2.add(j);
        return new TwoList(list1, list2, new ArrayList<>());
    }

    private static TwoList InitializeLinkedList() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 1; i <= 10; i++)
            list1.add(i);
        for (int j = 1; j <= 5; j++)
            list2.add(Rand.randInt(1, 10));
        return new TwoList(list1, list2, new LinkedList<>());
    }

    private static void GetUnion(TwoList twoList) {
        for (int num : twoList.L1) {
            if (!twoList.L1.contains(num))
                twoList.L1.add(num);
            twoList.Result = twoList.L1;
        }
    }
}
