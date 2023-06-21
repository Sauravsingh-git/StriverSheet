package BinarySearch.FindingAnswersByBs;

public class MinNumberOfDaysToMakeMBoquets {
    // brute force function to find the minDays
    // time complexity : O(10^9 * N ) -> very high time complexity 
    // space complexity : O(N)
    public int minDaysBF(int[] bloomDays, int m, int k) {
        // when number of flowers are less than the total number of flowers required to make m boquets
        if ( m * k > bloomDays.length ) return -1;
        
        //max bloom day 
        int minBloomDay = bloomDays[0];
        for ( int ele : bloomDays)
            minBloomDay = Math.max(minBloomDay, ele);
        
        while ( canMakeBoquets( bloomDays, m, k, minBloomDay)){
            minBloomDay -=1;
        }
        return minBloomDay +1;        
    }

    // using binary search
    // time complexity : O(32 * N) = > O(N)
    // space complexity : O(1)
    public int minDays( int [] bloomDays, int m, int k ){
        int low = 1;
        int high = 1000000000;
        int minDays = -1;
        while ( low <= high ){
            int mid = ( low + high ) >> 1;
            if ( canMakeBoquets( bloomDays, m, k , mid)){
                minDays = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            } 
        }
        return minDays;
    }

    private boolean canMakeBoquets( int [] bloomDays, int m, int k, int bloomDay){
        int flowerIdx = 0;
        int currBoquets = 0;
        int len = bloomDays.length;

        while ( flowerIdx < len){
            int idx = flowerIdx;
            while ( idx < len && bloomDays[idx] <= bloomDay){
                if ( idx - flowerIdx + 1 == k ){
                    currBoquets += 1;
                    break;
                }
                idx++;
            }
            if ( idx == len){
                currBoquets += (flowerIdx - idx ) == k ? 1 : 0;
            }
            flowerIdx = idx+1;
            if ( currBoquets ==  m ) break;
        }
        return currBoquets == m ;
    }
}
