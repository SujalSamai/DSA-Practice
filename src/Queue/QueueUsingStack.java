package Queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public QueueUsingStack() {
        s1= new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    //pop out all elements from s1 and put it in s2, and then pop from s2
    //after popping the element, pop out rest of the elements and put back in s1
    public int pop() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans=s2.pop();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return ans;
    }

    public int peek() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans=s2.peek();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return ans;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
