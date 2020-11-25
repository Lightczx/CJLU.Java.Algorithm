package DGP.CJLU.Experiment6;

import DGP.CJLU.Experiment4.Lab2.AvlTree;
import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.ArrayFactory;
import DGP.CJLU.Utils.Implementation.Rand;
import DGP.CJLU.Utils.Implementation.Searching;
import DGP.CJLU.Utils.Implementation.Sorting;

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
 * @author 16861
 */
public class Main {
    public static void main(String[] args){
        test(10000);
        test(50000);
        test(100000);
        test(500000);
        test(1000000);
        test(5000000);
        test(10000000);
    }

    private static void test(int range) {
        int n=new Rand().randomInt(0, range);
        Integer[] arr= ArrayFactory.randomArray(range);
        Integer[] arr2=ArrayFactory.incrementArray(range);
        AvlTree<Integer> tree=randomAvlTree(range);
        Hashtable<Integer,Integer> table=randomHashtable(range);

        new Dispatcher().run(()->{
            Searching.sequentialSearch(arr,n);
        }).pass(()->{
            Sorting.shellSort(arr);
        }).run(()->{
            Searching.binarySearch(arr2,n);
        }).run(()->{
            tree.contains(n);
        }).run(()->{
            table.contains(n);
        });
        System.out.println("Test range [ "+range+" ] completed.");
    }

    static AvlTree<Integer> randomAvlTree(int n){
        AvlTree<Integer> tree=new AvlTree<>();
        for (int i = 0; i < n; i++) {
            tree.insert(new Rand().randomInt(0,n));
        }
        return tree;
    }

    static Hashtable<Integer,Integer> randomHashtable(int n){
        Hashtable<Integer,Integer> table=new Hashtable<>();
        for (int i = 0; i < n; i++) {
            table.put(i,new Rand().randomInt(0,n));
        }
        return table;
    }


}
