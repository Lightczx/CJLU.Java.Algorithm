package DGP.CJLU.Experiment2.Lab9;

import DGP.CJLU.Utils.ExecuteTime;

import java.util.LinkedList;

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
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p1.add(p2).toString());
            System.out.println(p1.multiply(p2).toString());
        });
    }
}
