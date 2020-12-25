package DGP.CJLU.CourseDesign;

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

    /**
     * 只能判断整数
     * @return true if value is integer
     */
    public boolean isInteger() {
        return value.matches("-*\\d+(\\.\\d+)?");
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

    /**
     * the priority of item
     * @return
     */
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
