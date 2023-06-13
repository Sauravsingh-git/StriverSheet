package Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArr {
    //Brute force approach
    // Time complexity : O(n^2)
    // Space complexity : O(1)
    static ArrayList<Integer> leaders1(int arr[], int n){
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(arr[n-1]);
        for( int i = n-2; i >= 0; i-- ){
            int tempMax = arr[i];
            for ( int j = i+1; j < n; j++ ){
                tempMax = Math.max(tempMax, arr[j]);
            }
            if ( tempMax == arr[i])
                resultList.add(arr[i]);
        }
        Collections.reverse(resultList);
        return resultList;
    }
    // optimized appraoch
    // time complexity : O(n)
    // space complexity : O(1)
    static ArrayList<Integer> leaders(int arr[], int n ){
        ArrayList<Integer> resultList = new ArrayList<>();
        int maxSoFar = arr[n-1];
        for ( int i = n-1; i >= 0; i-- ){
            if( arr[i] >= maxSoFar ){
                maxSoFar = arr[i];
                resultList.add(maxSoFar);
            }
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
