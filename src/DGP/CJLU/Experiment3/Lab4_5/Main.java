package DGP.CJLU.Experiment3.Lab4_5;

/**
 * Write a program to evaluate an infix expression.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        Infix infix = new Infix("(12+(13*34))/5-(35+7)*8/4");
        System.out.println(infix.data);
        Suffix suffix = infix.toSuffix();
        System.out.println(suffix);
        System.out.println(suffix.evaluate());
    }
}
