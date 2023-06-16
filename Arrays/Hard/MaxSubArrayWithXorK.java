package Arrays.Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxSubArrayWithXorK {
    // brute force approach
    // generate all subarrays and check if they satisfy the condition
    // time complexity : O(n^2)
    // space complexity : O(1)
    public int solve1(ArrayList<Integer> A, int B) {
        int counter = 0;
        for ( int i = 0; i < A.size(); i++ ){
            int temp = 0;
            for (int j = i; j < A.size(); j++ ){
                temp ^= A.get(j);
                if( temp == B) counter++;
            }
        }
        return counter;
    }
    
    // using hashMap
    // same approach of maintaining prefix hashMap will be used
    // like it was used in find the subarrays with sum k 
    
    public int solve ( ArrayList<Integer> list, int k ){
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currXor = 0;
        for( int i = 0; i < list.size(); i++ ){
            currXor ^= list.get(i);
            if ( currXor == k ) counter++;
            if ( map.containsKey(k ^ currXor))
                counter += map.get(k^currXor);
            map.put(currXor, map.getOrDefault(currXor, 0)+1);
        }
        return counter;
    }

}
