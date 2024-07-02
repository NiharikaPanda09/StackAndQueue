import java.util.*;
public class QueueImplementUsingArray {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Should print 1
        System.out.println(queue.dequeue()); // Should print 2
        queue.enqueue(4);
        System.out.println(queue.front()); // Should print 3
        System.out.println(queue.dequeue()); // Should print 3
        System.out.println(queue.dequeue()); // Should print 4
        System.out.println(queue.dequeue()); // Should print -1 (queue is empty)
    }

    static class MyQueue {
        int[] arr;
        int front;
        int rear;
        int size;
        int n ;

        public MyQueue(int capacity) {
            arr = new int[capacity];
            front = 0;
            rear = 0;
            size = 0;
            n = arr.length;

        }

        public void enqueue(int x) {
            if (size == n) {
                System.out.println("Queue is full. Cannot enqueue " + x);
                return;
            }
            arr[rear%n] = x;
            rear++;
            size++;

        }

        public int dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }
          int val= arr[front%n] ;
            front++;
            size--;
            return val;
        }

        public int front() {
            if (size == 0) {
                System.out.println("Queue is empty. No front element.");
                return -1;
            }
            return arr[front%n];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length;
        }
    }
}
