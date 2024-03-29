package Arrays.Hard;

import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int start;
        int end;
        
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || (nums[i-1] != nums[i])){
                    int targetSum = 0-nums[i];
            start = i+1;
            end = nums.length-1;
            while(start<end){
                
                    if(nums[start] + nums[end] >targetSum){
                        end--;
                    }else if(nums[start] + nums[end] <targetSum){
                        start++;
                    }else if(nums[start] + nums[end] == targetSum){
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while(start< end && nums[start] == nums[start+1])
                            start++;
                        while(start<end && nums[end] == nums[end-1])
                            end--;
                        start++;
                        end--;
                    }
                }
            }
           
        }
        return res;
    }
}
