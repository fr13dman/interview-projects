import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fr13dman on 1/9/17.
 * https://www.hackerrank.com/challenges/queue-using-two-stacks
 */

class StackedQueue<Comparable> {
    Stack<Comparable> st1 = new Stack<Comparable>();
    Stack<Comparable> st2 = new Stack<Comparable>();

    public void enqueue(Comparable c) {
        st1.add(c);
    }

    public Comparable dequeue() throws IllegalAccessException {
        if(st1.isEmpty() && st2.isEmpty())
            throw new IllegalAccessException("No elements found in the queue to dequeue!!!");

        if(st2.isEmpty()) {
            while(!st1.isEmpty()) {
                st2.add(st1.pop());
            }
        }

        return st2.pop();
    }

    public void printFront() throws IllegalAccessException {
        if(st1.isEmpty() && st2.isEmpty())
            throw new IllegalAccessException("No elements found in the queue to dequeue!!!");

        if(st2.isEmpty()) {
            while(!st1.isEmpty()) {
                st2.add(st1.pop());
            }
        }

        System.out.println(this.st2.peek());
    }
}


public class QueueWithStacksAlgo {

    public static void main(String args[]) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        StackedQueue<Integer> stackedQueue = new StackedQueue<Integer>();

        int q = in.nextInt();

        while(q-- > 0) {
            int op = in.nextInt();

            switch (op) {
                //enqueue
                case 1:
                    int num = in.nextInt();
                    stackedQueue.enqueue(num);
                    break;
                //dequeue
                case 2:
                    stackedQueue.dequeue();
                    break;
                //print element
                case 3:
                    stackedQueue.printFront();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid operations passed!!");
            }
        }
    }
}
