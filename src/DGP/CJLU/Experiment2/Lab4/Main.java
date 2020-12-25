package DGP.CJLU.Experiment2.Lab4;

import DGP.CJLU.Utils.Implementation.Rand;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Compute the maximum, minimum and average value of a list. LinkedList and ArrayList should be used.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = initializeArrayList();
        getMaximum(arrayList);
        getMinimum(arrayList);
        getAverage(arrayList);

        LinkedList<Integer> linkedList = initializeLinkedList();
        getMaximum(linkedList);
        getMinimum(linkedList);
        getAverage(linkedList);
    }

    private static ArrayList<Integer> initializeArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 5; j <= 15; j++) {
            list.add(j);
        }
        return list;
    }

    private static LinkedList<Integer> initializeLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 1; j <= 10; j++) {
            list.add(new Rand().randomInt(1, 10));
        }
        return list;
    }

    private static int getMaximum(List<Integer> list) {
        int maximum = 0;
        for (int num : list) {
            maximum = Math.max(maximum, num);
        }
        return maximum;
    }

    private static int getMinimum(List<Integer> list) {
        int minimum = 0;
        for (int num : list) {
            minimum = Math.min(minimum, num);
        }
        return minimum;
    }

    private static double getAverage(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();
    }
}
