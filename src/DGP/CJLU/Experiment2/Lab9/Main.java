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
        Polynomial p1 = new Polynomial();
        p1.addTerm(10, 1000);
        p1.addTerm(5, 14);
        p1.addTerm(1, 0);

        Polynomial p2 = new Polynomial();
        p2.addTerm(3, 1990);
        p2.addTerm(-2, 1492);
        p2.addTerm(11, 1);
        p2.addTerm(5, 0);

        new ExecuteTime().run(() -> {
            System.out.println(p1.add(p2).toString());
            System.out.println(p1.multiply(p2).toString());
        });
    }
}
