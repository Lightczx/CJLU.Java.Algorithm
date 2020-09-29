package DGP.CJLU.Experiment2.Lab9;

import DGP.CJLU.Utils.ExecuteTime;

/**
 * 9.	Write a program to add and multiply(optional) two polynomials. The polynomial has the
 * following form:P ( x ) = a1x e1 + ... + an x en Where ai is the coefficient, ei is the exponent
 * and ei is non-negative integer. Test your program using two example polynomials:
 * P1(x) = 10x1000+5x14+1 and P2(x) = 3x1990+2x1492+11x+5.And more test examples should be used.
 */
public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial("10x^1000+5x^14+1");
        Polynomial p2 = new Polynomial("3x^1990-2x^1492+11x+5");

        System.out.println(p1);
        System.out.println(p2);
        new ExecuteTime().run(() -> {
            System.out.println(p1.add(p2).toString());
            System.out.println(p1.multiply(p2).toString());

        });
    }
}
