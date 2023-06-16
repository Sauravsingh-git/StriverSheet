package Arrays.Medium;

import java.util.*;

public class Permutations {
    // when elements are unique
    // time complexity : O(n * n!)
    // space complexity : O(1)
    // The permutations generated will lexigraphically sorted only when 
    // the input array is lexigraphically sorted
    public List<List<Integer>> getPermutations(int [] arr){
        List<List<Integer>> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }
    private void permute(int [] arr, int idx, List<List<Integer>> result)
    {
       
        if (idx == arr.length-1){
            List<Integer> temp = new ArrayList<>();
            for ( int ele : arr )
                temp.add(ele);
            result.add(temp);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permute(arr, idx + 1, result);
            swap(arr, idx, i);
        }
    }
    // !!!!!!!!!!!!!!!!!!!mistake in this question 
    // call the recurcise call with i instead of idx

    public void swap( int [] arr, int x, int y ){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // # approach 1 - brute force
    // when elements are repeated and you only need to print unique permutations
    // brute force approach
    // generate all the possible permutations and filter out the unique string


    // optimized approach
    // Time complexity : O(n*n!)
    // Space complexity : O(n)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutationUniqueUtil( nums, 0, permutations);
        return permutations;
    }

    public void permutationUniqueUtil( int [] nums, int idx, List<List<Integer>> result ){
        if ( idx == nums.length ){
            List<Integer> currList = new ArrayList<>();
            for ( int ele : nums )
                currList.add(ele);
            result.add(currList);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for ( int i = idx; i < nums.length; i++ ){
            if ( set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, i, idx);
            permutationUniqueUtil(nums, idx+1, result);
            swap(nums, i, idx);
        }
    }
    public static void main(String [] arggs){
        Set<int [] > set = new HashSet<>();        
    }
}
