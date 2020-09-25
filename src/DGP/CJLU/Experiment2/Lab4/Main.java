package DGP.CJLU.Experiment2.Lab4;

import DGP.CJLU.Utils.Implementation.Rand;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Compute the maximum, minimum and average value of a list. LinkedList and ArrayList should be used.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = InitializeArrayList();
        GetMaximum(arrayList);
        GetMinimum(arrayList);
        GetAverage(arrayList);

        LinkedList<Integer> linkedList = InitializeLinkedList();
        GetMaximum(linkedList);
        GetMinimum(linkedList);
        GetAverage(linkedList);
    }

    private static ArrayList<Integer> InitializeArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 5; j <= 15; j++)
            list.add(j);
        return list;
    }

    private static LinkedList<Integer> InitializeLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 1; j <= 10; j++)
            list.add(Rand.randInt(1, 10));
        return list;
    }

    private static int GetMaximum(List<Integer> list) {
        int maximum = 0;
        for (int num : list) {
            maximum = Math.max(maximum, num);
        }
        return maximum;
    }

    private static int GetMinimum(List<Integer> list) {
        int minimum = 0;
        for (int num : list) {
            minimum = Math.min(minimum, num);
        }
        return minimum;
    }

    private static double GetAverage(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();
    }
}
