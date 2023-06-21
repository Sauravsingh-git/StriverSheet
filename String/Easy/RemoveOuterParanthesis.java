package String.Easy;

public class RemoveOuterParanthesis {
    // time complexity : O(N^2)
    // space complexity : O(N)
    public String removeOuterParenthesesBF(String s) {
        String answer = "";
        int len = s.length();
        int sIdx = 0;
        int openBrackets = 0;
        int closeBrackets = 0;
        for ( int i = 0; i < len; i++ ){
            if ( isOpeningBracket(s.charAt(i)) )
                openBrackets++;
            else{
                closeBrackets++;
                if ( openBrackets == closeBrackets ){
                    answer += s.substring(sIdx+1, i);
                    sIdx = i+1;
                }
            }
        }
        return answer;
    }
    // Although faster than previous approach, this too has time complexity of O(N^2)
    // since we are using concat function, which has time complexity of O(k) for substring of k length
    public String removeOuterParenthesesSO(String s) {
        StringBuilder answer = new StringBuilder();
        int len = s.length();
        int sIdx = 0;
        int openBrackets = 0;
        int closeBrackets = 0;
        for ( int i = 0; i < len; i++ ){
            if ( isOpeningBracket(s.charAt(i)) )
                openBrackets++;
            else{
                closeBrackets++;
                if ( openBrackets == closeBrackets ){
                    answer.append( s.substring(sIdx+1, i) );
                    sIdx = i+1;
                }
            }
        }
        return answer.toString();
    }


    public String removeOuterParentheses( String s){
        StringBuilder answer = new StringBuilder();
        int openingBracket = 0;
        for( char ch : s.toCharArray()){
            if ( isOpeningBracket (ch) ){
                openingBracket++;
                if(openingBracket > 1)
                answer.append(ch);
            }else {
                openingBracket--;
                if ( openingBracket > 0 )
                    answer.append(ch);
            }
        }
        return answer.toString();
    }


    public boolean isOpeningBracket( char ch ){
        return ch  == '(';
    }
}
