package BinarySearch.BinarySearch1D;

public class MinNumberInRotateArray {
     public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot+1];
    }

    public int findPivot( int [] nums){
        int len = nums.length;
        int low = 0;
        int high = nums.length-1;
        while ( low <= high ){
            int mid = ( high -  low)/2 + low;
            if ( mid < len-1 && nums[mid] > nums[mid+1])
                return mid;
            else if (  nums[low] <= nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
