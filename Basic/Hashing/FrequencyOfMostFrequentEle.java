package Basic.Hashing;


public class FrequencyOfMostFrequentEle {
    // optimized appraoch 
    // using sliding window
    // approach : use a prefixSum array to get the SumUnitNow and then compare with requiredSumUntil
    // and check if k satisfies it
    // to get faster time complexity, we can use counting sort in place of Arrays.sort()
    // since we have limited range of numbers
    public int maxFrequency(int [] nums, int k){
        int len = nums.length;
        //Arrays.sort(nums);
        countingSort(nums);
        long [] prefixSum = new long[len];
        prefixSum[0] = nums[0];
        for ( int i = 1; i < len; i++ ){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        int i = 0, j = 1;
        int maxFrequency = 1;
        while ( i < nums.length && j < nums.length){
            long requiredSum = nums[j] * ( j - i + 1);
            long currSum  = prefixSum[j] - (i == 0 ? 0 : prefixSum[i-1]);
            if ( currSum + k >= requiredSum){
                maxFrequency = Math.max(maxFrequency, j - i + 1);
                j++;
            }else{
                i++;
            }
        }
        return maxFrequency;
    }

    private void countingSort(int [] nums){
        int max = Integer.MIN_VALUE;
        for ( int ele : nums ) 
            max = Math.max(max, ele);
        
        int [] map = new int [max + 1];
        for ( int ele : nums )
            map[ele]++;
        
        int idx1 = 0, idx2 = 0;

        while ( idx1 < nums.length){
            if ( map[idx2]-- > 0 )
                nums[idx1++] = idx2;
            else
                idx2++; 
        }
    }

    // brute force approach 
    // time complexity : O(n^2)
    // space complexity : O(n)
    // public int maxFrequency(int[] nums, int k) {
    //     Map<Integer, Integer> map = new TreeMap<>();
    //     for ( int ele : nums ){
    //         map.put(ele, map.getOrDefault(ele, 0)+1);
    //     }
    //     int maxFrequency = 1;
    //     List<Integer> list = new ArrayList<>(map.keySet());
    //     for ( int i = 0; i < list.size(); i++ ){
    //         int currIdx = i;
    //         int currEle = list.get(i);
    //         int currFreq = 0;
    //         int tempK = k;
    //         while ( currIdx >= 0 && k > 0 ){
    //             int temp = list.get(currIdx);
    //             int diff = currEle - temp;
    //             if ( diff == 0 )  currFreq += map.get(temp);
    //             else{
    //                 if ( tempK/diff == 0 ){
    //                     currIdx--;
    //                     continue;
    //                 };
    //                 int numberOfElementsUsed = tempK/diff > map.get(temp) ? map.get(temp) : tempK/diff;
    //                 currFreq += numberOfElementsUsed;
    //                 tempK -= diff * numberOfElementsUsed;
    //             } 
    //             currIdx--;             
    //         }
    //         maxFrequency = Math.max(maxFrequency, currFreq);
    //     }
    //     return maxFrequency;
    // }
}
