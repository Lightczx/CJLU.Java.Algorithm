package DGP.CJLU.Experiment2.Lab9;

import java.util.LinkedList;

public class Term {
    public int coefficient;
    public int exponent;

    public Term(int c, int e) {
        this.coefficient = c;
        this.exponent = e;
    }

    public boolean isSameOrderWith(Term term) {
        return term.exponent == exponent;
    }

    public Term add(Term term) {
        return new Term(coefficient + term.coefficient, exponent);
    }

    /**
     * a term multiplies a term gets a term
     * @param term provide a term
     * @return result
     */
    public Term multiply(Term term) {
        return new Term(coefficient * term.coefficient, exponent + term.exponent);
    }

    /**
     * a term multiplies a polynomial gets a polynomial
     * @param polynomial provide a polynomial
     * @return result polynomial
     */
    public Polynomial multiply(Polynomial polynomial) {
        LinkedList<Term> result = new LinkedList<>();
        for (Term term : polynomial.getCopiedTerms())
            result.add(this.multiply(term));
        return new Polynomial(result);
    }

    public boolean isPositive() {
        return coefficient > 0;
    }

    /**
     * code tested by 1900303204 jiatao Sun
     * @return the string representation of the term
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //系数为0
        if (coefficient == 0) {
            return null;
        }
        //当次数为0时，需要追加±1
        if (exponent == 0) {
            sb.append(coefficient);
        }
        //当次数不为0时追加x{
        else {
            if (coefficient == -1) {
                sb.append("-");
            }
            //当系数不为±1时,追加系数
            if (coefficient != 1 && coefficient != -1) {
                sb.append(coefficient);
            }
            sb.append("x");
            //当次数不为1时需追加次数
            if (exponent != 1) {
                sb.append("^");
                sb.append(exponent);
            }
        }
        return sb.toString();
    }
}
