package DGP.CJLU.Experiment7;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.ArrayFactory;

import static DGP.CJLU.Utils.Implementation.Sorting.*;

/**
 * Compare sorting performances of different algorithms: Write programs to sort N random integers
 * (N = 100, 1000, 5000, 10000, 50000, 100000,1000000) using selection, bubble, insertion, Shell,
 * heap, merge, quick, bucket and radix algorithms. And record the times used by these algorithms
 * in table 1, draw the curves of times with N (the X axis is the values of N, the Y axis is the
 * values of the running times) by Microsoft Excel or WPS.
 * <p>
 * You need ensure that different algorithms have the same input data sequence. For example,
 * for N=100, all the sorting algorithms should sort the same 100 integers. And the running time
 * excludes the process of generating N random integers. What’s more, please introduce your run
 * environment, including CPU, RAM, and Operation system.
 * <p>
 * You need submit the source code files, an Excel or WPS file which includes table 1, curves
 * and the run environment.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        test(100);
        test(1000);
        test(5000);
        test(10000);
        test(50000);
        test(100000);
        test(1000000);
    }

    static void test(int n) {
        Integer[] arr1 = ArrayFactory.randomArray(n);
        Integer[] arr2 = ArrayFactory.copy(arr1);
        Integer[] arr3 = ArrayFactory.copy(arr1);
        Integer[] arr4 = ArrayFactory.copy(arr1);
        Integer[] arr5 = ArrayFactory.copy(arr1);
        Integer[] arr6 = ArrayFactory.copy(arr1);
        Integer[] arr7 = ArrayFactory.copy(arr1);
        Integer[] arr8 = ArrayFactory.copy(arr1);
        Integer[] arr9 = ArrayFactory.copy(arr1);

        Dispatcher dp = new Dispatcher("===test range [ " + n + " ] started===");
        dp.run("selectionSort", () -> {
            selectionSort(arr1);
        }).run("bubbleSort", () -> {
            bubbleSort(arr2);
        }).run("insertionSort", () -> {
            insertionSort(arr3);
        }).run("shellSort", () -> {
            shellSort(arr4);
        }).run("heapsort", () -> {
            heapsort(arr5);
        }).run("mergeSort", () -> {
            mergeSort(arr6);
        }).run("quicksort", () -> {
            quicksort(arr7);
        }).run("bucketSort", () -> {
            bucketSort(arr8);
        }).run("radixSort", () -> {
            radixSort(arr9);
        }).log("===test range [ " + n + " ] completed===\n");
    }
}
