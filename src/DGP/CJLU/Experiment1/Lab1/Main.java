package DGP.CJLU.Experiment1.Lab1;

import DGP.CJLU.Utils.ExecuteTime;

public class Main {

    public static void main(String[] args) {

        new ExecuteTime().run(() -> {
            sum1(1000);
        }).run(() -> {
            sum1(10000);
        }).run(() -> {
            sum1(100000);
        }).run(() -> {
            sum2(1000);
        }).run(() -> {
            sum2(10000);
        }).run(() -> {
            //StackOverflowError
            sum2(100000);
        }).run(() -> {
            //StackOverflowError
            sum2(100000);
        });
    }

    public static long sum1(long n) {
        long result = 0;
        for (long i = 1; i <= n; i++)
            result += i;
        return result;
    }

    public static long sum2(long n) {
        if (n == 1)
            return 1;
        return sum2(n - 1) + n;
    }
}
