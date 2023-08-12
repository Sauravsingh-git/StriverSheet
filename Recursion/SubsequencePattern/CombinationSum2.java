package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    // approach 1 : using the same method we used in generating permutations
    // intuition : 
    // we cannot use a number twice and also the generated combinations should be distinct
    // since we cannot use a number twice so unlike combinationSum1 we will call on idx+1 after having used elements upto idx
    // also to avoid getting same combinations we will sort the elements and skip the calls where candidate[idx] == candidate[i-1]
    // except for the first call
    // time complexity : O(2^n)
    // space complexity : O(n) for currList and also used stack space
    public List<List<Integer>> combinationSum2_approach1(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Util_approach1(candidates, target, 0, new ArrayList<Integer>(), combinations);
        return combinations;
    }

    public void combinationSum2Util_approach1(int [] candidates, int target, int idx, List<Integer> currList, List<List<Integer>> result){
        if ( target <= 0 ) {
            if ( target == 0 )
                result.add(new ArrayList<>(currList));
            
            return;
        }

        for( int i = idx; i < candidates.length; i++ ){
            if ( i != idx && candidates[i] == candidates[i-1]) continue;
            currList.add(candidates[i]);
            combinationSum2Util_approach1(candidates, target - candidates[i], i+1, currList, result);
            currList.remove(currList.size()-1);
        }
    }

    // approach 2 : 
    // using hashMap table to only select a number from a group ( occurences of that same number )
    public List<List<Integer>> combinationSum2( int [] candidates, int target ){
        int [] counterTable = new int [51];
        for ( int ele : candidates )
            counterTable[ele]++;

        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum2Util(counterTable, target, 0, new ArrayList<>(),  combinations );
        return combinations;
    }

    public void combinationSum2Util( int [] counterTable, int target, int idx, List<Integer> currList, List<List<Integer>> result ){
        if ( target <= 0 ){
            if ( target == 0 )
                result.add(new ArrayList<>(currList));
            return;
        }

        for( int i = idx; i < 51; i++ ){
            if ( counterTable[i] == 0 ) continue;

            counterTable[i]--;
            currList.add(i);
            combinationSum2Util(counterTable, target - i, i, currList, result);
            currList.remove(currList.size()-1);
            counterTable[i]++;
        }
    }
}
