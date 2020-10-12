package DGP.CJLU.Experiment2.Lab9;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    private final LinkedList<Term> terms;

    /**
     * get the shallow copy of terms
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public LinkedList<Term> getCopiedTerms() {
        return (LinkedList<Term>) terms.clone();
    }

    private Polynomial() {
        terms = new LinkedList<>();
    }

    public Polynomial(String polynomial) {
        String[] strs = polynomial.replace("-", "+-").split("\\+");
        terms = new LinkedList<>();
        for (String s : strs)
            if (!s.isEmpty())
                terms.add(new Term(s));
    }

    /**
     * init with list sort
     *
     * @param terms
     */
    public Polynomial(LinkedList<Term> terms) {
        sort(terms);
        this.terms = terms;
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

    public Polynomial multiply(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        LinkedList<Polynomial> temp = new LinkedList<>();
        for (Term a : terms)
            temp.add(a.multiply(polynomial));
        for (Polynomial p : temp)
            result = result.add(p);

        return result;
    }

    /**
     * sort the LinkedList in descending order / O(n2)
     *
     * @param ts terms
     */
    private void sort(LinkedList<Term> ts) {
        ts.sort((o1, o2) -> Integer.compare(o2.exponent, o1.exponent));
    }

    public Polynomial normalize() {
        LinkedList<Term> copy = getCopiedTerms();
        LinkedList<Term> result = new LinkedList<>();

        for (Term t1 : copy) {
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
