package DGP.CJLU.Experiment1.Lab4;

import DGP.CJLU.Utils.ExecuteTime;
import DGP.CJLU.Utils.Rand;

public class Main {
    public static void main(String[] args) {
        //a
        new ExecuteTime().run(()->{
            rng1(1000);
        });
        new ExecuteTime().run(()->{
            rng1(5000);
        });
        new ExecuteTime().run(()->{
            rng1(10000);
        });
        //b
        new ExecuteTime().run(()->{
            rng2(10000);
        });
        new ExecuteTime().run(()->{
            rng2(50000);
        });
        new ExecuteTime().run(()->{
            rng2(100000);
        });
        new ExecuteTime().run(()->{
            rng2(500000);
        });
        new ExecuteTime().run(()->{
            rng2(1000000);
        });
        //c
        new ExecuteTime().run(()->{
            rng3(1000000);
        });
        new ExecuteTime().run(()->{
            rng3(5000000);
        });
        new ExecuteTime().run(()->{
            rng3(10000000);
        });
    }

    public static void rng1(int n){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= Rand.randInt(1,n);
            for(int j=0;j<i;j++){
                if(arr[j]==arr[i]){
                    i--;
                    break;
                }
            }
        }
    }

    public static void rng2(int n){
        int[] arr=new int[n];
        boolean[] used=new boolean[n+1];
        for(int i=0;i<n;i++){
            int value=Rand.randInt(1,n);
            if(!used[value])
            {
                arr[i]= value;
                used[value]=true;
            }
            else
                i--;
        }
    }

    public static void rng3(int n){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        for( int j = 1; j<n; j++)
            swapReferences(arr, arr[j], arr[Rand.randInt(0,j-1)] );
    }

    public static void swapReferences(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
