package Arrays.Hard;
import java.util.Arrays;
public class MergeArrays {
    // optimal approach - 1
    // arrange the arrays so that each array contains the element it will
    // contain after the array gets sorted
    // start from the last element of leftArr and first element of rightArr
    // and swap element until leftArr[idx1] > right[idx2]
    // time complexity : (mlogm + nlogn)
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int leftIdx = n-1;
        int rightIdx = 0;
        
        while ( leftIdx >= 0 && rightIdx < m && arr1[leftIdx] > arr2[rightIdx]){
            swap(arr1, arr2, leftIdx--, rightIdx++);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
    public static void swap ( long [] arr1, long []arr2, int x, int y){
        long temp = arr1[x];
        arr1[x] =  arr2[y];
        arr2[y] = temp;
    }
}