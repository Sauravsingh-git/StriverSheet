import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test {
    static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> nextPermutation = new ArrayList<>();
        int len = arr.length;
        int i = len -2;
        while ( i >= 0 && arr[i] > arr[i+1]){
            i--; 
        }

        if ( i == -1 ){
            for( int k = len-1; k >=0; k-- ){
                nextPermutation.add(arr[k]);
            }
            return nextPermutation;
        }
        
        int j = len-1;
        while ( j > i ){
            if( arr[j] > arr[i])
                break;
            j--;
            System.out.println(" j : " + j);
        }
        
        swap( arr, i, j);
        for ( int k = 0; k <= i; k++){
            nextPermutation.add(arr[k]);
        }
        for( int k = len-1; k > i; k-- )
            nextPermutation.add(arr[k]);
        swap(arr, i, j);
        return nextPermutation;
    }
    
    public static void swap( int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String [] args){
        int [] arr = { 1, 2, 3, 6, 5, 4};
        List<Integer> list = nextPermutation(3, arr);
        System.out.println(list.toString());
    }
}