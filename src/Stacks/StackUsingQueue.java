package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public StackUsingQueue() {
        //queue is implemented through LinkedList class in Java
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(int x) {
        //take out all element of q1 and put it in q2
        //push the element in q2, then take out all the elements from q2 and put them back on q1
        while (!q1.isEmpty()){
            q2.add(q1.poll());  //poll method is same as remove but instead of raising exception it gives null when queue is empty
        }
        q1.add(x);
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
