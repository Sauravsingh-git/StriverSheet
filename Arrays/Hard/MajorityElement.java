package Arrays.Hard;

import java.util.*;
public class MajorityElement {
    public List<Integer> majorityElement( int [] nums ){
        // optimized approach 
        // time complexity : O(N)
        // space complexity : O(1)
        List<Integer> list = new ArrayList<>();
        int ele1 = 0, ele2 = 0, freq1 = 0, freq2 = 0, idx = 0;
        int n = nums.length;
        while ( idx < n ){
            if ( ele1 == nums[idx]){
                freq1++;
            }else if ( ele2 == nums[idx]){
                freq2++;
            }else if ( freq1 == 0 ){
                ele1 = nums[idx];
                freq1++;
            }else if ( freq2 == 0 ){
                ele2  = nums[idx];
                freq2++;
            }else{
                freq1--;
                freq2--;
            }
            idx++;
        }

        // verifying two candidate elements 
        freq1 = 0;
        freq2 = 0;
        for ( int ele : nums ){
            if ( ele == ele1)
                freq1++;
            else if ( ele == ele2 )
                freq2++;
        }
        int threshold = n/3;
        if ( freq1 > threshold ) list.add(ele1);
        if ( freq2 > threshold ) list.add(ele2);
        return list;
    }
    
    //using HashMap
    public List<Integer> majorityElement1(int[] nums) {
        // approach 1 using hashMap
        // time complexity : O (n)
        // space complexity : O (n)
        Map<Integer, Integer> map = new HashMap<>();
        for ( int ele : nums ){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        Set <Integer> elementsInNums = map.keySet();
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length/3;
        elementsInNums.forEach(ele -> {
            if(map.get(ele) > threshold){
                result.add(ele);
            }
        });
        return result;
    }
}
