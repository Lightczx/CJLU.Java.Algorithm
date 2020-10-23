package DGP.CJLU.Experiment2.Lab1;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.Rand;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given a list, L, and another list, P, containing integers sorted in ascending order.
 * The operation printLots(L,P) will print the elements in L that are in positions specified by P.
 * For instance, if P = 1,3,4,6, the elements in positions 1,3,4, and 6 in L are printed. Write the
 * procedure printLots(L,P).LinkedList and ArrayList should be used. What are the time complexities
 * of your procedures?
 */
public class Main {
    public static void main(String[] args) {
        ListPos lparray = InitializeArrayList();
        ListPos lplinked = InitializeLinkedList();
        new Dispatcher().run(() -> {
            PrintLots(lparray.List, lparray.Pos);
        }).run(() -> {
            PrintLots(lplinked.List, lplinked.Pos);
        });
    }

    private static void PrintLots(List<Integer> l, List<Integer> p) {
        for (int index : p) {
            System.out.println(l.get(index));
        }
    }

    private static ListPos InitializeArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            list.add(i);
        for (int j = 1; j <= 5; j++)
            pos.add(Rand.randInt(1, 9));
        return new ListPos(list, pos);
    }

    private static ListPos InitializeLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> pos = new LinkedList<>();
        for (int i = 1; i <= 10; i++)
            list.add(i);
        for (int j = 1; j <= 5; j++)
            pos.add(Rand.randInt(1, 9));
        return new ListPos(list, pos);
    }


}
