package DGP.CJLU.CourseDesign;

import java.util.Stack;

/**
 * @author 16861
 */
public class Infix extends Expression {

    /**
     * assume the expression is correct
     * only support (  ) + - * / operator
     * convert string expression to linked list element
     *
     * @param exprString the expression to be converted
     */
    public Infix(String exprString) {
        //remove space
        exprString = exprString.replace(" ", "");
        int i = 0;
        do {
            char c = exprString.charAt(i);
            //是操作符，直接添加至list中
            if (c == '+' || c == '*' || c == '/' || c == '(' || c == ')') {
                items.add(new Item(c));
                i++;
            } else if (c == '-') {
                Item last = items.isEmpty() ? null : items.getLast();
                if (last != null) {
                    if (last.isNumber()) {
                        items.add(new Item(c));
                        i++;
                    } else {
                        //-（）
                        StringBuilder str = new StringBuilder().append('-');
                        i++;
                        while (i < exprString.length() && Character.isDigit(exprString.charAt(i))) {
                            str.append(exprString.charAt(i));
                            i++;
                        }
                        items.add(new Item(str.toString()));
                    }
                } else {
                    //是负数
                    StringBuilder str = new StringBuilder().append('-');
                    i++;
                    while (i < exprString.length() && Character.isDigit(exprString.charAt(i))) {
                        str.append(exprString.charAt(i));
                        i++;
                    }
                    items.add(new Item(str.toString()));
                }
            } else if (Character.isDigit(c)) {
                //是数字,判断多位数的情况
                StringBuilder str = new StringBuilder();
                while (i < exprString.length() && Character.isDigit(exprString.charAt(i))) {
                    str.append(exprString.charAt(i));
                    i++;
                }
                items.add(new Item(str.toString()));
            } else {
                //非法输入
                throw new IllegalArgumentException("unexpected char");
            }
        } while (i < exprString.length());
        System.out.println("The items:" + items);
    }

    public Suffix toSuffix() {
        Stack<Item> stack = new Stack<>();
        Suffix result = new Suffix();
        for (Item item : items) {
            //运算数,直接输出.
            if (item.isNumber()) {
                result.items.add(item);
            }
            //左括号,压入堆栈
            else if (item.isLeftParentheses()) {
                stack.push(item);
                //右括号,(意味着括号已结束)不断弹出栈顶运算符并输出直到遇到左括号(弹出但不输出)
            } else if (item.isRightParentheses()) {
                while (!stack.peek().isLeftParentheses()) {
                    result.items.add(stack.pop());
                }
                //pop out left parentheses
                stack.pop();
                //运算符,将该运算符与栈顶运算符进行比较
            } else if (item.isOperator()) {
                if (!stack.isEmpty() && item.priority() <= stack.peek().priority()) {
                    while (!(stack.isEmpty() || item.priority() > stack.peek().priority())) {
                        result.items.add(stack.pop());
                    }
                }
                stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            result.items.add(stack.pop());
        }
        return result;
    }

}
