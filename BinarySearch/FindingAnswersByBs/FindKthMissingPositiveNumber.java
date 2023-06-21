package BinarySearch.FindingAnswersByBs;

public class FindKthMissingPositiveNumber {
    // using brute force approach
    // checks at every steps if sufficient steps are missing to this idx
    // time complexity : O(n)
    // space compleixty : O(1)
    public int findKthPositiveBF(int[] arr, int k) {
        int len = arr.length;
        int idx = 0;
        while ( idx < len ){
            int diff = arr[idx] -1 - idx;
            if ( k <= diff ) break;
            idx++;
        }   
        if ( idx == 0 ) return k;
        else  {
            int numbersCovered = arr[idx-1] - idx;
            int remainingNumbers = k - numbersCovered;
            return arr[idx-1] + remainingNumbers;
        
        }
    }

    // using binary search to reduce the searching space everytime
    public int findKthPositive( int [] arr, int k ){
        int len = arr.length;
        int low = 0;
        int high = len-1;
        int minIdx = len;
        while ( low <= high ){
            int mid = ( low + high )>>1;
            if ( containsKthPositiveIdx ( arr, mid, k )){
                minIdx = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if ( minIdx == 0 ) return k;
        else  {
            int numbersCovered = arr[minIdx-1] - minIdx;
            int remainingNumbers = k - numbersCovered;
            return arr[minIdx-1] + remainingNumbers;
        
        }
    }

    public boolean containsKthPositiveIdx( int []arr, int idx, int k){
        return arr[idx] -idx-1 >= k;
    }
}
