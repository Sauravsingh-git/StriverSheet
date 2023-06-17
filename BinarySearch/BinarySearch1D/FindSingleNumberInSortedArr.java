package BinarySearch.BinarySearch1D;

import java.util.HashMap;

public class FindSingleNumberInSortedArr {

    // brute force approach
    // time complexity : O(n)
    // space complexity : O(n)
    public int singleNonDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int ele : nums ){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for ( int ele : nums ){
            if ( map.get(ele) == 1 ) return ele;
        }

        return -1;
    }

    // spaceoptimized approach
    // time complexity : O(n)
    // space complexity : O(1)
    public int singleNonDuplicate2( int [] nums ){
        int len = nums.length;
        for ( int i = 0; i < len; i += 2){
            if( nums[i] != nums[i+1]) return nums[i];
        }
        return -1;
    }

    // using binary Search technique
    public int singleNonDuplicate(int [] arr ){
        int len = arr.length;
        int low = 0; 
        int high = len-1;
        while ( low <= high ){
            int mid = ( high + low ) /2;
            if ( mid%2 == 1 ){
                // index is odd -> we check with previous element
                if ( arr[mid] == arr[mid-1]){
                    // low to mid is correct
                    low = mid+1;
                }else{
                    if (mid != len-1 &&  arr[mid] == arr[mid + 1]){
                        high = mid-1;
                    }else{
                        return arr[mid];
                    }
                }
            }else{
                if ( mid != len-1 && arr[mid] == arr[mid+1]){
                    // array is find until mid
                    low = mid+2;
                }else{
                    if (mid != 0  && arr[mid] == arr[mid-1]){
                        high = mid-1;
                    }else{
                        return arr[mid];
                    }
                }
            }

        }
        return -1;
    }
}

