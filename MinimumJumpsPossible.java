import java.util.Arrays;

public class MinimumJumpsPossible {
    // brute force approach 
    // we have to choose from a different number of ways
    // so we will traverse every possible path and then choose the best 
    static int minJumps1(int[] arr){
        int minJumps =  minJumpsUtil(arr, 0);
        return minJumps > Math.pow(10, 7) ? -1 : minJumps;
    }
    
    static int minJumpsUtil( int [] arr, int pos){
        if ( pos >= arr.length -1 ) return 0;
        // we are taking temp as Integer.MAX_VALUE - 5
        // for the case we get pos == 0
        // we will return Integer.MAX_VALUE as result and Integer.MAX_VALUE + 1
        // will be returned and we will get wrong result
        int temp = Integer.MAX_VALUE - 5;
        for ( int i = 1; i <= arr[pos]; i++ ){
            temp = Math.min(temp, minJumpsUtil(arr,pos+ i)+1);
        }
        return temp;
    }
    
    // converting this code to dp
    static int [] dp;
    static int minJumps2(int [] arr ){
        int len = arr.length;
        dp = new int [len];
        Arrays.fill(dp,-1);
        int minJumps = minJumpsUtil(arr, 0);

        return minJumps > Math.pow(10, 7) ? -1 : minJumps;
    }
    
    static int minJumpsUtil2(int [] arr, int pos){
        if ( pos >= arr.length -1) return 0;
        if ( dp[pos] != -1) return dp[pos];
        int temp = Integer.MAX_VALUE -5;
        for ( int i = pos+1; i <= pos+arr[pos]; i++ ){
            temp = Math.min(temp, minJumpsUtil(arr, i)+1);
        }
        return dp[pos] = temp;
    }
    
    // Even the dp approach wont work since input values are in the range 10^7
    // most optimized approach
    // In this approach we will maintain three varaibles
    // jumps, maxStepsPossible
    static int minJumps ( int [] arr){
        if ( arr.length == 1 ) return 0;
        if ( arr[0] == 0 ) return -1;
        int len = arr.length;
        int maxStepsPossible = arr[0];
        int currStepsPossible = arr[0];
        int jumps = 1;
        for ( int i = 1; i < len; i++ ){
            if ( i == len - 1 ) return jumps;
            currStepsPossible--;
            maxStepsPossible = Math.max(maxStepsPossible, i + arr[i]);
            if( currStepsPossible == 0 ){
                if ( i >= maxStepsPossible )
                    return -1;
                currStepsPossible = maxStepsPossible - i;
                jumps++;
            }
        }
        
        return -1;
    }
}
