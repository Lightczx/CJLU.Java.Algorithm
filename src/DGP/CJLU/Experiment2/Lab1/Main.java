package DGP.CJLU.Experiment2.Lab1;

import DGP.CJLU.Utils.ExecuteTime;
import DGP.CJLU.Utils.Implementation.Rand;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ListPos lparray=InitializeArrayList();
        ListPos lplinked=InitializeLinkedList();
        new ExecuteTime().run(()->{
            PrintLots(lparray.List,lparray.Pos);
        }).run(()->{
            PrintLots(lplinked.List,lplinked.Pos);
        });
    }
    private static void PrintLots(AbstractList<Integer> l, AbstractList<Integer> p){
        for (int index:p) {
            System.out.println(l.get(index));
        }
    }

    private static ListPos InitializeArrayList(){
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> pos=new ArrayList<>();
        for(int i=1;i<=10;i++)
            list.add(i);
        for(int j=1;j<=5;j++)
            pos.add(Rand.randInt(1,9));
        return new ListPos(list,pos);
    }

    private static ListPos InitializeLinkedList(){
        LinkedList<Integer> list=new LinkedList<>();
        LinkedList<Integer> pos=new LinkedList<>();
        for(int i=1;i<=10;i++)
            list.add(i);
        for(int j=1;j<=5;j++)
            pos.add(Rand.randInt(1,9));
        return new ListPos(list,pos);
    }


}
