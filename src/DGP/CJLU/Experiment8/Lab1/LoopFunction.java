package DGP.CJLU.Experiment8.Lab1;

/**
 * @author 16861
 */
@FunctionalInterface
public interface LoopFunction{
    /**
     * loop function
     * @param v
     */
    void invoke(Graph.Vertex v);
}
