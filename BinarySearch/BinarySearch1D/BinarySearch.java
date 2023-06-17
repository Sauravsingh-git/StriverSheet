package BinarySearch.BinarySearch1D;

public class BinarySearch {
    // recursive version 
    public int search1(int[] nums, int target) {
        return searchUtil(nums, target, 0, nums.length-1);
    }

    public int searchUtil( int [] nums, int target, int low, int high ){
        if (high < low) return -1;
        int mid = low + ( high - low )/2;
        if ( nums[mid] == target) return mid;
        else if ( nums[mid] > target) return searchUtil(nums, target, low, mid-1);
        else return searchUtil( nums, target, mid+1, high);
    }

    // iterative version
    public int search( int [] nums, int target){
        int low, high;
        low = 0;
        high = nums.length-1;
        int mid;
        while ( low <= high ){
            mid = low + ( high - low)/2;
            if ( nums[mid] == target ) return mid;
            else if ( nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
