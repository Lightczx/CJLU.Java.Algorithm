package DGP.CJLU.Utils.Execution;

/**
 * represent a bunch of code to run
 */
@FunctionalInterface
public interface Code {
    /**
     * invoke the code
     */
    void invoke();
}
