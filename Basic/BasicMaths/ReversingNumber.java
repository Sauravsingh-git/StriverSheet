package Basic.BasicMaths;

public class ReversingNumber {
    // the trick in this question is to tackle the overflow condition
    // if rev * 10 + temp > Integer.MAX_VALUE
    // then rev >(Integer.MAX_VALUE - temp)/10
    // common mistake : to put while (  x > 0 ) but we also have to consider negative values
    // we take while ( x != 0 )
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
}
