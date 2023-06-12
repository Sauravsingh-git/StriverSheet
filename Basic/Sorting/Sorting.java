package Basic.Sorting;
import java.util.*;
class Sorting{
    // bucket sorting
    // used when data is uniformly spread across a range
    // put the elements in a bucket
    // then sort the buckets
    // then append the buckets


    // bucket sort
    // create an array of size n of buckets
    // enter the elements in the right bucket
    // use collections.sort to sort the bucket
    // add the sorted buckets to the array
    public void bucketSort( float [] arr){
        int len = arr.length;
        @SuppressWarnings("unchecked")
        ArrayList<Float> [] bucket = new ArrayList [len];
        for ( int i = 0; i < len; i++ ){
            bucket[i] = new ArrayList<Float>();
        }

        // put elements in different bucket
        for ( int i = 0; i < len; i++ ){
            float idx = arr[i] * len;
            bucket[(int)idx].add(arr[i]);
        }

        for ( int i = 0; i < len; i++ ){
            Collections.sort(bucket[i]);
        }

        int idx = 0;
        for( int i = 0; i < len; i++ ){
            for ( int j = 0; j < bucket[i].size(); j++ ){
                arr[idx++] = bucket[i].get(j);
            }
        }
    }
    // Radix sort
    // uses couting sort as a subroutine
    // dont forget to reduce the value of bucket after using it

    public void radixSort(int arr[], int n) 
    { 
        int max = arr[0];
        for ( int ele : arr) 
            max = Math.max(ele, max);
            
        for ( int exp = 1; max/exp > 0; exp *=10){
            countingSort(arr, exp);
        }
    } 
    
    public void countingSort( int [] arr, int exp){
        int len = arr.length;
        
        int [] map = new int [10];
        // filling the map array
        for ( int i = 0; i < len; i++ ){
            map[(arr[i]/exp)%10]++;
        }
        // getting the actual positions
        for(int i = 1; i < 10; i++ ){
            map[i] += map[i-1];
        }
        
        int [] outputArr = new int[len];
        for ( int i = len-1; i >= 0; i-- ){
            outputArr[map[(arr[i]/exp)%10]-1] = arr[i];
            // to set it to the position of remaining elements in the bucket
            map[(arr[i]/exp)%10]--;
        }
        
        // copying the output arr to the orignal array
        for ( int i = 0; i < len; i++ ){
            arr[i] = outputArr[i];
        }
        
    }
    // couting sort
    // create a map for all those elements available in the array
    // get the actual positions in the map array
    // use outputarr[map[arr[i]]-1] = arr[i]
    // reduce the value in map to point it to the next pos
    // copy the outputArr to the original array
    public String countSort(String word)
    {
        char [] arr = word.toCharArray();
        int len = arr.length;
        int [] map = new int[26];
        for ( char ch : arr )
            map[ch-'a']++;
             
        
        // getting the actual posititons of the characters
        for ( int i = 1; i < 26; i++ ){
            map[i] += map[i-1];
        }
        // populating the new array
        char [] outputarr = new char [len];
        
        for ( int i = len-1; i >= 0; i--){
            outputarr[map[arr[i]-'a']-1] = arr[i];
            map[arr[i]-'a']--;
        }
        return new String(outputarr);
    }
    // shell sort
    // 3 for loops will run
    // for loop1 ( int gap = n/2; gap < n; gap /= 2)
    // for loop2 ( int i = gap; i < n; i++ )
    // for loop3 ( int j = i; j > 0 && arr[j] > arr[j-gap]; j -= gap)
    //              swap(j, j-gap)

    public void shellSort( int [] arr ) {
        int len = arr.length;
        for ( int gap = len/2;  gap > 0; gap /=2 ){
            for ( int i = gap; i < len; i++ ){
                int temp = arr[i];
                int j;
                for ( j = i; j >= gap && arr[j-gap] > temp; j -= gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }
     // insertion sort
    public void insertionSort(int [] arr){
        int n = arr.length;
        for( int i = 1; i < n; i++ ){
            int ele = arr[i];
            int j = i-1;
            while( j >= 0 && arr[j] > ele){
                arr[j+1] = arr[j];
                j--;
            }
            arr[++j] = ele;
        }
    }

    // insertion Sort
    public void insertionSortRecur(int arr[], int n){
      insertionSortRecurUtil(arr, 1, n-1);
    }
  
  public void insertionSortRecurUtil( int [] arr, int sIdx, int lIdx){
      if (sIdx > lIdx) return;
      int j = sIdx;
      while ( j > 0 && arr[j] < arr[j-1] ){
          swap(arr, j, j-1);
          j--;
      }
      insertionSortRecurUtil(arr, sIdx+1, lIdx);
  }
    // selection Sort
    public void selectionSort( int [] arr){
        int n = arr.length;
        for( int i = 0; i < n; i++ ){
            int minIdx  = i;
            for( int j = i+1; j < n; j++ ){
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    // Bubble sort
    public void bubbleSort( int [] arr){
        int len = arr.length;
        for( int i = 0; i < len-1; i++){
            for( int j = 0; j < len-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //  bubble sort recursive
    public void bubbleSortRecur(int arr[], int n){
        if ( n == 1) return;
        
        for ( int i = 0 ; i < n-1; i++ ){
            if ( arr[i] > arr[i+1])
                swap(arr, i, i+1);
        }
        
        bubbleSortRecur(arr, n-1);
    }

    // quick Sort 
    public void quickSort( int [] arr, int low, int high ){
        if ( low < high ){
            int pivotIdx = findPivot(arr, low, high);
            quickSort(arr, low, pivotIdx -1);
            quickSort(arr, pivotIdx+1, high);
        }
    }

    public int findPivot(int [] arr, int low, int high){
        int pivotEle = arr[high];
        int pivotIdx = low;
        for( int i = low; i <= high; i++ ){
            if(arr[i] < pivotEle){
                swap(arr, i, pivotIdx);
                pivotIdx++;
            }
        }
        swap(arr, pivotIdx, high);
        return pivotIdx;
    }

    public void swap( int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    

    // Merge Sort
    public void merge( int [] nums, int low, int high){
        if ( high > low ){
            int mid = low + ( high - low )/2;
            merge(nums, low, mid);
            merge(nums, mid+1, high);
            mergeSort( nums, low, mid, high);
        }
    }

    public void mergeSort(int [] nums, int low, int mid, int high){
        int [] tempArr = new int [high - low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while ( i <= mid && j <= high){
            if( nums[i] > nums[j]){
                tempArr[k++] = nums[j++];
            }else{
                tempArr[k++] = nums[i++];
            }
        }

        while ( i <= mid ){
            tempArr[k++] = nums[i++];
        }
        while ( j <= high){
            tempArr[k++] = nums[j++];
        }
        for ( i = 0; i < tempArr.length; i++ ){
            nums[low+i] = tempArr[i];
        }
    }
}