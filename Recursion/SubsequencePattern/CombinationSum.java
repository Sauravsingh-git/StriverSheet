package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(candidates, 0, target, new ArrayList<>(), combinations);
        return combinations;
    }
    
    private void combinationSum(int [] candidates, int idx, int target, List<Integer> currList, List<List<Integer>> combinations){
          if ( target == 0 ) {
              combinations.add(new ArrayList<>(currList));
              return;
          }  

          for ( int i = idx; i < candidates.length; i++){
              if ( target - candidates[i] <= 0 ){
                  currList.add(candidates[i]);
                  combinationSum(candidates, i , target - candidates[i], currList, combinations);
                  currList.remove(currList.size()-1);
              }
          }
    }
}
