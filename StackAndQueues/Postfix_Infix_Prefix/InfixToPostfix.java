package StackAndQueues.Postfix_Infix_Prefix;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String [] args){
        String result = infixToPostfix("2+3*2");
        System.out.println(result);
    }
    public static String infixToPostfix(String exp) {
    StringBuilder sb = new StringBuilder();
	Stack<Character> stack = new Stack<>();
	for ( char ch : exp.toCharArray() ){
		if ( isOpeningBracket(ch )){
			stack.push(ch);
		}else if ( isClosingBracket(ch)){
			while ( !isOpeningBracket(stack.peek()) ){
				sb.append(stack.pop());
			}
			stack.pop();
		}else if ( isOperator(ch)) {
			if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
			int precendenceCurrOperator = getPrecedence(ch);
            int precendenceStackTop = getPrecedence(stack.peek());
			if ( precendenceCurrOperator <= precendenceStackTop ){
				while ( !stack.isEmpty() && !isOpeningBracket(stack.peek()) ){
					sb.append(stack.pop());
				}
				
			}
			stack.push(ch);
		}else{
		    sb.append(ch);
		}

	}
    while ( !stack.isEmpty()){
        sb.append(stack.pop());
    }
    return sb.toString();
    }


    public static int getPrecedence( char operator ){
        if ( operator == '^') return 3;
        else if ( operator == '*' || operator == '/') return 2;
        else if ( operator == '+' || operator == '-') return 1;
        return -1;
    }
    public  static boolean isNumber( char ch ){
        return ch >= '0' && ch <= '9';
    }

    public static boolean isOpeningBracket(char ch ){
        return ch == '(';
    }

    public static boolean isClosingBracket(char ch ){
        return ch == ')';
    }

    public static boolean isOperator( char ch ){
        return ch == '+' || ch == '*' || ch == '/' || ch == '-' || ch == '^';
    }
}