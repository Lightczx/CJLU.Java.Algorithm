package DGP.CJLU.Experiment2.Lab6;

import DGP.CJLU.Utils.ExecuteTime;
import DGP.CJLU.Utils.Rand;

import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
    public static void main(String[] args) {
        new ExecuteTime().run(()->{
            LinkedList<Integer> linkedList=InitializeLinkedList();
            ListIterator fwd = linkedList.listIterator();
            ListIterator rev = linkedList.listIterator(linkedList.size());
            for (int i=0, mid=linkedList.size()>>1; i<mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        });

    }

    private static LinkedList<Integer> InitializeLinkedList(){
        LinkedList<Integer> list =new LinkedList<>();
        for(int j=1;j<=10;j++)
            list.add(Rand.randInt(1,10));
        return list;
    }
}
