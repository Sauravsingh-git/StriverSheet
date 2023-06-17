package Arrays.Hard;
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort( nums, 0, nums.length-1);
    }
    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > 2 *(long) arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }  
    public int mergeSort( int [] arr, int low, int high ){
        int count = 0;
        if ( low < high){
            int mid = ( low+high )/2;
            count += mergeSort(arr, low, mid);
            count += mergeSort( arr, mid+1, high);
            count += countPairs(arr, low, mid, high);
            merge( arr, low, mid, high);

        }
        return count;
    }

    public void merge( int [] arr, int low, int mid, int high){
        int len = high - low + 1;
        int idx = 0;
        int idx1 = low;
        int idx2 = mid+1;

        int [] sortedArr = new int [len];
        while ( idx1 <= mid && idx2 <= high){
            if( arr[idx1]  <= arr[idx2] ){
                sortedArr[idx] = arr[idx1++];
            }else{
                sortedArr[idx] = arr[idx2++];
            }
            idx++;
        }

        while ( idx1 <= mid ){
            sortedArr[idx] = arr[idx1++];
            idx++;
        }
            
        
        while ( idx2 <= high ){
            sortedArr[idx] = arr[idx2++];
            idx++;
        }


        for ( int i = 0; i < len; i++ ){
            arr[low+i] = sortedArr[i];
        }
    }
}
