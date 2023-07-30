package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    // optimized approach
    // intuition : 
    // for open brackets -> only those calls are needed, where openBracketsCount < n
    // for closed brackets -> only those calls are needed, where closeBracketsCount< openBracketsCount
    // all other calls are not useful
    // time complexity : 
    public List<String> generateParenthesis(int n) {
        List<String> parenthesisCombination = new ArrayList<>();
        generateParenthesis("", 0, 0, n, parenthesisCombination);
        return parenthesisCombination;
    }
    private void generateParenthesis(String str, int openBrackets, int closeBrackets, int totalBrackets, List<String> parenthesis){
        if ( str.length() == totalBrackets * 2 ){
            parenthesis.add(str);
            return;
        }

        if( openBrackets < totalBrackets){
            generateParenthesis(str+"(", openBrackets + 1, closeBrackets, totalBrackets, parenthesis);
        }
        if ( openBrackets >  closeBrackets){
            generateParenthesis(str + ")", openBrackets, closeBrackets+1, totalBrackets, parenthesis);
        }
    }
    

    // brute force would be generate all possible combinations
    // then filter out the required result
}
