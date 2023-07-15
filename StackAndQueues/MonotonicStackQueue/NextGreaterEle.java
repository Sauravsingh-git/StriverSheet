package StackAndQueues.MonotonicStackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterEle {
    // optimized approach
    // time complexity : O(n1 + n2)
    // space complexity : O(n1 + n2)
    // intuition
    // using a stack to find the next greater element in the nums2 array in O(n) time
    // use a hashMap to find the element in nums1 in nums2
    public int[] nextGreaterElement ( int [] nums1, int [] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len1 = nums1.length, len2 = nums2.length;
        int [] greaterThanArr = new int [len2];
        int [] result =  new int [len1];
        for ( int i = len2-1; i >= 0; i-- ){
            int currEle = nums2[i];
            map.put(currEle, i);
            while ( !stack.isEmpty() && stack.peek() < currEle )
                stack.pop();
            
            if ( stack.isEmpty() ){
                greaterThanArr[i] = -1;
            }else{
                greaterThanArr[i] = stack.peek();
            }
            stack.push(currEle);
        }

        for ( int i = 0; i < len1; i++ ){
            int currEle = nums1[i];
            result[i] = greaterThanArr[map.get(currEle)];
        }
        return result;
    } 
    // brute force approach
    // time complexity : O(n1^2 + n1*n2)
    // space complexity : O(n1 + n2)
    public int[] nextGreaterElementBF(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int [] greaterEleArr = new int [len2];
        for ( int i = 0; i < len2; i++ ){
            int currEle = nums2[i];
            int greaterEle = -1;
            for ( int j = i + 1; j < len2; j++ ){
                if ( currEle < nums2[j] ){
                    greaterEle = nums2[j];
                    break;
                }
            }
            greaterEleArr[i] = greaterEle;
        }

        int [] result = new int [len1];
        for ( int i = 0; i < len1; i++ ){
            int ele = nums1[i];
            boolean isSet = false;
            for ( int j = 0; j < len2; j++ ){
                if ( nums2[j] == ele){
                    result[i] = greaterEleArr[j];
                    isSet = true;
                    break;
                }
            }
            if( !isSet )
                result[i] = -1;
        }

        return result;
    }
}
