package Recursion.Basic;

public class Power {
    // using recursion optimized
    public double myPow( double x, int n ){
        return myPowUtil(x, n, x);
    }
    // we have taken n as long 
    // since we have a case where n = -2147483648
    // and for 32 bit integers, -2147483648 * -1 would still be -2147483648
    public double myPowUtil( double x, long n, double currVal ){
        if ( n == 0 ) return 1.0;
        else if ( n < 0 ) return 1/myPowUtil(x, -1*n, currVal);
        if ( (n&1) == 1){
            return currVal * myPowUtil(x, n>>>1, currVal * currVal);
        }else{
            return myPowUtil(x, n>>>1, currVal * currVal);
        }
    }
    // using recursion
    public double myPowRec( double x, int n ){
        if ( n > 0 ){
            return x * myPow(x, n-1);
        }else if ( n < 0 ){
            return 1/x * myPow(x, n+1);
        }else{
            return 1;
        }
    }


    // Optimized Solution
    // Time Complexity : O(logn)
    // Space Compexity : O(1)
    public double myPowItr(double x, int n){
        double result = 1.0;
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        while(n != 0){
            // same as n%2 == 0
            if((n&1) != 0)
                result *= x;
            x *= x;
            // same as n = n/2
            n>>>=1;
        }
        return result;
    }
}
