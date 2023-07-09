package StackAndQueues.Structure;

import java.util.Queue;
import java.util.LinkedList;
public class ImplementStackFromQueue {
    // using two queues to implement a stack
    MyStack1 mystack = new MyStack1();
}
// implementing stack from single queue 
class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        while ( size-- > 0){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.size() == 0;
    }
}
// implementing the stack using 2 queues
class MyStack1 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    // time complexity : O(n) n-> size of the stack
    public void push(int x) {
        // enter the element in queue2
        queue2.offer(x);
        // empty queue1 into queue2
        while ( !queue1.isEmpty() ){
            queue2.offer(queue1.poll());
        }
        // swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        int elementToBeRemoved = queue1.poll();
        return elementToBeRemoved;
    }
    
    public int top() {
        int topEle = queue1.peek();
        return topEle;
    }
    
    public boolean empty() {
        return queue1.size() == 0;
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
