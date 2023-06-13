package Arrays.Medium;

import java.util.Arrays;

public class Sort012 {
    // brute force
    // Time complexity : O(NlogN)
    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }

    // better approach 
    // using counting sort ( since we have a limited range of colors)
    // time complexity : O(N)
    // space complexity : O(N)
    public void sortColors2( int [] nums ){
        int len = nums.length;
        int count [] = new int [3];
        for ( int ele : nums )
            count[ele]++;
        
        // getting the actual positions
        for ( int i = 1; i < 3; i++ ){
            count[i] += count[i-1];
        }

        // getting the sorted array
        int [] sortedArr = new int [len];
        for ( int i = 0; i < len; i++ ){
            sortedArr[count[nums[i]] -1] = nums[i];
            count[nums[i]]--;
        }

        // setting the outputArr to original arr
        for ( int i = 0; i < len; i++ )
            nums[i] = sortedArr[i];

    }

    // more optimal approach
    // using only 2 iterations
    // time complexity : O(N)
    // space complexity : O(1)
    public void sortColors3(int [] nums ){
        int count0 = 0, count1 = 0, count2 = 0;
        for ( int ele : nums )
            switch( ele ){
                case 0 : count0++;
                        break;
                case 1 : count1++;
                        break;
                case 2 : count2++;
                        break;
            }
        
        int idx = 0;
        while ( count0-- > 0)
            nums[idx++] = 0;

        while ( count1-- > 0)
            nums[idx++] = 1;
        
        while ( count2-- > 0)
            nums[idx++] = 2;
    }

    // most optimal approach
    // using three pointers
    public void sortColors( int [] arr ){
        int low = 0, mid = 0, high = arr.length -1;
        while ( mid <= high ){
            if ( arr[mid] == 0 ){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if ( arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public void swap( int [] arr, int x, int y ){
        int temp = arr[x];
        arr[x ] = arr[y];
        arr[y] = temp;
    }
}
