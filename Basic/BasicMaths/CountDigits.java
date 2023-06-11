package Basic.BasicMaths;
class CountDigits{
    // Que : Count the number of digits in a number completly divisible by number
    // time complexity : O(logn)
    static int evenlyDivides(int N){
        int count = 0;
        int temp = N;
        while ( temp > 0 ){
            int currDig = temp%10;
            if ( currDig != 0 &&  N % currDig == 0 ) count++;
            temp /= 10;
        }
        return count;
    }

}