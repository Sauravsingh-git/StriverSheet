import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferentWaysToAddParenthesis {
   
    // recursive approach
    // split the expression at every operator
    // and evaulate each part recursively
    // for eg, 2 * 3 - 5
    // can be split as 2 * ( 3 - 5 ) or as ( 2 * 3 ) - 5
    public List<Integer> diffWaysToComputeRecursion(String expression) {
        List<Integer> result = new ArrayList<Integer>();
        
        for ( int i = 0; i < expression.length(); i++ ){
            if ( isOperator(expression.charAt(i)) ){
                String firstExpression = expression.substring(0, i);
                String secondExpression = expression.substring(i+1);
                List<Integer> result1 = diffWaysToCompute(firstExpression);
                List<Integer> result2 = diffWaysToCompute(secondExpression);
                for ( int r1 : result1){
                    for ( int r2 : result2 ){
                        int temp = evaluate(r1, r2, expression.charAt(i));
                        result.add(temp);
                    }
                }
            }
        }

        // base case : if string only contains no operators
        // if we have operators in our string, our list will be empty 
        // then the number is the result
        if ( result.isEmpty() ){
            result.add(Integer.parseInt(expression));
            return result;
        }
        return result;
    }

    public List<Integer> diffWaysToCompute( String expression ){
        return diffWaysToComputeUtil(expression, new HashMap<String, List<Integer>>());
    }
    public List<Integer> diffWaysToComputeUtil(String expression, HashMap<String, List<Integer>> map) {
        if ( map.containsKey(expression)) return map.get(expression);
        List<Integer> result = new ArrayList<Integer>();
        
        for ( int i = 0; i < expression.length(); i++ ){
            if ( isOperator(expression.charAt(i)) ){
                String firstExpression = expression.substring(0, i);
                String secondExpression = expression.substring(i+1);
                List<Integer> result1 = diffWaysToCompute(firstExpression);
                List<Integer> result2 = diffWaysToCompute(secondExpression);
                for ( int r1 : result1){
                    for ( int r2 : result2 ){
                        int temp = evaluate(r1, r2, expression.charAt(i));
                        result.add(temp);
                    }
                }
            }
        }

        // base case : if string only contains no operators
        // if we have operators in our string, our list will be empty 
        // then the number is the result
        if ( result.isEmpty() ){
            result.add(Integer.parseInt(expression));
            return map.compute(expression, (k, v)-> result);
        }
        return map.compute(expression, (k, v)-> result);
    }

    public boolean isOperator( char ch ){
        return ch == '+' || ch == '-' || ch == '*';
    }

    public int evaluate( int op1, int op2, int operator){
        switch ( operator ){
            case '+' : return op1 + op2;
            case '-' : return op1 - op2;
            case '*' : return op1 * op2;
            case '/' : return op1 * op2;
        }
        return -1;
    }
}
