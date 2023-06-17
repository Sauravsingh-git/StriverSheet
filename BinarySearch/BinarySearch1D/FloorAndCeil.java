package BinarySearch.BinarySearch1D;

import java.util.Arrays;

class Pair{
    int floor, ceil;
    public Pair(int floor, int ceil){
        this.floor = floor;
        this.ceil = ceil;
    }
}

public class FloorAndCeil {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
       Arrays.sort(arr);
       int floor = getFloor(arr, n, x);
       int ceil = getCeil(arr, n, x);
       return new Pair(floor, ceil);
    }
    
    int getFloor(int [] arr, int n, int target ){
        int low, high,mid;
        low = 0;
        high = n-1;
        int floor = -1;
        while ( low <= high ){
            mid = low + (high - low)/2;
            if ( arr[mid] <= target){
                floor = arr[mid];
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return floor;
    }
    
    int getCeil(int [] arr, int n, int target ){
        int low, high,mid;
        low = 0;
        high = n-1;
        int ceil = -1;
        while ( low <= high ){
            mid = low + (high - low)/2;
            if ( arr[mid] >= target){
                ceil = arr[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ceil;
    }
}
