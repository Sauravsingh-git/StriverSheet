package StackAndQueues.Structure;

import java.util.Stack;

public class BalancedParenthesis {
    public boolean isValid(String s) {
        Stack < Character > stack = new Stack<>();
        for ( char ch : s.toCharArray()){
            if(isOpeningBracket(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(!isMatching(temp, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isOpeningBracket(char ch ){
        return (ch == '{') || (ch == '(' ) || (ch == '[');
    }

    public boolean isClosingBracket( char ch ){
        return (ch == '}') || (ch == ')') || (ch == ']');
    }

    public boolean isMatching( char bracket1, char bracket2 ){
        return ( bracket1 == '(' && bracket2 == ')') || ( bracket1 == '{' && bracket2 == '}') || ( bracket1 == '[' && bracket2 == ']');
    }   
}
