package DGP.CJLU.Experiment1.Lab3;

import DGP.CJLU.Utils.Execution.Dispatcher;

/**
 * Write functions to calculate the N-th Fibonacci number.
 * a)	Use iterative method
 * b)	Use recursive method
 * c)	Run	program	(a)	for	N=1000,	10000,100000;	program	(b)	for	N=1000,10000,100000,1000000.
 * d)	When will the exception java.lang.StackOverflowError occur of program (b)?
 * e)	Compare the actual running times.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        new Dispatcher().run(() -> {
            fib1(1000);
        }).run(() -> {
            fib1(10000);
        }).run(() -> {
            fib1(100000);
        }).run(() -> {
            fib2(1000);
        }).run(() -> {
            fib2(10000);
        }).run(() -> {
            fib2(100000);
        }).run(() -> {
            fib2(1000000);
        });
    }

    public static long fib1(long n) {
        long a = 1, b = 1;
        long c = 1;
        for (long i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static long fib2(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }
}
