package DGP.CJLU.Experiment8.Lab1;

import DGP.CJLU.Experiment8.Lab1.Graph;
import DGP.CJLU.Utils.Execution.Dispatcher;

import java.util.Arrays;

/**
 * 1.	Using the graph as figure 7.1,
 * a)	Write out the results of topological sorting
 * b)	Write a program to perform a topological sort according to the pseudocode showed in Figure 9.7 in the textbook.

 * @author 16861
 */
public class Main {
    public static void main(String[] args){
        Graph<String> graph=new Graph<>(6);
        graph.link("A","C");
        graph.link("A","D");
        graph.link("B","E");
        graph.link("C","B");
        graph.link("C","F");
        graph.link("E","D");
        graph.link("F","D");
        graph.link("F","E");
        new Dispatcher().log(graph).log(Arrays.toString(graph.topSort()));
    }
}
