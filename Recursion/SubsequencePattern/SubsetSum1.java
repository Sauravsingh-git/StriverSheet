package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum1 {
    // approach 1 : 
    // maintain the sum of the curr subset
    // then sort the result to get the sum in ascending order
    // time complexity : O(2^n)
    // space complexity : O(n) auxillary space
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> listOfSum = new ArrayList<>();
        subsetSumUtil(num, 0, 0, listOfSum);
        Collections.sort(listOfSum);
        return listOfSum;
    }

    public static void subsetSumUtil(int [] num, int sum, int idx, ArrayList<Integer> list){
        if ( idx == num.length ){
            list.add(sum);
            return;
        }
        // take it or leave it pattern
        subsetSumUtil(num, sum, idx+1, list);

        subsetSumUtil(num, sum + num[idx], idx +1, list);
    }



    // approach 
    // using bitmasking - we will create a bit mask such that for arr = [ 1, 2, 3] mask 0 1 1 means only 2 and 3 will 
    // be included in the sum. we will have to work with 2^n such marks from 0 to 2^n-1
    // to for masking n number we need integer 2^n-1
    // time complexity : O(2^n * n)
    // space complexity : O(1)
 
    public static ArrayList<Integer> subsetSumBitMasking(int num[]) {
        int n = num.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        for ( int i = 0; i < (1<<n); i++ ){
            int sum = 0;
            for ( int j = 0; j < n; j++ ){
                if ( ((1<<j) & i ) != 0 ) 
                    sum += num[j];
            }
            result.add(sum);
        }
        Collections.sort(result);
        return result;
    }
}
