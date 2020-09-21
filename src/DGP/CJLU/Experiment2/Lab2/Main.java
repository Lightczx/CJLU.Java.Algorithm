package DGP.CJLU.Experiment2.Lab2;

import DGP.CJLU.Utils.ExecuteTime;
import DGP.CJLU.Utils.Rand;
import DGP.CJLU.Utils.TwoList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        TwoList arrayLists=InitializeArrayList();
        TwoList linkedLists=InitializeLinkedList();
        //we don't want to count the initialize time
        new ExecuteTime().run(()->{
            GetIntersection(arrayLists);
        }).run(()->{
            arrayLists.L1.retainAll(arrayLists.L2);
        }).run(()->{
            GetIntersection(linkedLists);
        }).run(()->{
            linkedLists.L1.retainAll(linkedLists.L2);
        });
    }

    private static TwoList InitializeArrayList(){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int i=1;i<=10;i++)
            list1.add(i);
        for(int j=5;j<=15;j++)
            list2.add(j);
        return new TwoList(list1,list2,new ArrayList<>());
    }

    private static TwoList InitializeLinkedList(){
        LinkedList<Integer> list1 =new LinkedList<>();
        LinkedList<Integer> list2 =new LinkedList<>();
        for(int i=1;i<=10;i++)
            list1.add(i);
        for(int j=1;j<=5;j++)
            list2.add(Rand.randInt(1,10));
        return new TwoList(list1,list2,new LinkedList<>());
    }

    private static void GetIntersection(TwoList twoList){
        for (int num:twoList.L1) {
            if(twoList.L2.contains(num))
                twoList.Result.add(num);
        }
    }

}
