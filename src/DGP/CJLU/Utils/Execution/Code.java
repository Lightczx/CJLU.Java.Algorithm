package DGP.CJLU.Utils.Execution;

/**
 * represent a bunch of code to run
 * @author 16861
 */
@FunctionalInterface
public interface Code {
    /**
     * invoke the code
     */
    void invoke();
}
