package Arrays.Easy;

public class NumberThatAppearsOnce {
    // brute force
    // sort the array and find the element which occurs only once
    // time complexity : O( nlogn)

    // in linear time
    // use hashMap to store the frequency of the elements
    // time complexity : O(n)
    // space complexity : O(n)

    // using xor operation to find the number which occurs only once
    // those bit bit patterns which are repeated twice will result to 0
    // the number which occurs only once will have a bit pattern which occurs only once
    // therefore that will be the answer
    // time complexity : O(n)
    // space complexity : O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
               
    }
}
