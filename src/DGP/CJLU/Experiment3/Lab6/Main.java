package DGP.CJLU.Experiment3.Lab6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Write a program to output the result of these operations on a stack and a queue, respectively using java.util.Stack
 * and java.util.Queue: insert integer sequence {1,2,3 4}, then delete two integers and insert integer 5.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.push(5);
        System.out.println(stack);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.poll();
        queue.poll();
        queue.offer(5);
        System.out.println(queue);
    }
}
