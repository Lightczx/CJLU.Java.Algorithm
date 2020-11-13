package DGP.CJLU.Experiment3.Lab3;

import DGP.CJLU.Experiment3.Lab1.LinkedStack;
import DGP.CJLU.Utils.File.FileHelper;

import java.io.File;
import java.util.Stack;

/**
 * Write a program to get a file's content, and check the content for the following balancing symbols: (), [], {}, Requirement:
 * a use customized class MyStack.
 * b use java.util.Stack
 * c In the test file,there must be English letters and symbols.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\test.txt");
        if (!file.exists()) {
            System.out.println("找不到文件");
            return;
        }
        StringBuilder sb = FileHelper.readFileToStringBuilder(file);

        System.out.println("verifyUsingStack : " + (verifyUsingStack(sb) ? "符号对称" : "符号不对称"));
        System.out.println("verifyUsingLinkedStack : " + (verifyUsingLinkedStack(sb) ? "符号对称" : "符号不对称"));
    }

    private static boolean verifyUsingStack(StringBuilder sb) {
        Stack<Character> stack = new Stack<>();
        String s = sb.toString();
        try {
            boolean inComment = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(', '[', '{':
                        if (!inComment) {
                            stack.push(c);
                        }
                        break;
                    case ')':
                        if (!inComment && stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (!inComment && stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (!inComment && stack.pop() != '{') {
                            return false;
                        }
                        break;
                    case '/':
                        if (!inComment && s.charAt(i + 1) == '*') {
                            stack.push('$');
                            inComment = true;
                            i++;
                        }
                        break;
                    case '*'://in comment we only care about */
                        if (s.charAt(i + 1) == '/') {
                            if (stack.pop() != '$') {
                                return false;
                            } else {
                                inComment = false;
                                i++;
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean verifyUsingLinkedStack(StringBuilder sb) {
        LinkedStack<Character> stack = new LinkedStack<>();
        String s = sb.toString();
        try {
            boolean inComment = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(', '[', '{':
                        if (!inComment) {
                            stack.push(c);
                        }
                        break;
                    case ')':
                        if (!inComment && stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (!inComment && stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (!inComment && stack.pop() != '{') {
                            return false;
                        }
                        break;
                    case '/':
                        if (!inComment && s.charAt(i + 1) == '*') {
                            stack.push('$');
                            inComment = true;
                            i++;
                        }
                        break;
                    case '*':
                        //in comment we only care about */
                        if (s.charAt(i + 1) == '/') {
                            if (stack.pop() != '$') {
                                return false;
                            } else {
                                inComment = false;
                                i++;
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
