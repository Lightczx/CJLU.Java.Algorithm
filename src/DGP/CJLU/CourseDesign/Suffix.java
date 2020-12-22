package DGP.CJLU.CourseDesign;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author 16861
 */
public class Suffix extends Expression {
    public double evaluate() {
        Stack<Double> stack = new Stack<>();
        for (Item item : items) {
            if (item.isNumber()) {
                //是数字
                stack.push(Double.parseDouble(item.value));
            } else {
                //是操作符，取出栈顶两个元素
                double num2 = stack.pop();
                double num1 = stack.isEmpty()?0: stack.pop();
                double res = switch (item.value) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new IllegalArgumentException("表达式包含非法运算符");
                };
                stack.push(res);
            }
        }
        return stack.pop();
    }

    @Override
    public String toString() {
        Iterator<Item> it = items.iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            Item e = it.next();
            sb.append(e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(' ');
        }
    }
}
