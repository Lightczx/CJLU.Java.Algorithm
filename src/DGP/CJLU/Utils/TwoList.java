package DGP.CJLU.Utils;

import java.util.AbstractList;

/**
 * 代表封装了两个List与一个结果类型List的类
 * ArrayList与LinkedList均继承自AbstractList
 */
public class TwoList {
    public AbstractList<Integer> L1;
    public AbstractList<Integer> L2;
    //type limit
    public AbstractList<Integer> Result;
    public TwoList(AbstractList<Integer> L1, AbstractList<Integer> L2,AbstractList<Integer> Result){
        this.L1=L1;
        this.L2=L2;
        this.Result=Result;
    }
}
