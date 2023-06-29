package Heaps.Basic;

public class ExtractMax {
    public int extractMax(int [] H, int s) {
        int temp = H[0];
        H[0] = H[s-1];
        s--;
        heapifyDownwards(H, 0, s);
        return temp;
    }
    
    public void heapifyDownwards(int [] heap, int idx, int len){
        if( idx >= len/2) return;
        int largest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if ( left < len && heap[left] > heap[largest] ) largest = left;
        if ( right < len && heap[right] > heap[largest] ) largest = right;
        if ( largest != idx ){
            swap(heap, idx, largest);
            heapifyDownwards(heap, largest, len);
        }
    }
    
    public void swap ( int [] heap, int idx1, int idx2){
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
}
