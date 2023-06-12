package Arrays.Easy;

public class FindMissingNumberInArray {
    // brute force approach 
    // search for every element in the array
    // for ( 0 to n ) LinearSearch(i)
    // time complexity : O(n^2)
    // space complexity : O(n^2)

    // using map array
    // create map array
    // then iterate map array to find if elmenent exists
    // time complexity : O(n)
    // space complexity : O(n)


    // optimised solution but we are modifying the original array
    public int missingNumber1(int[] nums) {
        int len = nums.length;
        boolean maxFound = false;
        for ( int i = 0; i < len; i++ ){
            if ( Math.abs(nums[i]) == len ) maxFound = true;
            else
                nums[Math.abs(nums[i])] *= -1;
        }
        int zeroIdx = -1;
        for ( int i = 0; i < len; i++ ){
            if( nums[i] > 0 )
                return i;
            else if ( nums[i] == 0 )
                zeroIdx = i;
        }
        return maxFound ? zeroIdx : len;
    }

    // most optimised method
    // time complexity : O(n)
    // space complexity : O(1)
    public int missingNumber( int [] nums ){
        int len = nums.length;
        int targetSum = (( len + 1 ) * len)/2;
        int sum = 0;
        
        for ( int ele : nums )
            sum += ele;
        return targetSum - sum;
    }
}
