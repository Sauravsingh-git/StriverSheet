package Arrays.Hard;
import java.util.*;
class CountingInversion{
    public static void main(String [] args ){
        int [] arr = { 2, 4, 1, 3, 5};
        CountingInversion obj = new CountingInversion();
        int x = obj.merge(arr, 0, 4);
        String str = Arrays.toString(arr);
        System.out.println(x);
    }

    public int merge( int [] arr, int low, int high ){
        int count = 0;
        if ( low < high){
            int mid = ( low+high )/2;
            count += merge(arr, low, mid);
            count += merge( arr, mid+1, high);
            count += mergeSort( arr, low, mid, high);

        }
        return count;
    }

    public int mergeSort( int [] arr, int low, int mid, int high){
        int len = high - low + 1;
        int idx = 0;
        int idx1 = low;
        int idx2 = mid+1;

        int [] sortedArr = new int [len];
        int count = 0;
        while ( idx1 <= mid && idx2 <= high){
            if( arr[idx1]  <= arr[idx2] ){
                sortedArr[idx] = arr[idx1++];
            }else{
                sortedArr[idx] = arr[idx2++];
                count += (mid- idx1+1);
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
        return count;
    }
}