package Arrays.Hard;

public class MissingAndReapetedNumber {
    // brute force approach
    // time complexity : O(n)
    // space complexity : O(n)
    int[] findTwoElement1(int arr[], int n) {
      int [] map = new int [n+1];
      for ( int ele : arr ){
          map[ele]++;
      }
       
      int [] result = new int [2];
      for ( int i = 1; i < n+1; i++ ){
            if( map[i] == 2) 
                result[0] = i;
            if ( map[i] == 0 )
                result[1] = i;
      }
      return result;
    }
    
    
    // time complexity : O(n)
    // space complexity : O(1)
    
    int [] findTwoElement2( int [] arr, int n){
        int [] result = new int [2];
        for ( int i = 0; i < n; i++ ){
            if ( arr[Math.abs(arr[i])-1] < 0 ) {
                    result[0] = Math.abs(arr[i]);
                    continue;
            }
            arr[Math.abs(arr[i])-1] *= -1;
        }
        
        for ( int i = 0; i < n ; i++ ){
            if ( arr[i] > 0  ){
                 result[1] = i+1;
                 break;
            }
        }
        
        // modifying the arr again to make the input same again
        for ( int i = 0; i < n; i++ ){
            arr[i] = Math.abs(arr[i]);
        }
        return result;
    }
    
    // another approach
    // without modifying the actual array at 
    // using maths 
    // take Sn = n( n + 1)/2
    // take Sn^2 = n (n + 1)( 2n + 1)/6
    // now calculate actual sum and actual sqaure of sums
    // by this we will get x-y and x^2 - y^2, where x and y will be 
    // duplicate element and the missed element
    // logic in Sn - Sn' => x - y where
    // x -> element which is missing
    // y -> element which is repeated
    // all the other elements will cancelled out
    // This approach can result in overflows depending on test cases
    int [] findTwoElement ( int [] arr, int n){
        long Sn = (long) n *( n+1 )/2;
        long Sn2 = (long) n*( n+1 )*( 2*n+1 )/6;
        
        long Snx = 0;
        long Sn2x = 0;
        for ( int i = 0; i < n; i++ ){
            Snx += arr[i];
            Sn2x += arr[i] * arr[i];
        }
        long diff =  ( Sn - Snx);
        long diffSqaure = (Sn2 - Sn2x);
        long sum = diffSqaure/diff;
        long missEle = ( diff + sum )/2;
        long repeatEle = ( sum - missEle);
        return new int [] { (int)repeatEle, (int)missEle };
    }
}
