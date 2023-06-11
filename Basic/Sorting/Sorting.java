package Basic.Sorting;

class Sorting{
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