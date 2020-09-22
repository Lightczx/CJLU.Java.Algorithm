package DGP.CJLU.Experiment2.Lab5;

import DGP.CJLU.Utils.Implementation.Rand;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
       LinkedList<Integer> list =InitializeLinkedList();
        for (int num:list) {
            System.out.println(num);
        }
    }

    private static LinkedList<Integer> InitializeLinkedList(){
        LinkedList<Integer> list =new LinkedList<>();
        for(int j=1;j<=10;j++)
            list.add(Rand.randInt(1,10));
        return list;
    }
}
