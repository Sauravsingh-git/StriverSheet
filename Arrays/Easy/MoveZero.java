package Arrays.Easy;

public class MoveZero {
    public void moveZeroes( int [] nums ){
        int len = nums.length;
        int zeroIdx = len;
        // find the firstIdx of zero
        for ( int i = 0; i < len; i++ )
            if ( nums[i] == 0 ){
                zeroIdx = i;
                break;
            }
        int normalIdx;
        for ( normalIdx = zeroIdx + 1; normalIdx < len; normalIdx++)
            if ( nums[normalIdx] != 0 )
                swap(  nums, normalIdx, zeroIdx++);  
    }

    public void swap ( int [] arr, int idx1, int idx2 ){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    // not optimal approach
    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        int idx = 0;
        for ( int i = 0; i < len; i++ ){
            if ( nums[i] == 0 ) continue;
            nums[idx++] = nums[i];
        }
        for (int i = idx; i < len; i++){
            nums[i] = 0;
        }
    }
}
