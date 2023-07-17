package StackAndQueues.MonotonicStackQueue;

public class RainWaterTrapping {
    // optimal solution : 
    // intution : if maxLeft < maxRight  -> move the left pointer to the right while collecting the water
    // if the maxLeft > maxRight -> move the right pointer to the left while collecting the water
    // time complexity : O(n)
    // space complexity : O(1)
    public int trap( int [] height ){
        int len = height.length;
        int maxRight, maxLeft;
        int left, right;
        left = 0;
        right = len-1;
        maxRight = maxLeft = 0;
        int water = 0;
        while ( left < right ){
            int currWaterVol = 0;
            if( maxLeft <= maxRight){
                if ( height[left] > maxLeft){
                    maxLeft = height[left];
                    continue;
                }
                currWaterVol = Math.min(maxRight, maxLeft) - height[left];
                left++;
            }else{
                if ( height[right ] > maxRight ){
                    maxRight = height[right];
                    continue;
                }
                currWaterVol = Math.min(maxRight, maxLeft) - height[right];
                right--;
            }
            water += currWaterVol > 0 ? currWaterVol : 0;
        }
        return water;
    }
    // optimised approach
    // time complexity : O(n)
    // space complexity : O(n)
    public int trapO( int [] height){
        int len = height.length;
        int [] prefixArr = new int [len];
        int [] suffixArr = new int [len];
        prefixArr[0] = height[0];
        for( int i = 1; i < len; i++ ){
            prefixArr[i] = Math.max(height[i], prefixArr[i-1]);
        }

        suffixArr[len-1] = height[len-1];
        for ( int i = len-2; i >= 0; i-- ){
            suffixArr[i] = Math.max(height[i], suffixArr[i+1]);
        }

        int water = 0;
        for ( int i = 1; i < len-1; i++  ){
            int currHeight = height[i];
            int currWaterVol = Math.min(suffixArr[i], prefixArr[i]) - currHeight;
            if ( currWaterVol > 0  )
                water += currWaterVol;
        }
        return water;
    }

    // brute force approach : 
    // intuition : at any given point to find the max water carrying capacity at a column
    // max capacity = math.min(maxRight,  maxLeft) - currHeight
    // time compelxity : O(n^2)
    // space complexity : O(1)
    public int trapBF(int[] height) {
        int water = 0;
        int len = height.length;
        for ( int i = 1; i < len; i++ ){
            int greatestLeft, greatestRight;
            greatestLeft = greatestRight = 0;
            int currHeight = height[i];
            // find the greatest left
            for ( int j = i -1; j >= 0; j-- ){
                if ( height[j] > greatestLeft)
                    greatestLeft = height[j];
            }

            // find the greatest right
            for ( int j = i+1; j < len; j++ ){
                if ( height[j] > greatestRight )
                    greatestRight = height[j];
            }   
            int currWaterVolume = Math.min(greatestRight, greatestLeft) - currHeight;
            water +=  currWaterVolume > 0 ? currWaterVolume : 0;
        }
        return water;
    }
}
