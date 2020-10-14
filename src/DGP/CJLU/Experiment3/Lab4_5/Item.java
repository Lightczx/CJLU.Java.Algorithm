package DGP.CJLU.Experiment3.Lab4_5;

public class Item {

    public boolean isNumber() {
        return value.matches("\\d+");
    }

    public boolean isOperator() {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    public boolean isLeftParentheses() {
        return "(".equals(value);
    }

    public boolean isRightParentheses() {
        return ")".equals(value);
    }

    public int priority() {
        if (value.equals("*") || value.equals("/")) {
            return 1;
        } else if (value.equals("+") || value.equals("-")) {
            return 0;
        }
        return -1;
    }

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

    @Override
    public String toString() {
        return value;
    }
}
