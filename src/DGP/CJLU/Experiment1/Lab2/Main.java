package DGP.CJLU.Experiment1.Lab2;

import DGP.CJLU.Utils.Dispatcher;

/**
 * Write functions to calculate factorial of N integers.
 * a)	Use iterative method
 * b)	Use recursive method
 * c)	Run	program	(a)	for	N=1000,	10000,100000;	program	(b)	for	N=1000,10000,100000,1000000.
 * d)	When will the exception java.lang.StackOverflowError occur of program (b)?
 * e)	Compare the actual running times.
 */
public class Main {
    public static void main(String[] args) {
        //2 a 1000
        new Dispatcher().run(() -> {
            factorial1(1000);
        }).run(() -> {
            factorial1(10000);
        }).run(() -> {
            factorial1(100000);
        }).run(() -> {
            factorial2(1000);
        }).run(() -> {
            factorial2(10000);
        }).run(() -> {
            factorial2(100000);
        });
    }

    public static long factorial1(long n) {
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorial2(long n) {
        if (n == 1)
            return 1;
        return n * factorial2(n - 1);
    }
}
