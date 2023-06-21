package String.Easy;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        int [] charMap1 = new int [26];
        int [] charMap2 = new int [26];
        fillCharMap(charMap1, s);
        fillCharMap(charMap2, t);
        for ( int i = 0; i < 26; i++  ){
            if ( charMap1[i] != charMap2[i]) return false;
        }

        return true;
    }

    public void fillCharMap( int [] charMap, String str){
        for ( char ch : str.toCharArray() ){
            charMap[ch -'a']++;
        }
    }
}
