package Arrays.Medium;

public class KadaneAlgo {

    public int maxSubArray(int[] nums) {
        // we initialize the maxSubArr with min_value when we don't cosider empty arr
        // otherwise we initilize it with zero
        int maxSubArr = Integer.MIN_VALUE;
        int len = nums.length;
        int sum = 0;
        for ( int i = 0; i < len; i++ ){
            sum += nums[i];
            if ( sum> maxSubArr )
                maxSubArr = sum;
            if ( sum < 0 )
                sum = 0;
        }
        return maxSubArr;
    }

    // getting the start and the ending index of the subArr
    public int [] printingMaxSubArrSum(int [] arr){
        int len = arr.length;
        int maxSubArrSum = Integer.MIN_VALUE;
        int currSum = 0;
        int startIdx = 0;
        int endIdx = 0;
        for( int i = 0; i < len; i++ ){
            currSum += arr[i];
            if ( currSum > maxSubArrSum ){
                maxSubArrSum = currSum;
                endIdx = i;
            }
            if ( currSum < 0 ){
                currSum = 0;
                startIdx = i+1;
            }
        }
        return new int []{startIdx, endIdx};
    }

}
