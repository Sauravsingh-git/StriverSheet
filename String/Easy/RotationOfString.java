package String.Easy;

public class RotationOfString {
    // brute force approach
    // checking every possible rotation
    // time complexity : O(N^2)
    // space complexity : O(1), we only use extra space for arrays which could be done by using str.charAt() method
    public boolean rotateStringBF(String s, String goal) {
        char [] str1 = s.toCharArray();
        char [] str2 = goal.toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;
        if ( len1 != len2 ) return false;
        for ( int i = 0; i < len1; i++ ){
            boolean isMatching = true;
            for ( int j = 0; j < len1; j++ ){
                if( str1[(i+j)%len1] != str2[j]){
                    isMatching = false;
                    break;
                }
            }
            if( isMatching) return isMatching;
        }
        return false;
    }

    // optimized method
    // time complexity : O(n)
    // space complexity : O(n)

    public boolean rotateString(String s, String goal ){
        if ( s.length() != goal.length()) return false;
        s += s;
        return containsString(goal, s);

    }

    public boolean containsString(String str, String target){
        int lenStr = str.length();
        int lenTarget = target.length();
        int [] lps = new int [lenStr];
        buildLPS(lps, str);
        int idxStr, idxTarget;
        idxStr = idxTarget = 0;
        while ( idxTarget < lenTarget ){
            if(target.charAt(idxTarget) == str.charAt(idxStr)){
                idxTarget++;
                idxStr++;
            }else{
                if ( idxStr == 0 ){
                    idxTarget++;
                }else{
                    idxStr = lps[idxStr-1];
                }
            }
            if(idxStr == lenStr)
                return true;
        }
        return false;
    }

    public void buildLPS( int [] lps, String str){
        int len = str.length();
        int preffixLen = 0, idx = 1;
        lps[0] = 0;
        while ( idx < len ){
            if ( str.charAt(idx) == str.charAt(preffixLen)){
                preffixLen += 1;
                lps[idx] = preffixLen;
                idx++;
            }else{
                if ( preffixLen == 0){
                    lps[idx] = 0;
                    idx++;
                }else{
                    preffixLen = lps[preffixLen-1];
                }
            }
        }
    }
}