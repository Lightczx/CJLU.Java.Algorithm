package DGP.CJLU.Experiment2.Lab9;

import DGP.CJLU.Utils.Execution.Dispatcher;

/**
 * 9.	Write a program to add and multiply(optional) two polynomials. The polynomial has the
 * following form:P ( x ) = a1x^e1 + ... + anx^en Where ai is the coefficient, ei is the exponent
 * and ei is non-negative integer. Test your program using two example polynomials:
 * P1(x) = 10x1000+5x14+1 and P2(x) = 3x1990+2x1492+11x+5.And more test examples should be used.
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial("10x^1000+5x^14+1");
        Polynomial p2 = new Polynomial("3x^1990-2x^1492+x+5");

        Polynomial p3 = new Polynomial("-237x^34+34x^384-78x-345");
        Polynomial p4 = new Polynomial("45x^4545-55x^4+3434x^33+55");
        System.out.println(p3);

        new Dispatcher().run(() -> {
            System.out.println(p1.add(p2).normalize().toString());
            System.out.println(p1.multiply(p2).normalize().toString());
        }).run(() -> {
            System.out.println(p3.add(p4).normalize().toString());
            System.out.println(p3.multiply(p4).normalize().toString());
        });
    }
}
