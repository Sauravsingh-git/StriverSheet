package Heaps.Basic;

public class CheckIfArrayIsHeap {
    // approach : to check if an array is heap or not
    // recursively check at everynode if the property of max heap 
    // that parent should be greater than child is satified or not
    // we don't need to check if its sparse matrix or not
    // time complexity : O(n)
    // space complexity : O(n) auxillary space 
    public boolean countSub(long arr[], long heapSize){
        return checkIfHeap( arr, 0, heapSize);
    }
    
    public boolean checkIfHeap ( long [] arr, int idx, long heapSize){
        if ( idx >= heapSize ) return true;
        int left = left(idx);
        int right = right(idx);
        if ( left < heapSize && arr[left] > arr[idx]) return false;
        if ( right < heapSize && arr[right] > arr[idx]) return false;
        return checkIfHeap(arr, left, heapSize) && checkIfHeap(arr, right, heapSize);
    }
    
    public int left ( int i){
        return 2 * i + 1;
    }
    
    public int right ( int i){
        return 2 * i + 2;
    } 
}
