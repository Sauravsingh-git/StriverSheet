package Recursion.Basic;

import java.util.Stack;

public class SortAStack {

    public static void main(String [] args){
        SortAStack obj = new SortAStack();
        Stack<Integer> stack = new Stack<>();
        stack.push( 1);
        stack.push( 3);
        stack.push( 4);
        stack.push( 5);
        obj.insertAtCorrectPosition(stack, 2);
        System.out.println(stack);

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
