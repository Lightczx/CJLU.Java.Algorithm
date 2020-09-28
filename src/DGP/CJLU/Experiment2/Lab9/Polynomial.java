package DGP.CJLU.Experiment2.Lab9;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Term> terms;

    /**
     * get the shallow copy of terms
     * @return
     */
    @SuppressWarnings("unchecked")
    public LinkedList<Term> getCopiedTerms() {
        return (LinkedList<Term>) terms.clone();
    }

    public Polynomial() {
        this.terms = new LinkedList<>();
    }

    public Polynomial(LinkedList<Term> terms) {
        this.terms = terms;
    }

    public void addTerm(Term term) {
        terms.add(term);
    }

    public void addTerm(int c, int e) {
        terms.add(new Term(c, e));
    }

    public Polynomial add(Polynomial polynomial) {
        LinkedList<Term> ta = getCopiedTerms();
        LinkedList<Term> tb = polynomial.getCopiedTerms();

        LinkedList<Term> result = new LinkedList<>();
        for (Term t1 : ta) {
            Iterator<Term> iter = tb.iterator();
            while (iter.hasNext()) {
                Term t2 = iter.next();
                if (t1.isSameOrderWith(t2)) {
                    t1 = t1.add(t2);
                    iter.remove();
                }
            }
            result.add(t1);
        }
        result.addAll(tb);
        return new Polynomial(result).normalize();
    }

    /**
     * sort the LinkedList in descending order
     * @param ts terms
     */
    private void sort(LinkedList<Term> ts) {
        ts.sort((o1, o2) -> Integer.compare(o2.exponent, o1.exponent));
    }

    public Polynomial multiply(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        LinkedList<Polynomial> temp = new LinkedList<>();
        for (Term a : terms)
            temp.add(a.multiply(polynomial));
        for (Polynomial p : temp)
            result = result.add(p);

        return result.normalize();
    }

    public Polynomial normalize() {
        LinkedList<Term> temp1 = getCopiedTerms();
        LinkedList<Term> result = new LinkedList<>();

        for (Term t1 : temp1) {
            for (Term t2 : result) {
                if (t1.isSameOrderWith(t2)) {
                    t1 = t1.add(t2);
                }
            }
            result.add(t1);
        }
        sort(result);
        return new Polynomial(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Term> iterator = terms.iterator();
        boolean isFirst = true;
        while (iterator.hasNext()) {
            Term t = iterator.next();
            if (isFirst) {
                if (t.toString() != null) {
                    sb.append(t.toString());
                    isFirst = false;
                }
            } else {
                if (t.isPositive())
                    sb.append("+");
                if (t.toString() != null)
                    sb.append(t.toString());
            }
        }
        return sb.toString();
    }
}
