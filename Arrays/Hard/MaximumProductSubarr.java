package Arrays.Hard;

public class MaximumProductSubarr {
    // brute force approach:
    // generate all the subarrays and get the maximum Product


    // optimized array
    // we have 3 cases : 
    // only positives -> the largest array will be the answer
    // for even negatives -> the largest array will be the answer
    // for odd arrays -> In this case the largest array will be such that it does not include
    // one of the negatives. Since odd negatives would result in a negative result
    
    // if we have zeros, in the list we treat them as splitters
    // we will get prefixProduct and suffixProduct to find the maxProduct
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int prefix = 0, suffix = 0;
        int maxProduct = Integer.MIN_VALUE;
        for ( int i = 0; i < len; i++ ){
            prefix = prefix == 0 ? 1 : prefix;
            suffix = suffix == 0 ? 1 : suffix;
            
            //updating the prefix and suffix
            prefix *= nums[i];
            suffix *= nums[len-i-1];

            maxProduct  = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }
}
