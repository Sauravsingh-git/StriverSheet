package GreedyAlgorithm.Medium;

public class NumberOfJumpsI {

    // brute force approach : 
    // try all the possible jumps
    // time complexity : O(n*n^n) -> we can have n calls for an idx
    // space complexity : O(n) auxillary space
    public boolean canJumpBF( int [] arr ){
        boolean [] canJump = new boolean [1];
        canJumpUtil(arr, 0, canJump);
        return canJump[0];
    }

    public void canJumpUtil( int [] arr, int idx, boolean [] canJump){
        if ( idx >= arr.length-1 ){
            canJump[0] |= true;
            return;
        }
        int jumps = arr[idx];
        for ( int i = 1; i <= jumps; i++ ){
            canJumpUtil(arr, idx+1, canJump);
            if ( canJump[0] ) return;
        }
    }
    // greedy approach : 
    // we will traverse the array from len-2 idx to 0, if we find a number of jumps to be greater than zero
    // then we call certainly move to covered part of the array, so we don't do any thing
    // if we find zero jumps on curr idx, we try to find an index which the number of jumps greater than or equal 
    // to number of jumps which allows us to skip this zero idx
     public boolean canJump(int[] arr) {
        if(arr.length <2)
        return true;
        int len = arr.length;
        for(int i=len-2; i>-1; i--){
            if(arr[i]<0)
            continue;
            if(arr[i] == 0){
                int jumps = 0;
                int counter = i;
                while(counter > -1 && arr[counter] <= jumps){
                    jumps++;
                    counter--;
                }
                if(counter == -1){
                    return false;
                }
            }
        }
        return true;
    }
}
