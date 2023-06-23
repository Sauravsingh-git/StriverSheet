package String.Medium;

public class MaxDepthOfParenthesis {
    public int maxDepth(String s) {
        int openBrackets = 0;
        int maxDepth = 0;
        for ( char ch : s.toCharArray()){
            if(isOpeningBracket(ch)){
                openBrackets++;
            }
            if ( isClosingBracket(ch)){
                maxDepth = Math.max(maxDepth, openBrackets);
                openBrackets--;
            }
        }
        return maxDepth;

    }

    public boolean isOpeningBracket( char ch ){
        return ch == '(';
    }

    public boolean isClosingBracket( char ch ){
        return ch == ')';
    }
}
