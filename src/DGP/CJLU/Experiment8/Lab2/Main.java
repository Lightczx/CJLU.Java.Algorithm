package DGP.CJLU.Experiment8.Lab2;

import DGP.CJLU.Experiment8.Lab1.Graph;
import DGP.CJLU.Utils.Execution.Dispatcher;

/**
 * Write a program to implement Dijkstra’s algorithm to solve the single-source shortest
 * path problem(the source is A) of the graph in Figure 7.2, and write out the results.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args){
        Graph<String> graph=new Graph<>(6,true);
        graph.link("A","C",5);
        graph.link("A","D",30);
        graph.link("B","A",2);
        graph.link("B","E",8);
        graph.link("C","B",15);
        graph.link("C","F",7);
        graph.link("E","D",4);
        graph.link("F","D",10);
        graph.link("F","E",18);
        new Dispatcher().log(graph);
        graph.shortestPath("A");
        graph.printAllPath();
    }
}
