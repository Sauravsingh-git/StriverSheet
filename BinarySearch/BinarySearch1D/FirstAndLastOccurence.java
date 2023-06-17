package BinarySearch.BinarySearch1D;

public class FirstAndLastOccurence {
    public int[] searchRange(int[] arr, int target) {
        // finding the first occurence
        int low = 0;
        int high = arr.length -1;
        int firstOccurence = -1;
        while ( low <= high ){
            int mid = ( high - low)/2 + low;
            if ( arr[mid] < target ){
                low = mid+1;
            }else if ( arr[mid] > target ){
                high = mid-1;
            }else{
                firstOccurence = mid;
                high = mid-1;
            }
        }
        if ( firstOccurence == -1) return new int [] { -1, -1};
        low = 0;
        high = arr.length -1;
        int lastOccurence = -1;
        while ( low <= high ){
            int mid = (high - low)/2 + low;
            if (arr[mid] > target){
                high = mid-1;
            }else if ( arr[mid] < target){
                low = mid+1;
            }else{
                lastOccurence = mid;
                low = mid+1;
            }
        }

        return new int [] { firstOccurence, lastOccurence};
    }
}
