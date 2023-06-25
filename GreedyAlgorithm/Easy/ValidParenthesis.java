package GreedyAlgorithm.Easy;

public class ValidParenthesis {
    // brute force approach
    // for every '*' we encounter we try every three possibilities i.e, ['(', ')', ' ']
    // time complexity : O(n*3^n)
    // space complexity : O(n)
    public boolean checkValidStringBF(String s){
        StringBuilder sb = new StringBuilder(s);
        boolean [] result = new boolean [1];
        checkValidStringUtil(sb, 0, result);
        return result[0];
    }

    public void checkValidStringUtil( StringBuilder sb, int idx, boolean [] result ){
        if ( idx == sb.length()){
            result [0] |= checkValidParenthesis(sb);
            return;
        }
        if ( sb.charAt(idx) == '*'){
            // trying every possible outcome
            for(char ch : "() ".toCharArray()){
                sb.setCharAt(idx, ch);
                checkValidStringUtil(sb, idx+1, result);
                // if already found the answer
                if ( result[0] ) return;
            }
            sb.setCharAt(idx, '*');
        }else{
            checkValidStringUtil(sb, idx+1, result);
        }
    }

    public boolean checkValidParenthesis( StringBuilder sb){
        int openingBracket = 0, closingBracket = 0;
        for ( int i = 0; i < sb.length(); i++ ){
            if ( isOpeningBracket(sb.charAt(i))){
                openingBracket++;
            }else if ( isClosingBracket(sb.charAt(i))){
                closingBracket++;
            }
            if ( closingBracket > openingBracket) return false;
        }

        return openingBracket == closingBracket;
    }

    // greedy approach 
    // intuition is that when moving from left to right, the number of closing bracket should always be less than openingBrackets
    // for it to be a valid string
    // similarly when moving from right to left, the number of opening brackets should always be less than closingBrackets
    // we need to check that input string should be such that 
    // the number of opening brackets '(' when traversing from the left to right
    // should be such that, closing brackets are never more than occurences ['(' + '*']
    // and at last we should check the number of opening brackets '*' are not so much greater
    // than ')' that we cannot compensate by closing brackets + ')'
    // then we need to repeat the same approach for ')' bracket while traversing from right to left
    // because we can have cases like - *(()
    public boolean checkValidString(String s) {
        int openingBrackets,  wildcards;
        openingBrackets = wildcards = 0;
        char [] str = s.toCharArray();
        int len = str.length;
        for ( char ch : str){
            if( isOpeningBracket(ch)){
                openingBrackets++;
            }else if ( isWildCard(ch)){
                wildcards++;
            }else{
                if ( openingBrackets == 0 ){
                    if ( wildcards == 0 ) return false;
                    wildcards--;
                }else{
                    openingBrackets--;
                }
            }
        }
        if ( openingBrackets != 0 && openingBrackets > wildcards) return false;
        
        // checking for closing brackets
        int closingBrackets = 0;
        wildcards = 0;
        for ( int i =  len-1; i >= 0; i--){
            if ( isClosingBracket(str[i])){
                closingBrackets++;
            }else if ( isWildCard(str[i])){
                wildcards++;
            }else{
                if (closingBrackets == 0 ){
                    if ( wildcards == 0 ) return false;
                    wildcards--;
                }else{
                    closingBrackets--;
                }
            }
        }

        if ( closingBrackets != 0 && closingBrackets > wildcards) return false;
        return true;
    }

    public boolean isOpeningBracket( char ch ){
        return ch == '(';
    }

    public boolean isClosingBracket( char ch ){
        return ch == ')';
    }
    public boolean isWildCard( char ch ){
        return ch == '*';
    }
}