package DGP.CJLU.Experiment8.Lab1;

/**
 * @author 16861
 */
@FunctionalInterface
interface LoopFunction<T> {
    /**
     * loop function
     *
     * @param v the vertex
     */
    void invoke(Graph<T>.Vertex v);
}
