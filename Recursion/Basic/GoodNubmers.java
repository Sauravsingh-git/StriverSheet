package Recursion.Basic;

public class GoodNubmers {
    // PROPERTIES OF MODULUS
    // ( a + b) % c = ( ( a % c ) + ( b % c ) ) % c VALID
    // ( a * b) % c = ( ( a % c ) * ( b % c ) ) % c VALID
    // ( a – b) % c = ( ( a % c ) – ( b % c ) ) % c VALID
    // ( a / b ) % c = ( ( a % c ) / ( b % c ) ) % c NOT VALID

    private final int MODULO_7 = 1000_000_007;
    public int countGoodNumbers(long n) {
        long powers_of_four = power(n/2, 4)%MODULO_7;
        long powers_of_five = power(n - n/2, 5) %MODULO_7;
        return (int)(powers_of_four * powers_of_five%MODULO_7);
    }

    public long power( long power, long currVal){
        if ( power == 0 ) return 1;

        if ( (power&1) == 1) 
            return currVal%MODULO_7 * power(power>>1, currVal * currVal%MODULO_7)%MODULO_7;
        else 
            return power(power>>1, currVal * currVal%MODULO_7)%MODULO_7;
    }

    // using recursion
    // will not work -> given stackoverflow
    public int countGoodNumbersRec(long n) {
        return (int)countGoodNumbersUtil(n-1);
    }

    public long countGoodNumbersUtil( long n ){
        if ( n == -1 ) return 1;
        if ( n%2 ==  0){
            return (5 * countGoodNumbersUtil(n-1))%MODULO_7;
        }else {
            return (4  * countGoodNumbersUtil(n-1))%MODULO_7;
        }
    }

    // using iterative method
    // will not work -> will give TLE
    public int countGoodNumbersItr( long n ){
        long goodNumbers = 1; 
        for ( int i = 0; i < n; i++ ){
            if( (i&1) == 0)
                goodNumbers *= 5;
            else
                goodNumbers *= 4;
            goodNumbers %= MODULO_7;
        }
        return (int)goodNumbers;
    }
    
}
