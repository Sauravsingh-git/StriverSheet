package StackAndQueues.Structure;
import java.util.*;
public class StackToQueue {
    
}
class MyQueue1{
    // with amortized complexity of every operation as O(1)
    Stack<Integer> pushStack, popStack;
    public MyQueue1() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    public void push(int x) {
        // always push in pushStack
        pushStack.push(x);
    }
    
    public int pop() {
        // if pop stack is empty, empty all push stack in pop stack
        // else just pop from pop stack
        if ( popStack.isEmpty() )
            while ( !pushStack.isEmpty() )
                popStack.push(pushStack.pop());
        
        return popStack.pop();
    }
    
    public int peek() {
        if ( popStack.isEmpty() )
            while ( !pushStack.isEmpty() )
                popStack.push(pushStack.pop());
        
        return popStack.peek();
    }
    
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

class MyQueue{
    // with time complexity for push: O(n)
     Stack<Integer> stack1, stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {

        while ( stack1.size()!= 0 ){
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while ( stack2.size()!= 0 ){
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.size() == 0;
    }
}