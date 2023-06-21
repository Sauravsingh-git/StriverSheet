package String.Easy;

public class IsomorphicStrings {
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