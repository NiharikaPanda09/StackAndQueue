import java.util.*;
public class StackImplementationArray {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.top()); // Should print 3
        System.out.println(stack.pop()); // Should print 3
        System.out.println(stack.top()); // Should print 4
        System.out.println(stack.pop()); // Should print 4
        System.out.println(stack.top()); // Should print 5
        System.out.println(stack.pop()); // Should print 5
        System.out.println(stack.pop()); // Should print -1 (stack is empty)
    }

    static class MyStack {
        int[] arr;
        int top;

        public MyStack() {
            arr = new int[5];
            top = -1;
        }

        public void push(int x) {
            if (top == arr.length - 1) {
                System.out.println("Stack is full. Cannot push " + x);
                return;
            }
            arr[++top] = x;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1;
            }
            return arr[top--];
        }

        public int top() {
            if (top == -1) {
                System.out.println("Stack is empty. No top element.");
                return -1;
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}