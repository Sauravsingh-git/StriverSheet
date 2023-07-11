package StackAndQueues.Structure;
import java.util.*;
public class MinStack {
    Long minEle;
    Stack<Long> stack;
    public MinStack() {
        minEle = 0l;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if ( stack.isEmpty() ){
            minEle = (long)val;
            stack.push((long)val);
            return;
        }

        if ( minEle < val ){
            stack.push((long)val);
        }else{
            long encrypt = 2 * (long)val - minEle;
            
            minEle = (long)val;
            stack.push(encrypt);
        }
    }
    
    public void pop() {
        if ( minEle < stack.peek() ){
            stack.pop();
        }else{
            long encryptedValue = stack.pop();
            minEle = 2 * minEle - encryptedValue;
        }
    }
    
    public int top() {
        if ( minEle > stack.peek() ){
            return minEle.intValue();
        }

        return stack.peek().intValue();
    }
    
    public int getMin() {
        return minEle.intValue();
    }
}

class MinStackImpl1{
 // brute force approach
    // using  O(2n) space complexity 
    Stack<Pair> stack;
    public MinStackImpl1() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if ( stack.isEmpty()){
            stack.push(new Pair(val, val));
            return;
        }

        int smallestElementYet = stack.peek().smallestElementYet > val ? val : stack.peek().smallestElementYet;
        stack.push(new Pair(val, smallestElementYet));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().smallestElementYet;
    }
}

class Pair{
    int value;
    int smallestElementYet;
    public Pair(int value, int smallestElementYet){
        this.value = value;
        this.smallestElementYet = smallestElementYet;
    }
}