package DGP.CJLU.Experiment2.Lab2;

import java.util.AbstractList;

public class TwoList {
    AbstractList<Integer> L1;
    AbstractList<Integer> L2;
    //type limit
    AbstractList<Integer> Result;
    public TwoList(AbstractList<Integer> L1, AbstractList<Integer> L2,AbstractList<Integer> Result){
        this.L1=L1;
        this.L2=L2;
        this.Result=Result;
    }
}
