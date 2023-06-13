package Arrays.Medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len -2;
        // find the largest prefix so that the rest of the array can be 
        // arranged in such a way that its greater than the curr arrangement
        // i.e., find an element first element which is smaller than element at its right
        // starting from the last idx
        // since we are comparing  nums[i] with nums[i+1] we can start from i = len-2
        while ( i >= 0 ){
            if( nums[i+1] > nums[i] )
                break;
            i--;
        }
        // check if its the edge case and we are at the last arragement of permutation
        if ( i == -1 ){
            reverse(nums, 0, len-1);
            return;
        }
        // find the smallest element greater than nums[i]
        // since the rest of the array is already in descending order
        // just start from last element and find first element bigger than nums[i]
        int j = len-1;
        while ( j > i){
            if ( nums[j] > nums[i] ){
                // swap the first smallest element with i
                swap( nums, i, j);
                break;
            }
            j--;
        }
        // since we want to find the smallest element
        // and the rest of the array is  in the descending order
        // we will just reverse the array to get in sorted order
        reverse(nums, i+1, len-1);
    }

    public void swap( int [] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void reverse( int [] arr, int sIdx, int eIdx){
        while( sIdx < eIdx){
            swap(arr, sIdx++, eIdx--);
        }
    }
}
