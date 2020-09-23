package DGP.CJLU.Experiment2.Lab9;

import java.util.LinkedList;

public class Term {
    public int coefficient;
    public int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public boolean isSameOrderWith(Term term) {
        return term.exponent == exponent;
    }

    public Term add(Term term) {
        return new Term(coefficient + term.coefficient, exponent);
    }

    public Term multiply(Term term) {
        return new Term(coefficient * term.coefficient, exponent + term.exponent);
    }

    public Polynomial multiply(Polynomial polynomial) {
        LinkedList<Term> result = new LinkedList<>();
        for (Term term : polynomial.getTerms()) {
            result.add(this.multiply(term));
        }
        return new Polynomial(result);
    }

    public boolean isPositive() {
        return coefficient > 0;
    }

    public boolean isNegative() {
        return coefficient < 0;
    }

    /**
     * code committed partially by Sun jiatao
     *
     * @return the string representation of the term
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //系数为0
        if (coefficient == 0) {
            return null;
        }
        //当系数不为±1时,追加系数
        /*if(coefficient!=1&&coefficient!=-1){
            sb.append(coefficient);
        }*/
        //当次数为0时，需要追加±1
        if (exponent == 0) {
            sb.append(coefficient);
        }
        //当次数不为0时追加x{
        else {
            if (coefficient == -1) {
                sb.append("-");
            }
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
