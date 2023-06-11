package Basic.Hashing;
import java.util.*;
public class FrequencyOfLimitedRangeOfArrEle {
    // que : given an array with elements from 1 to P
    // find frequency of elements from 1 to N in an array
    // modify the array in place
    public static void frequencyCountUsingHM(int arr[], int N, int P){   

        Map<Integer, Integer> map = new HashMap<>();
        for ( int ele : arr )
            map.put(ele, map.getOrDefault(ele, 0)+ 1);
        
        for ( int i = 1; i <= N; i++ )
            arr[i-1] = map.getOrDefault(i, 0);
        
 
    }
    // using arrays
    public static void frequencyCountUsingArr(int arr[], int N, int P){   
        
        int [] map = new int [P+1];
        for ( int ele : arr )
            map[ele]++;
        for ( int i = 1; i <= N; i++ ){
            if(i <= P)
            arr[i-1] = map[i];  
            else
            arr[i-1] = 0;
        }
    }

}
