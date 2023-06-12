package Arrays.Easy;
import java.util.*;
public class LongestSubarrSumK {

    // brute force approach
    public static int lenOfLongSubarr1 (int arr[], int len, int target) {
        int maxWindowSize = 0;
        for ( int i = 0;  i < len; i++ ){
            int sum = 0;
            for( int j = i; j < len; j++ ){
                sum += arr[j];
                if ( sum == target){
                    maxWindowSize = Math.max(maxWindowSize, j-i+1);
                    System.out.println(i + " " + j);
                }
            }
        }
        return maxWindowSize;
    }
    public static int lenOfLongSubarr( int arr[], int len, int target ){
        int maxWindowSize = 0;
        int [] sumArr = new int [len];
        sumArr[0] = arr[0];
        for ( int i = 1; i < len; i++ )
            sumArr[i] = sumArr[i-1] + arr[i];
        System.out.println(Arrays.toString(sumArr));
        int start = -1, end = 0;
        while ( end < len){
            int temp = sumArr[end] - (start == -1 ? 0 : sumArr[start]);
            System.out.println(temp);
            if ( temp <= target ){
                if( temp == target )
                    maxWindowSize = Math.max(maxWindowSize, end - start);
                end++;
            }else{
                start++;
            }
        }
        return maxWindowSize;
    }

    public static void main(String [] args){
        int x = lenOfLongSubarr(new int [] { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6}, 17, 15);
        System.out.println("the final result is : " + x);
    }
}
