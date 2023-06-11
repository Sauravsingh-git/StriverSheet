package Basic.BasicMaths;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp = reverse(x);
        if(temp == x)
            return true;
        return false;
    }
    
    public int reverse(int x) {
        int reversedNumber = 0;
        while ( x != 0 ){
            int temp = x % 10;
            x /= 10;
            if ( Math.abs(reversedNumber) > (Integer.MAX_VALUE - Math.abs(temp))/10 ) return 0;
            reversedNumber = reversedNumber * 10 + temp;
        }
        return reversedNumber;
    }
   // brute force solution
    public boolean isPalindrome1(int x){
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return sb.toString().equals(sb.reverse().toString());
    }
}
