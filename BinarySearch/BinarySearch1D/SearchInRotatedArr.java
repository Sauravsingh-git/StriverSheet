package BinarySearch.BinarySearch1D;

public class SearchInRotatedArr {

    public int search( int [] arr, int target){
        int low = 0;
        int high = arr.length -1;
        while ( low <= high ){
            int mid = ( high - low )/2 + low;
            if ( arr[mid] == target ) return mid;
            // first half is sorted
            if ( arr[low] <= arr[mid] ){
                if ( target >= arr[low] && target < arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                // second half is sorted
                if ( target >= arr[mid+1] && arr[high] >= target ){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    
    // time complexity : O(logn)
    // space complexity : O(1)
    public int search1(int[] nums, int target) {
        int idx = findPivotBS(nums);
        int len = nums.length;
        if ( idx == -1 ) return binarySearch(nums, target, 0, len-1);
        // binary Search from 0 to idx
        int result = binarySearch(nums, target, 0, idx);
        // binary Search from idx+1 to len-1
        if ( result == -1)
            return binarySearch(nums, target, idx+1, len-1);
        
        return result;
    }
    // time complexity : O(n)
    public int findPivotLS(int [] arr){
        if(arr.length == 1) return -1;
        for ( int i =0; i < arr.length-1; i++ ){
            if ( arr[i] > arr[i+1]) return i+1;
        }
        return -1;
    }
    // time complexity : O(n)
    public int findPivotBS(int [] arr){
        int len = arr.length;
        if ( len== 1) return -1;
        // condition for finding the pivot
        // arr[mid-1] < arr[mid] > arr[mid+1]
        int low = 0;
        int high = arr.length-1;
        while ( low <= high ){
            int mid = ( high - low )/2 + low;
            if ( mid < len-1 &&  arr[mid] > arr[mid+1])
                return mid;
            if ( arr[low] <= arr[mid])
                low = mid+1;
            else 
                high = mid-1;
            
        }
        return -1;
    }
    // timc compelxity : O(logn)
    public int binarySearch( int [] arr, int target, int low, int high){
        while ( low <= high ){
            int mid = ( high - low )/2 + low;
            if ( arr[mid] == target) return mid;
            if ( arr[mid] > target ) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
