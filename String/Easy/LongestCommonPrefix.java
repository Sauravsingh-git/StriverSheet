package String.Easy;

public class LongestCommonPrefix {
    // brute force approach
    // time complexity : O(s) where s is the sum of lengths of all the strings
    // space complexity : O(1)
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        
        int counter = 0;
        for(int j=0; j<strs[0].length(); j++){
            char ch = strs[0].charAt(j);
           for(int i=1; i<strs.length; i++){
                if(!inRange(strs[i], j) || strs[i].charAt(j) != ch)
                    return strs[0].substring(0, counter);
            }
            counter++;
        }
        return strs[0].substring(0, counter);
    }
    
    public boolean inRange(String str, int idx){
        if(idx<str.length())
            return true;
        return false;
    }
}
