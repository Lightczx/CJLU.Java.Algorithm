package DGP.CJLU.Experiment8;

import DGP.CJLU.Utils.Implementation.ArrayFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Graph<T> {
    private int count=0;
    private int[][] dataArray;
    private final Map<T,Integer> dictionary =new HashMap<>();
    private int usedNum =0;

    public Graph(int vCount){
        this.count=vCount;
        dataArray =new int[count][count];
    }

    private int getMapped(T key){
        if(!dictionary.containsKey(key)){
            dictionary.put(key, usedNum++);
        }
        return dictionary.get(key);
    }

    private T getKey(int value){
        for (Map.Entry<T, Integer> entry : dictionary.entrySet()) {
            if (value==entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void link(T from,T to){
        if(usedNum>count) {
            throw new IllegalStateException("插入的元素超出限制个数");
        }

        int index1,index2;
        index1= getMapped(from);
        index2= getMapped(to);

        dataArray[index1][index2]=1;
    }

    @SuppressWarnings("unchecked")
    public T[] topSort(){
        int[][] copy= ArrayFactory.copy(dataArray);
        T[] result=(T[])new Object[count];
        for(int i=0;i<count;i++){
            T element=findEntry(copy);
            deleteEntry(copy,element);
            result[i]=element;
        }

        return result;
    }

    private void deleteEntry(int[][] copy,T element) {
        int row=getMapped(element);
        Arrays.fill(dataArray[row], 0);
    }

    private T findEntry(int[][] copy) {
        //each column
        for(int i=0;i<count;i++){
            //each row
            int sum=0;
            for(int j=0;j<count;j++){
                if(dataArray[j][i]!=0)
                    sum+=dataArray[j][i];
            }
            if(sum==0){
                for(int k=0;k<count;k++){

                }
                return getKey(i);
            }

        }
        throw new IllegalStateException("不存在入度为0的元素");
    }

    private VertexEntry getEntry(ViewType type){
        return  null;
    }

    private class VertexEntry{
        public ViewType type;
    }

    private enum ViewType{
        in,
        out,
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("This Graph:\n");
        for (int[] line:dataArray){
            for(int element:line){
                sb.append(element).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
