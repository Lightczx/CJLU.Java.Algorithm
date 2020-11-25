package DGP.CJLU.Experiment7;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.ArrayFactory;
import DGP.CJLU.Utils.Implementation.Sorting;

import java.util.Arrays;

/**
 * Compare sorting performances of different algorithms: Write programs to sort N random integers
 * (N = 100, 1000, 5000, 10000, 50000, 100000,1000000) using selection, bubble, insertion, Shell,
 * heap, merge, quick, bucket and radix algorithms. And record the times used by these algorithms
 * in table 1, draw the curves of times with N (the X axis is the values of N, the Y axis is the
 * values of the running times) by Microsoft Excel or WPS.
 *
 * You need ensure that different algorithms have the same input data sequence. For example,
 * for N=100, all the sorting algorithms should sort the same 100 integers. And the running time
 * excludes the process of generating N random integers. What’s more, please introduce your run
 * environment, including CPU, RAM, and Operation system.
 *
 * You need submit the source code files, an Excel or WPS file which includes table 1, curves
 * and the run environment.
 * @author Administrator
 */
public class Main {
    public static void main(String[] args){
        test(100);
    }

    static void test(int n){
        Integer[] arr1 = ArrayFactory.randomArray(n);
        Integer[] arr2 = Arrays.copyOf(arr1,n);
        Integer[] arr3 = Arrays.copyOf(arr1,n);
        Integer[] arr4 = Arrays.copyOf(arr1,n);
        Integer[] arr5 = Arrays.copyOf(arr1,n);
        Integer[] arr6 = Arrays.copyOf(arr1,n);
        Integer[] arr7 = Arrays.copyOf(arr1,n);
        Integer[] arr8 = Arrays.copyOf(arr1,n);
        Integer[] arr9 = Arrays.copyOf(arr1,n);

        new Dispatcher().run(()->{
            Sorting.selectionSort(arr1);
        }).run(()->{
            Sorting.bubbleSort(arr2);
        }).run(()->{
            Sorting.insertionSort(arr3);
        }).run(()->{
            Sorting.shellSort(arr4);
        }).run(()->{
            Sorting.heapsort(arr5);
        }).run(()->{
            Sorting.mergeSort(arr6);
        }).run(()->{
            Sorting.quicksort(arr7);
        }).run(()->{
            //Sorting.bucket
        }).run(()->{
            //radix
        });


    }
}
