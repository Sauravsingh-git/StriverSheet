package BinarySearch.BinarySearch1D;

public class PeakElement {
    // brute force approach
    // doing a linear search
    public int findPeakElement1(int[] arr) {
        int len = arr.length;
        for ( int i = 1; i < len-1; i++ ){
            if ( arr[i] > arr[i-1] && arr[i] > arr[i+1]) return i;
        }
        return -1;
    }

    // optimized approach
    // time complexity : O( logn)
    // space complexity : 
    public int findPeakElement( int [] arr){
        int len = arr.length;
        int low = 0;
        int high = len- 1;

        while ( low <= high ){
            int mid = ( high + low)/2;
            if  (  ( mid == len-1 || arr[mid] > arr[mid+1] )&& ( mid == 0 || arr[mid-1] < arr[mid]))
                return mid;
            else if ( mid > 0 && arr[mid-1] > arr[mid] ){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
