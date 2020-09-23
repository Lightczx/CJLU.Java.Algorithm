package DGP.CJLU.Experiment1.Lab3;

import DGP.CJLU.Utils.ExecuteTime;

public class Main {
    public static void main(String[] args) {
        new ExecuteTime().run(() -> {
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
        if (n == 1 || n == 2)
            return 1;
        return fib2(n - 1) + fib2(n - 2);
    }
}
