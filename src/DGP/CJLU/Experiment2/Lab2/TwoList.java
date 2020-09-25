package DGP.CJLU.Experiment2.Lab2;

import java.util.List;

/**
 * 代表封装了两个List与一个结果类型List的类
 * ArrayList与LinkedList均继承自AbstractList
 */
public class TwoList {
    public List<Integer> L1;
    public List<Integer> L2;
    //type limit
    public List<Integer> Result;

    public TwoList(List<Integer> L1, List<Integer> L2, List<Integer> Result) {
        this.L1 = L1;
        this.L2 = L2;
        this.Result = Result;
    }
}
