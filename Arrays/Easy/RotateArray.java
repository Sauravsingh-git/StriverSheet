package Arrays.Easy;

public class RotateArray {

    // most optimal approach
    // just reverse the whole array
    // reverse from 0 to k-1
    // reverse from k to len-1
    public void rotate( int [] arr, int k){
        int len = arr.length;
        k %= len;
        reverseArray(arr, 0, len-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, len-1);
    }

    public void reverseArray(int [] arr, int low, int high){
        while ( low < high ){
            swap(arr, low++, high--);
        }
    }

    public void swap(int [] arr, int x, int y ){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    // brute force 
    // using another array
    // time complexity : O(n)
    // space complexity : O(n)
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int [] rotatedArr = new int [len];
        k %= len;

        for ( int i = 0; i < len; i++ ){
            rotatedArr[(k+i)%len] = nums[i];
        }

        // copying the rotate array to the original array
        for ( int i = 0; i < len; i++ )
            nums[i] = rotatedArr[i];
    }

    // without using extra space
    // rotate array only 1 step in a single iteration
    // will give TLE
    public void rotate2(int [] nums, int k){
        for ( int i = 0; i < k; i++  )
            rotateByOneStep(nums, nums.length);
    }

    public void rotateByOneStep( int [] arr, int n){
        int temp = arr[n-1];
        for( int i = n-1; i > 0; i-- ){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    
}
