package StackAndQueues.MonotonicStackQueue;

public class CountOfEleGreaterToRight {
    // brute force 
    // time complexity : O(m * n)
    // space complexity : O(1)
    public static int[] countGreaterBF(int []arr, int []query) {
        int n = arr.length, m = query.length;
        int [] result = new int [m];
        for ( int i = 0; i < m; i++ ){
            int currEleIdx = query[i];
            int currEle = arr[currEleIdx];
            int greaterCount = 0;
            for ( int j = currEleIdx+1; j < n; j++ ){
                if ( arr[j] > currEle ) greaterCount++;
            }
            result[i] = greaterCount;
        }
        return result;
    }


    // using mergeSort
    // time complexity : O(nlogn)
    // space complexity : O(n)
    public static int [] countGreater( int [] arr, int [] query ){
        int len = arr.length;
        int [] count = new int[len];
        Pair [] items = new Pair[len];
        for ( int i = 0; i < len; i++ ){
            items[i] = new Pair(arr[i], i);
        }
        mergeSort(items, 0, len-1, count);
        int [] querySet = new int[query.length];
        int i = 0;
        for ( int ele : query ){
            querySet[i++] = count[ele];
        }
        return querySet;
    }

    public static void mergeSort( Pair [] arr, int low, int high, int [] result){
        if ( low < high ){
            int mid = ( low + high ) >> 1;
            mergeSort(arr, low, mid, result);
            mergeSort(arr, mid+1, high, result);
            merge(arr, low, mid, high, result);
        }
    }

    public static void merge( Pair [] arr, int low, int mid, int high, int [] result){
        int len = high - low + 1;
        Pair [] sorted = new Pair [len];
        int i, j, k;
        i = low;
        j = mid + 1;
        k =  0;
        while ( i <= mid && j <= high ){
            if ( arr[i].val >= arr[j].val){
                sorted[k] = arr[j];
                j++;
            }else{
                sorted[k] = arr[i];
                result[arr[i].idx] += high - j + 1;
                i++;
            }
            k++;
        }

        while ( j <= high ){
            sorted[k] = arr[j];
            j++;
            k++;
        }

        while ( i <= mid ){
            sorted[k] = arr[i];
            i++;
            k++;

        }
        for  ( k = 0; k < len; k++ ){
            arr[low + k] = sorted [k];
        }
    }
}

class Pair{
    int val, idx;
    public Pair( int val, int idx ){
        this.val = val;
        this.idx = idx;
    }
}
    

