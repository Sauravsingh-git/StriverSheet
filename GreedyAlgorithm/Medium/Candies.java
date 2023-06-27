package GreedyAlgorithm.Medium;

import java.util.Arrays;

public class Candies {
    // approach optimized
    // time complexity : O(n)
    // space complexity : O(n)
    // we will maintain 2 arrays
    // leftArr which follows the rule of having more candies than neighbour
    // rightArr which follows the same rule
    // then we choose the max of these 2 arrays
    public int candy( int [] ratings){
        int len = ratings.length;
        int [] leftArr = new int [len];
        int [] rightArr = new int [len];
        Arrays.fill(leftArr, 1);
        Arrays.fill(rightArr, 1);
        // populating the left array
        for ( int i = 1; i < len; i++ ){
            if( ratings[i] > ratings[i-1])
                leftArr[i] = leftArr[i-1] +1;
        }

        // populating the right array
        for ( int i = len-2; i >= 0; i--){
            if ( ratings[i] > ratings[i+1] )
                rightArr[i] = rightArr[i+1] +1;
        }
        int totalCandiesReq = 0;

        for ( int i = 0; i < len; i++ ){
            totalCandiesReq += Math.max(leftArr[i], rightArr[i]);
        }
        return totalCandiesReq;

    }

    // brute force approach
    // we check both the neighbours, greater than left make it candies[left]+1
    // if greater than right, make it candies[right]+1
    // repeat this process n times to get results
    // time complexity : O (n^2)
    // space complexity : O (n)
    public int candyBF(int[] ratings) {
        int len = ratings.length;
        if ( len == 1 ) return 1; 
        int [] candies = new int [len];
        Arrays.fill(candies, 1);
        for ( int j = 0; j < len; j++ ){
            for ( int i = 0; i < len; i++ ){
                if ( i == 0 ){
                    if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
                        candies[i] = candies[i+1]+1;
                }else if ( i == len-1) {
                    if( ratings[i] > ratings[i-1] && candies[i-1] >= candies[i])
                        candies[i] = candies[i-1]+1;
                }else{
                    if ( ratings[i] > ratings[i-1] && candies[i-1] >= candies[i])
                        candies[i] = candies[i-1] +1;
                    if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
                        candies[i] = candies[i+1]+1;
                }
            }
        }
        int totalCandiesReq = 0;
        for ( int ele : candies )
            totalCandiesReq += ele;
        return totalCandiesReq;
    }
}
