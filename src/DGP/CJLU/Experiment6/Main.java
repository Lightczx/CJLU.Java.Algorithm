package DGP.CJLU.Experiment6;

import DGP.CJLU.Experiment4.Lab2.AvlTree;
import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.ArrayFactory;
import DGP.CJLU.Utils.Implementation.Rand;
import DGP.CJLU.Utils.Implementation.Searching;

import java.util.Hashtable;

/**
 * Write a program to generate N random integers (N = 10000, 50000, 100000,500000,1000000,5000000,10000000) ,and
 * save them to appropriate data structures, then search a random integer in the data structures by the following
 * algorithms. And record the times used by these algorithms in table 1, draw the curves of runing times with N
 * (the axis X is the values of N, the axis Y is the values of the running times) by Microsoft Excel or WPS sheet.
 * a)	The Sequential search
 * b)	The binary search
 * c)	AVL tree
 * d)	The hash table
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        test(10000);
        test(50000);
        test(100000);
        test(500000);
        test(1000000);
        test(5000000);
        test(10000000);
    }

    private static void test(int range) {
        int n = new Rand().randomInt(0, range);
        Integer[] arr = ArrayFactory.randomArray(range);
        Integer[] arr2 = ArrayFactory.incrementArray(range);
        AvlTree<Integer> tree = randomAvlTree(range);
        Hashtable<Integer, Integer> table = randomHashtable(range);

        new Dispatcher().log("Test range [ " + range + " ] started").run("sequentialSearch", () -> {
            Searching.sequentialSearch(arr, n);
        }).run("binarySearch", () -> {
            Searching.binarySearch(arr2, n);
        }).run("AvlTree", () -> {
            tree.contains(n);
        }).run("Hashtable", () -> {
            table.contains(n);
        }).log("Test range [ " + range + " ] completed.\n");
    }

    private static AvlTree<Integer> randomAvlTree(int n) {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int num : ArrayFactory.randomArray(n)) {
            tree.insert(num);
        }
        return tree;
    }

    private static Hashtable<Integer, Integer> randomHashtable(int n) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int i = 0;
        for (int num : ArrayFactory.randomArray(n)) {
            table.put(i, num);
            i++;
        }
        return table;
    }
}
