package Recursion.Basic;

import java.util.Stack;

public class ReverseAStack {
    // time complexity : O(n^2)
    // space complexity : O(n)
    // intuition : 
    // the last element should be at top
    // we will recurisvely traverse the stack keeping the element pointer the currently popped element
    // when the stack is empty we start inserting the elements ( the element which was popped in the curr iteration )
    // at the last element of stack
    void reverse(Stack<Integer> stack ){
        if ( stack.isEmpty() ){
            return;
        }
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom( stack, temp );
    }
    
    void insertAtBottom(Stack<Integer> stack, int x){
        if ( stack.isEmpty() ){
            stack.push(x);
        }else{
            int temp = stack.pop();
            insertAtBottom(stack, x);
            stack.push(temp);
        }
    }
}