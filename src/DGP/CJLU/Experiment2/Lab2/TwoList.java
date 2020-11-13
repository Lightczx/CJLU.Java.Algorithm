package DGP.CJLU.Experiment2.Lab2;

import java.util.List;

/**
 * 代表封装了两个List与一个结果类型List的类
 * ArrayList与LinkedList均继承自AbstractList
 *
 * @author 16861
 */
public class TwoList {
    public List<Integer> l1;
    public List<Integer> l2;
    /**
     * type limit
     */
    public List<Integer> result;

    public TwoList(List<Integer> l1, List<Integer> l2, List<Integer> result) {
        this.l1 = l1;
        this.l2 = l2;
        this.result = result;
    }
}
