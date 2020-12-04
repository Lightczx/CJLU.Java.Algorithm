package DGP.CJLU.Utils.Execution;

/**
 * counting the execute time of codes
 * use run method to counting<br/>
 * example usage:<br/>
 *  {@code new Dispatcher.run(()->{someFunc();})}
 * @author 16861
 */
public class Dispatcher {

    public Dispatcher(){

    }
    public Dispatcher(DispatcherOperations operations){

    }

    public Dispatcher(String loginfo){
        this.log(loginfo);
    }

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
        System.out.println("[" + functionName + "] execution takes " + takes() + " ns or " + (double) takes() / 1000000 + " ms");
    }

    private void printError(String functionName, Throwable throwable) {
        String s = throwable.getClass().getSimpleName();
        System.err.println("[" + functionName + "] threw a " + s);
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
     * execute some code packed by lambda function or local method reference and counts the running time
     *
     * @param name method name
     * @param code normally lambda function or a method reference to run
     * @return the executor can continue run code
     */
    public Dispatcher run(String name, Code code) {
        this.begin();
        code.invoke();
        this.end();

        printTimeTakes(name);
        return this;
    }

    /**
     * execute some code and do not count time
     *
     * @param code normally lambda function or a method reference to run
     * @return the executor can continue run code
     */
    public Dispatcher pass(Code code) {
        code.invoke();
        return this;
    }

    /**
     * execute some untrusted code packed by lambda function or local method reference and do try catch work for it
     * do not block code execution
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

    /**
     * execute some untrusted code packed by lambda function or local method reference and do try catch work for it
     * do not block code execution
     *
     * @param name method name
     * @param code normally lambda function or a method reference to run
     * @return the executor can continue run code
     */
    public Dispatcher tryRun(String name, Code code) {
        try {
            run(code);
        } catch (Throwable e) {
            printError(name, e);
        }
        return this;
    }

    public Dispatcher log(Object info) {
        System.out.println(info);
        return this;
    }

}
