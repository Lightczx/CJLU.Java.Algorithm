package DGP.CJLU.Experiment3.Lab4_5;

import java.util.Iterator;
import java.util.Stack;

public class Suffix extends Expression {
    public double evaluate() {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < data.size(); i++) {
            Item item = data.get(i);
            if (item.isNumber()) {
                //是数字
                stack.push(Double.parseDouble(item.value));
            } else {
                //是操作符，取出栈顶两个元素
                double num2 = stack.pop();
                double num1 = stack.pop();
                double res = 0;
                if (item.value.equals("+")) {
                    res = num1 + num2;
                } else if (item.value.equals("-")) {
                    res = num1 - num2;
                } else if (item.value.equals("*")) {
                    res = num1 * num2;
                } else if (item.value.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new IllegalArgumentException("表达式包含非法运算符");
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    @Override
    public String toString() {
        Iterator<Item> it = data.iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            Item e = it.next();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(' ');
        }
    }
}
