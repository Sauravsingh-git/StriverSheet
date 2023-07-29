package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsUtil(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void subsetsUtil( int [] nums, int idx, List<Integer> currList, List<List<Integer>> list ){
        if ( idx == nums.length ) {
            list.add(new ArrayList<Integer>(currList));
            return;
        }
        // do not add the current element
        subsetsUtil(nums, idx+1, currList, list);

        // add the current element to the current list
        currList.add(nums[idx]);
        subsetsUtil(nums, idx+1, currList, list);
        currList.remove(currList.size()-1);
    }
}
