package DGP.CJLU.Experiment3.Lab2;

import DGP.CJLU.Utils.Execution.Dispatcher;
import DGP.CJLU.Utils.Implementation.Queue;

import java.util.LinkedList;

/**
 * 2.	Write routines to implement queues using the following data structures and test your queues.
 * a)	A linked list
 * b)	An array
 * c)	A circular array
 * Requirement:
 * a)	use java.util.Queue to test the same operation sequence
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        new Dispatcher().run(() -> {
            Queue<Integer> queue = new LinkedQueue<>();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            queue.offer(4);
            queue.offer(5);
            queue.poll();
            System.out.println(queue);
        }).run(() -> {
            Queue<Integer> queue = new ArrayQueue<>(10);
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            queue.offer(4);
            queue.offer(5);
            queue.poll();
            System.out.println(queue);
        }).run(() -> {
            Queue<Integer> queue = new CircularArrayQueue<>(4);
            queue.offer(1);
            queue.offer(2);
            queue.poll();
            queue.poll();
            queue.offer(3);
            queue.offer(4);
            queue.poll();
            queue.poll();
            queue.offer(5);
            queue.offer(6);
            queue.poll();
            queue.poll();
            System.out.println(queue.toString());
        }).run(() -> {
            java.util.Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            queue.offer(4);
            queue.offer(5);
            queue.poll();
            System.out.println(queue);
        });
    }
}
