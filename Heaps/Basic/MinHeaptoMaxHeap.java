package Heaps.Basic;

public class MinHeaptoMaxHeap {
    // we have used heapify to do it
    // time complexity : O(n)
    // space complexity : 
    static void convertMinToMaxHeap(int N, int arr[]) {
        heapifyMax(arr, N-1);
    }
    
    private static void heapifyMax( int [] heap, int n){
        for ( int i = n/2; i >= 0; i-- ){
            heapify(heap, i, n);
        }
    }
    
    public static void heapify(int [] heap, int idx, int n){
        // if the node is already at leaf node you do not need to do anything
        if( idx > n/2) return;
        
        // if the node is non leaf node
        int largest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if ( left <= n && heap[largest] < heap[left])
            largest = left;
        if ( right <= n && heap[largest] < heap[right])
            largest = right;
        if ( largest != idx ){
            swap(heap, largest, idx);
            heapify(heap, largest, n);
        }
        
    }
    
    private static void swap ( int [] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
