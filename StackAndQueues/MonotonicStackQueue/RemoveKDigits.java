package StackAndQueues.MonotonicStackQueue;

import java.util.Stack;

public class RemoveKDigits {


    // intuition : we want the the chars at the most signicant unit places to be smallest
    // i.e., we will remove the curr char if next char is smaller than curr char
    public String removeKdigits(String num, int k) {

        if ( k == 0 ) return num;
        if ( k == num.length() ) return "0";
        Stack<Character> stack = new Stack<>();

        for ( char ch : num.toCharArray() ){
            while ( !stack.isEmpty() && stack.peek() > ch &&  k > 0 ){
                stack.pop();
                k--;
            }
            if( stack.isEmpty() && ch == '0'){
                continue;
            }else{
                stack.push(ch);
            }
        }
        // if k elements are not removed
        while ( k-- > 0 && !stack.isEmpty()){
            stack.pop();
        }
        char [] number = new char[stack.size()];
        for ( int i = stack.size() -1; i >= 0; i-- ){
            number[i] = stack.pop();
        }
        
        return number.length == 0 ? "0" : String.valueOf(number);
    }
}
