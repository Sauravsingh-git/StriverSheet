package Basic.BasicMaths;

public class SumOfAllDivisors1ToN {

    // optimal approach 
    // a number i  will aprear in the sum exactly N/i
    // for eg 1 2 3 4 5 6 7 8 9 10
    // when i = 3
    // in the final sum 3 will appear 10/3 => 3 times
    
    static long sumOfDivisors(int N){
        long sum = 0;
        for ( int i = 1; i <=N; i++ ){
            sum += (N/i) * i;
        }
        return sum;
    }

    // brute force approach
    // to get all the factors traverse from 1 to square root of (n)
    // dont forget to put the condition to check if current number is sqaure root to avoid it adding twice
    static long sumOfDivisors1(int N){
        long count = 0;
      for ( int i = 1; i <= N; i++ ){
          count += getSumOfFactors(i);
      }
      return count;
    }

    static long getSumOfFactors(int num){   
        if ( num == 1) return 1;
        long sum = 0;
        for ( int i = 1; i <= Math.sqrt(num); i++ ){
            if ( num%i == 0 )
                sum += i;
            if ( num/i != i )
                sum += num/i;
            
        }
        return sum;
    }

    
}
