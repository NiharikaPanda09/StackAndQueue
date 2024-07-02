import java.util.*;
public class StackImplementUsingQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.top());

        System.out.println(stack.top());
        System.out.println(stack.empty());



    }
    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;
        public MyStack(){
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        public void push(int x) {
         q2.add(x);
         while(!q1.isEmpty()){
             q2.add(q1.peek());
             q1.remove();

         }
         Queue<Integer> temp = q1;
         q1=q2;
         q2 = temp;
        }
        public int pop() {
         return q1.remove();
        }
        public int top() {
            return q1.peek();
        }
        public boolean empty() {
           return q1.isEmpty();
        }

    }


}
