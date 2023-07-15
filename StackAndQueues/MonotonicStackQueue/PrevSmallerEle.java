package StackAndQueues.MonotonicStackQueue;

import java.util.ArrayList;
import java.util.Stack;

// intuition : using stack
// time complexity : O(n)
// space complexity : O(n)
public class PrevSmallerEle {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> G = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for ( int ele : A ){
            while ( !stack.isEmpty() && stack.peek() >= ele )
                stack.pop();
            if ( !stack.isEmpty () ){
                G.add(stack.peek());
            }else{
                G.add(-1);
            }
            stack.push(ele);
        }
        return G;
    }
}
