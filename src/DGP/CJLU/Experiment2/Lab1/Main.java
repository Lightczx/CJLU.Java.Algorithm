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
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        ListPos lparray = initializeArrayList();
        ListPos lplinked = initializeLinkedList();
        new Dispatcher().run(() -> {
            printLots(lparray.list, lparray.pos);
        }).run(() -> {
            printLots(lplinked.list, lplinked.pos);
        });
    }

    private static void printLots(List<Integer> l, List<Integer> p) {
        for (int index : p) {
            System.out.println(l.get(index));
        }
    }

    private static ListPos initializeArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int j = 1; j <= 5; j++) {
            pos.add(new Rand().randomInt(1, 9));
        }
        return new ListPos(list, pos);
    }

    private static ListPos initializeLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> pos = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int j = 1; j <= 5; j++) {
            pos.add(new Rand().randomInt(1, 9));
        }
        return new ListPos(list, pos);
    }


}
