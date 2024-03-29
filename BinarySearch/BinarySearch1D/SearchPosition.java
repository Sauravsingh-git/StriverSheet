package BinarySearch.BinarySearch1D;

public class SearchPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0; 
        int right = nums.length;
        int mid;
        while(left < right){
            mid = left + (right -left)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else{
                right = mid;
            }
        }
        return left;
    }
}
