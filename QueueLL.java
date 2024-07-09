import java.util.*;
public class QueueLL {

    int data;
    QueueLL next;

    QueueLL(int key) {
        data = key;
        next = null;
    }
class MyQueue{
        QueueLL front ,rear;
    MyQueue(){
        this.front = this.rear = null;
    }
    void Push(int a){
        QueueLL temp = new QueueLL(a);
        if(this.rear == null){
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
  int pop(){
        if(this.front == null){
            return -1;
        }
        QueueLL temp = this.front;
        this.front = this.front.next;

        if(this.front == null){
            this.rear = null;
        }
        return temp.data;


    }
}


    public static void main(String[] args) {
        QueueLL outer = new QueueLL(0);
        MyQueue q = outer.new MyQueue();
        q.Push(10);
        q.Push(20);
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.Push(30);
    }
}
