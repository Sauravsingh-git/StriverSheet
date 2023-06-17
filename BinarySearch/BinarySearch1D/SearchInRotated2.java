package BinarySearch.BinarySearch1D;

public class SearchInRotated2 {
    public boolean search( int [] arr, int target){
        int low = 0;
        int high = arr.length -1;
        while ( low <= high ){
            int mid = ( high - low )/2 + low;
            
            if ( arr[mid] == target ) return true;
            if ( arr[mid] == arr[low] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }
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
        return false;
    }
}
