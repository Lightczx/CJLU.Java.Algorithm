package DGP.CJLU.Experiment1.Lab4;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.Rand;
import DGP.CJLU.Utils.Implementation.Sorting;

/**
 * Suppose you need to generate a random permutation of the first N integers. For example,
 * {4,3,1,5,2} and {3,1,4,2,5} are legal permutations,but {5,4,1,2,1 is not, because one number （1）
 * is duplicated and another (3) is missing. This routine is often used in simulation of algorithms.
 * We assume the existence of a random number generator, r, with method randInt(i,j), that generates
 * integers between i and j with equal probability.
 * Here are three algorithms:
 * a)	Fill the array a from a[0] to a[n-1] as follows: To fill a[i], generate random numbers until
 * you get one that is not already in a[0], a[1],......, a[i-1].
 * b)	Same as algorithm (a), but keep an extra array called the used array. When a random number,
 * ran, is first put in the array a, set used[ran] = true.This means that when filling a[i]
 * with a random number, you can test in one step to see whether the random number has been
 * used, instead of the (possibly) i steps in the first algorithm.
 * c)	Fill the array such that	a[i] = i + 1. Then
 * for( i = 1; i<n; i++)
 * swapReferences( a[i], a[ randInt(0,i) ] );
 * d)	Complete the following tasks.
 * i.	Write the time complexity of each algorithm.
 * ii.	Write (separate) programs to execute each algorithm 10 times, to get a good average.
 * Run program (a) for N=1000, 5000, 10000;
 * program (b) for N=10000, 50000, 100000, 500000, 1000000;
 * program (c) for N=1000000, 5000000, 10000000.
 * iii.Compare your analysis with the actual running times.
 * iv.	What is the worst-case running time of each algorithm?
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        //a
        new Dispatcher().run(() -> {
            rng1(1000);
        });
        new Dispatcher().run(() -> {
            rng1(5000);
        });
        new Dispatcher().run(() -> {
            rng1(10000);
        });
        //b
        new Dispatcher().run(() -> {
            rng2(10000);
        });
        new Dispatcher().run(() -> {
            rng2(50000);
        });
        new Dispatcher().run(() -> {
            rng2(100000);
        });
        new Dispatcher().run(() -> {
            rng2(500000);
        });
        new Dispatcher().run(() -> {
            rng2(1000000);
        });
        //c
        new Dispatcher().run(() -> {
            rng3(1000000);
        });
        new Dispatcher().run(() -> {
            rng3(5000000);
        });
        new Dispatcher().run(() -> {
            rng3(10000000);
        });
    }

    public static void rng1(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Rand().randomInt(1, n);
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    i--;
                    break;
                }
            }
        }
    }

    public static void rng2(int n) {
        int[] arr = new int[n];
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int value = new Rand().randomInt(1, n);
            if (!used[value]) {
                arr[i] = value;
                used[value] = true;
            } else {
                i--;
            }
        }
    }

    public static void rng3(int n) {
        Integer[] arr = new Integer[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for (int j = 1; j < n; j++) {
            Sorting.swapReferences(arr, arr[j], arr[new Rand().randomInt(0, j)]);
        }
    }

}
