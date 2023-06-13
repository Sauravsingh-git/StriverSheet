package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class SubArraysWithSumK {

    // Using Brute force approach
    // using 2 for loops to generate every possible subarray
    // Time complexity : O(n^2)
    // space complexity : O(1)
    // optimized approach
    // Time complexity : O(n)
    // space complexity : O(n)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int upLimit = 0,
        downLimit = matrix.length -1,
        rightLimit = matrix[0].length -1,
        leftLimit = 0;

        while ( leftLimit <= rightLimit && upLimit <= downLimit){
            // left to right
            for ( int i = leftLimit; i <= rightLimit; i++ ){
                list.add(matrix[upLimit][i]);
            }
            upLimit++;
            // up to down
            for ( int i = upLimit; i <= downLimit; i++ ){
                list.add(matrix[i][rightLimit]);
            }
            rightLimit--;
            // right to left
            if(upLimit <= downLimit){
                for ( int i = rightLimit; i >= leftLimit; i--){
                    list.add(matrix[downLimit][i]);
                }
            }
            downLimit--;
            // down to up 
            if( leftLimit <= rightLimit){
                for ( int i = downLimit; i >= upLimit; i--){
                    list.add(matrix[i][leftLimit]);
                }
            }
            leftLimit++;
        }
        return list;
    }
}
