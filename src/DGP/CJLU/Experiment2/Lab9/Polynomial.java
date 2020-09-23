package DGP.CJLU.Experiment2.Lab9;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Term> terms;

    public LinkedList<Term> getTerms() {
        return terms;
    }

    public Polynomial() {
        LinkedList<Term> terms = new LinkedList<>();
        terms.add(new Term(0, 0));
        this.terms = terms;
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
        LinkedList<Term> terms1 = (LinkedList<Term>) terms.clone();
        LinkedList<Term> terms2 = (LinkedList<Term>) polynomial.terms.clone();
        LinkedList<Term> result = new LinkedList<>();
        for (Iterator<Term> iterator = terms1.iterator(); iterator.hasNext(); ) {
            Term t1 = iterator.next();
            for (Iterator<Term> iter = terms2.iterator(); iter.hasNext(); ) {
                Term t2 = iter.next();
                if (t1.isSameOrderWith(t2)) {
                    t1 = t1.add(t2);
                    iter.remove();
                }
            }
            result.add(t1);
        }
        result.addAll(terms2);
        sort(result);
        return new Polynomial(result).unify();
    }

    private void sort(LinkedList<Term> ts) {
        ts.sort((o1, o2) -> {
            return Integer.compare(o2.exponent, o1.exponent);
        });
    }

    public Polynomial multiply(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        LinkedList<Polynomial> temp = new LinkedList<>();
        for (Term a : terms)
            temp.add(a.multiply(polynomial));
        for (Polynomial p : temp)
            result = result.add(p);

        return result.unify();
    }

    private Polynomial unify() {
        LinkedList<Term> temp1 = (LinkedList<Term>) terms.clone();
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
