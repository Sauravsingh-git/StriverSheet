package Recursion.Basic;

import java.util.Stack;

public class SortAStack {
    // we are using selection sort approach
    // treat one side of stack as sorted, and then repeatedly insert at right position
    public Stack<Integer> sort( Stack<Integer> stack ){
		sortUtil(stack);
		return stack;
	}
	
	public void sortUtil( Stack<Integer> stack ){
	    if ( !stack.isEmpty() ){
	        int temp = stack.pop();
	        sortUtil(stack);
	        insertAtCorrectPosition(stack, temp);
	    }
	}
	
	public void insertAtCorrectPosition( Stack<Integer> stack, int value ){
	    if ( !stack.isEmpty()  && stack.peek() > value ){
	        int temp = stack.pop();
	        insertAtCorrectPosition( stack, value);
	        stack.push(temp);
	    }
	    else
	        stack.push(value);
	}
}
