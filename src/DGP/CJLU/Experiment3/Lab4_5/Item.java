package DGP.CJLU.Experiment3.Lab4_5;

/**
 * @author 16861
 */
public class Item {

    public String value;

    public Item(String value) {
        this.value = value;
    }

    public Item(StringBuilder value) {
        this.value = value.toString();
    }

    public Item(char value) {
        this.value = String.valueOf(value);
    }

    public boolean isNumber() {
        return value.matches("\\d+");
    }

    public boolean isOperator() {
        return "+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value);
    }

    public boolean isLeftParentheses() {
        return "(".equals(value);
    }

    public boolean isRightParentheses() {
        return ")".equals(value);
    }

    public int priority() {
        if ("*".equals(value) || "/".equals(value)) {
            return 1;
        } else if ("+".equals(value) || "-".equals(value)) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return value;
    }
}
