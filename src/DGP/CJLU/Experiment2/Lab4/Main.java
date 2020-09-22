package DGP.CJLU.Experiment2.Lab4;

import DGP.CJLU.Utils.Implementation.Rand;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=InitializeArrayList();
        GetMaximum(arrayList);
        GetMinimum(arrayList);
        GetAverage(arrayList);

        LinkedList<Integer> linkedList =InitializeLinkedList();
        GetMaximum(linkedList);
        GetMinimum(linkedList);
        GetAverage(linkedList);
    }

    private static ArrayList<Integer> InitializeArrayList(){
        ArrayList<Integer> list=new ArrayList<>();
        for(int j=5;j<=15;j++)
            list.add(j);
        return list;
    }

    private static LinkedList<Integer> InitializeLinkedList(){
        LinkedList<Integer> list =new LinkedList<>();
        for(int j=1;j<=10;j++)
            list.add(Rand.randInt(1,10));
        return list;
    }

    private static int GetMaximum(AbstractList<Integer> list){
        int maximum=0;
        for (int num:list) {
            maximum = Math.max(maximum, num);
        }
        return maximum;
    }

    private static int GetMinimum(AbstractList<Integer> list){
        int minimum=0;
        for (int num:list) {
            minimum = Math.min(minimum, num);
        }
        return minimum;
    }

    private static double GetAverage(AbstractList<Integer> list){
        int sum=0;
        for (int num:list) {
            sum+=num;
        }
        return (double)sum/list.size();
    }
}
