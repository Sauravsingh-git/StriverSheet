package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
     public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<len-3; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<len-2; j++){
                if(j != i+1 && nums[j] == nums[j-1])continue;
                long temp = (long)target - nums[i] - nums[j];
                int leftPtr = j+1;
                int rightPtr = len-1;
                while(leftPtr < rightPtr){
                    if(temp - nums[leftPtr]  >  nums[rightPtr])
                        leftPtr++;
                    else if( temp - nums[leftPtr] < nums[rightPtr])
                        rightPtr--;
                    else{
                        result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[leftPtr], nums[rightPtr])));
                        while(leftPtr< rightPtr && nums[leftPtr] == nums[leftPtr+1]) leftPtr++;
                        while(leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr-1]) rightPtr--;
                        leftPtr++;
                        rightPtr--;
                    }
                }
            }
        }
        return result;
    }
}
