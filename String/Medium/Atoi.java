package String.Medium;

public class Atoi {
     public int myAtoi(String s) {
        if(s.length()==0)
            return 0;
        int i=0;
        boolean isPositive=true;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(i==s.length())
            return 0;
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i)=='-')
                isPositive= false;
            i++;
        }
        int start = i;
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        if(start==i)
            return 0;
        String str = s.substring(start, i);
        int res = returnInt(str, isPositive);
        if(isPositive)
            return res;
        else
            return -1 * res;
    }
    
    public int returnInt(String str, boolean isPositive){
        int num;
        try{
            num = Integer.parseInt(str);
        }catch(Exception e){
            if(isPositive)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return num;
    }
}
