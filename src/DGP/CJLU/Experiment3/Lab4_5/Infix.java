package DGP.CJLU.Experiment3.Lab4_5;

import java.util.Stack;

public class Infix extends Expression {

    /**
     * assume the expression is correct
     * only support (  ) + - * / operator
     * convert string expression to linked list element
     *
     * @param expression to be converted
     */
    public Infix(String expression) {
        expression = expression.replace(" ", "");//remove space
        int i = 0;
        do {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                //是操作符，直接添加至list中
                i++;
                data.add(new Item(c));
            } else if (Character.isDigit(c)) {
                //是数字,判断多位数的情况
                String str = "";
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    str += expression.charAt(i);
                    i++;
                }
                data.add(new Item(str));

            }
        } while (i < expression.length());
    }

    public Suffix toSuffix() {
        Stack<Item> stack = new Stack<>();
        Suffix result = new Suffix();
        for (Item item : data) {
            if (item.isNumber())                                                             //运算数,直接输出.
                result.data.add(item);
            else if (item.isLeftParentheses()) {                                              //左括号,直接压入堆栈
                stack.push(item);
            } else if (item.isRightParentheses()) {                                            //右括号,(意味着括号已结束)不断弹出栈顶运算符并输出直到遇到左括号(弹出但不输出)
                while (!stack.peek().isLeftParentheses())
                    result.data.add(stack.pop());
                stack.pop();                                                                //pop out left parentheses
            } else if (item.isOperator()) {                                                    //运算符,将该运算符与栈顶运算符进行比较
                /*if(stack.isEmpty()||item.priority()>stack.peek().priority()){             //如果优先级高于栈顶运算符则压入堆栈(该部分运算还不能进行)
                    stack.push(item);
                } else {                                                                    //如果优先级低于等于栈顶运算符则将栈顶运算符弹出并输出,然后比较新的栈顶运算符
                    while (!(stack.isEmpty() || item.priority()>stack.peek().priority()))   //直到优先级大于栈顶运算符或者栈空,再将该运算符入栈
                        result.data.add(stack.pop());
                    stack.push(item);
                }*/
                if (!stack.isEmpty() && item.priority() <= stack.peek().priority()) {
                    while (!(stack.isEmpty() || item.priority() > stack.peek().priority()))
                        result.data.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            result.data.add(stack.pop());
        }
        return result;
    }

}
