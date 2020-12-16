package DGP.CJLU.Experiment8.Lab3;

import DGP.CJLU.Experiment8.Lab1.Graph;
import DGP.CJLU.Utils.Execution.Dispatcher;

/**
 * Write a program to implement Prim’s algorithm to get a minimum spanning tree from the graph in Figure 7.3, and write out the result.
 * @author 16861
 */
public class Main {
    public static void main(String[] args){
        Graph<String> graph=new Graph<>(6,false);
        graph.link("A","B",2);
        graph.link("A","C",5);
        graph.link("A","D",30);
        graph.link("B","C",15);
        graph.link("B","E",8);
        graph.link("C","F",7);
        graph.link("D","E",4);
        graph.link("D","F",10);
        graph.link("E","F",18);
        new Dispatcher().log(graph);

    }
}
