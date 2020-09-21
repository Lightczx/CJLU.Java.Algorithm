package DGP.CJLU.Utils;

public class ExecuteTime {
    private long beginTime;
    private long endTime;

    private void begin(){
        beginTime = System.nanoTime();
    }

    private void end(){
        endTime = System.nanoTime();
    }

    public long takes(){
        return endTime - beginTime;
    }

    private void printTimeTakes(String functionName){
        System.out.println("function "+functionName+" execution takes " + takes()+" nanoseconds");
    }

    public ExecuteTime run(Code code){
        this.begin();
        code.Run();
        this.end();

        String methodName = code.getClass().getSimpleName();
        printTimeTakes(methodName);
        return this;
    }
}
