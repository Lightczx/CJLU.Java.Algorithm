package DGP.CJLU.Experiment3.Lab4_5;

/**
 * @author 16861
 */
public class Item {
    public String value;

    public Item(String value) {
        this.value = value;
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
        return switch (value) {
            case "*", "/" -> 1;
            case "+", "-" -> 0;
            default -> -1;
        };
    }

    @Override
    public String toString() {
        return value;
    }
}
