package String.Medium;

import java.util.HashMap;

public class RomanIntegerConversion {
    public int RomanToInteger(String s){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int result = 0;
        for(int i = 0; i < s.length() - 1; i++){
            int currElement = hashMap.get(s.charAt(i));
            int nextElement = hashMap.get(s.charAt(i+1));
            if(currElement < nextElement){
                result -= currElement;
            }else{
                result += currElement;
            }
        }
        result += hashMap.get(s.charAt(s.length()-1));
        return result;
    }

    public String intToRoman(int num) {
            int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
