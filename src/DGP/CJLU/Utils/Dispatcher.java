package DGP.CJLU.Utils;

/**
 * counting the execute time of codes
 * use run method to counting
 */
public class Dispatcher {

    private long beginTime;
    private long endTime;

    private void begin() {
        beginTime = System.nanoTime();
    }

    private void end() {
        endTime = System.nanoTime();
    }

    private long takes() {
        return endTime - beginTime;
    }

    private void printTimeTakes(String functionName) {
        System.out.println("function [" + functionName + "] execution takes " + takes() + " ns or " + (double) takes() / 1000000 + " ms");
    }

    private void printError(String functionName, Throwable throwable) {
        String s = throwable.getClass().toString().substring(6);
        System.err.println("function [" + functionName + "] threw a " + s);
    }

    /**
     * execute some code packed by lambda function or local method reference and counts the running time
     *
     * @param code normally lambda function or a method reference to run
     * @return the executor can continue run code
     */
    public Dispatcher run(Code code) {
        this.begin();
        code.invoke();
        this.end();

        String methodName = code.getClass().getSimpleName();
        printTimeTakes(methodName);
        return this;
    }

    /**
     * execute some untrusted code packed by lambda function or local method reference and do try catch work for it
     *
     * @param code normally lambda function or a method reference to run
     * @return the executor can continue run code
     */
    public Dispatcher tryRun(Code code) {
        String methodName = code.getClass().getSimpleName();
        try {
            run(code);
        } catch (Throwable e) {
            printError(methodName, e);
        }
        return this;
    }

}
