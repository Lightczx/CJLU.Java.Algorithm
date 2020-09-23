package DGP.CJLU.Utils;

/**
 * counting the execute time of codes
 * use run method to counting
 */
public class ExecuteTime {
    private long beginTime;
    private long endTime;

    private void begin() {
        beginTime = System.nanoTime();
    }

    private void end() {
        endTime = System.nanoTime();
    }

    public long takes() {
        return endTime - beginTime;
    }

    private void printTimeTakes(String functionName) {
        System.out.println("function " + functionName + " execution takes " + takes() + " nanoseconds");
    }

    /**
     * execute some code packed by lambda function or local method and counts the running time
     *
     * @param code normally lambda function or a method reference to run
     * @return the executor can continue run code
     */
    public ExecuteTime run(Code code) {
        this.begin();
        code.Run();
        this.end();

        String methodName = code.getClass().getSimpleName();
        printTimeTakes(methodName);
        return this;
    }
}
