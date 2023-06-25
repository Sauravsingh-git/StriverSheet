package String.Medium;

public class BeautyOfSubstrings {
    public int beautySum(String s){
        int beauty = 0;
        int len = s.length();
        char [] str = s.toCharArray();
        for ( int i = 0; i < len; i++ ){
            int [] charCount = new int [26];
            for ( int j = i; j < len; j++ ){
                charCount[str[j]-'a']++;
                beauty += calculateBeauty(charCount);
            }
        }
        return beauty;
    }

    public int calculateBeauty(int [] charCount){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for ( int i = 0; i < 26; i++ ){
            if ( charCount[i] != 0)
                min = Math.min( min, charCount[i]);
            max = Math.max( max, charCount[i]);
        }   
        return max -min;
    }
}
