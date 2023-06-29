package SlidingWindow.Basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitsInBasket {
    // generate all possible subarrays, 
    // then check if they contains less than equal to two fruits
    // time complexity : O (n^3)
    // space complexity : O(1)
    public int totalFruitsBF(int N, int[] fruits) {
        int maxFruits = 0;
        for ( int i = 0; i < N; i++ ){
            for ( int j = i; j < N; j++ ){
                if( containsLessThan2Fruits(fruits, i, j+1))
                    maxFruits = Math.max(maxFruits, j - i + 1);
            }
        }
        return maxFruits;
    }
    public boolean containsLessThan2Fruits(int [] fruits, int lb, int ub){
        Set<Integer> set = new HashSet<>();
        for ( int i = lb; i < ub; i++ ){
            set.add(fruits[i]);
            if ( set.size() > 2 ) return false;
        }
        return true;
    }
    // sliding window 
    //Time complexity:O(N)
    //space complexity:O(N)
    public static int totalFruits ( int N, int [] fruits){
        HashMap<Integer, Integer> map = new HashMap<>();
        int start, end, maxFruits;
        start = end = maxFruits = 0;
        while ( end < N ){
            map.compute(fruits[end], (k,v)-> v== null ? 1 : v+1);
            if ( map.size() > 2){
                while ( start < end && map.size() > 2 ){
                    if (map.get(fruits[start]) == 1){
                        map.remove(fruits[start]);
                    }else{
                        map.put(fruits[start], map.get(fruits[start])-1);
                    }
                    start++;
                }
            }
            maxFruits = Math.max(maxFruits, end - start + 1);
            end++;
        }
        
        return maxFruits;
    }
}
