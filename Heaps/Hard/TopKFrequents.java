package Heaps.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequents {
    // use hashMap to store occurences
    // then use pq to sort them in descending order by maximum occurences
    // time complexity : O (nlogk)
    // space complexity : O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int ele : nums )
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y)-> y.getValue() - x.getValue());
        for ( Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.offer(entry);
        
        int [] result = new int [k];
       for ( int i = 0; i < k; i++ ){
           result[i] = pq.poll().getKey();
       }
        
        return result;
    }
}
