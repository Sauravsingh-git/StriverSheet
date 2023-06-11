package Basic.BasicMaths;

public class ArmstrongNumber {
    static String armstrongNumber(int n){
        int sum = 0;
        int temp = n;
        while ( temp > 0 ){
            int currDigit = temp%10;
            sum += currDigit * currDigit * currDigit;
            temp /= 10;
        }
        return sum == n ? "Yes" : "No";
    }
}
