package String.Easy;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic1(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i))
                return false;
            }else{
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
    
    public boolean isIsomorphic(String s, String t){
        char [] mapping = new char [256];
        boolean [] used = new boolean [256];

        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();

        for(int i=0; i<sArr.length; i++){
            if(mapping[sArr[i]] != 0){
                if(mapping[sArr[i]] != tArr[i])
                    return false;
            }else{
                if(used[tArr[i]])
                return false;
                mapping[sArr[i]] = tArr[i];
                used[tArr[i]] = true;
            }
        }
        return true;
    }
}