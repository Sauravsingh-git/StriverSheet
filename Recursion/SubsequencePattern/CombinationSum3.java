package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    // time complexity : O(2^n)
    // space complexity : O(n) auxillary space + space for currList
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum3Util(n, k, 1, new ArrayList<Integer> (), combinations);
        return combinations;
    }

    public void combinationSum3Util(int target,  int subsetSize, int currNumber, List<Integer> currList, List<List<Integer>> result){
        if ( subsetSize <=0 || target <= 0 ){
            if ( subsetSize == 0 && target == 0 ){
                result.add(new ArrayList<>(currList));
            }
            return;
        }

        for ( int i = currNumber; i < 10; i++ ){
            currList.add(i);
            combinationSum3Util(target - i, subsetSize-1, i + 1, currList, result );
            currList.remove(currList.size()-1);
        }
    }
}
