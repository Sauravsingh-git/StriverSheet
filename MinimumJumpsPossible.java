import java.util.Arrays;

public class Trash {
     static int [] dp;
    static int minJumps(int [] arr ){
        int len = arr.length;
        dp = new int [len];
        Arrays.fill(dp,-1);
        int minJumps = minJumpsUtil(arr, 0);

        return minJumps > Math.pow(10, 7) ? -1 : minJumps;
    }
    
    static int minJumpsUtil(int [] arr, int pos){
        if ( pos >= arr.length -1) return 0;
        if ( dp[pos] != -1) return dp[pos];
        if ( arr[pos] == 0 ) return dp[pos] = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE -5;
        for ( int i = pos+1; i <= pos+arr[pos]; i++ ){
            temp = Math.min(temp, minJumpsUtil(arr, i)) + 1;
            if(pos == 4) System.out.println("the call was made to " + i);
            if(pos == 5) System.out.println("The result of call 5 is " + dp[5]);
        }
        
        System.out.println(Arrays.toString(dp));
        return dp[pos] = temp;
    }
    

    public static void main(String [] args){
        int x = minJumps(new int [] {2, 3, 1, 1, 2, 4, 2, 0, 1, 1});
        System.out.println(x);
    }
}
