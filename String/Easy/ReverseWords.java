package String.Easy;

public class ReverseWords {
    // brute force approach
    public String reverseWordsBF(String s) {
        String [] words = s.split(" ");
        int len = words.length;
        StringBuilder sb = new StringBuilder();
        for ( int i = len-1; i >= 0; i-- ){
            if (!words[i].equals("")){
                sb.append(words[i]);
                sb.append(' ');
            }
        }
        // removing any trailing spaces
        while (sb.charAt(sb.length()-1) == ' '){
        sb.deleteCharAt(sb.length()-1);
       }

        return sb.toString();
    }
    

   // without using split method of string
   public String reverseWords( String str){
       StringBuilder result = new StringBuilder();
       int right = str.length()-1;
       int left = str.length()-1;
       while ( left >= 0 ){
           if ( str.charAt(left ) == ' '){
               if ( left != right ){
                   appendToResult(result, str, left+1, right);
                   if ( left != -1)
                   result.append(" ");
                   right = left;
               }
               left--;
               right= left;
           }else{
               left--;
           }
       }
       appendToResult(result, str, 0, right);
       // removing any trailing spaces
       while (result.charAt(result.length()-1) == ' '){
        result.deleteCharAt(result.length()-1);
       }
       return result.toString();
   }

   public void appendToResult( StringBuilder result, String str, int left, int right ){
       for ( int i = left; i <= right; i++ ){
           result.append(str.charAt(i));
       }
   }

}
