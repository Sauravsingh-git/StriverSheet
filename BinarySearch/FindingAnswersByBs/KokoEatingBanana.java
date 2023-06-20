package BinarySearch.FindingAnswersByBs;

public class KokoEatingBanana {
    public int minEatingSpeedBF(int[] piles, int h) {
        // brute force approach 
        // find the maximum bananas on the pile
        int max = piles[0];
        for ( int ele : piles )
            max = Math.max(max, ele);
        
        int bananaEatingSpeed = max;
        while ( canKokoEatBananas(piles, bananaEatingSpeed--, h));
        return bananaEatingSpeed+2;
    }

    
    // using binary search to guess the right eating speed
    public int minEatingSpeed( int [] piles, int h ){
        int low = 1;
        int high = 1000000000;
        int minEatingSpeed = high;
        while ( low <= high ){
            int mid = ( low + high ) >> 1;
            if ( canKokoEatBananas(piles, mid, h)){
                minEatingSpeed = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return minEatingSpeed;
    }

    public boolean canKokoEatBananas( int [] piles, int eatingSpeed, int hours ){
        int len = piles.length;
        long currHours = 0;
        for ( int i = 0; i < len; i++ ){
            int totalBananas = piles[i];
            currHours += totalBananas/eatingSpeed;
            if ( totalBananas%eatingSpeed != 0 ) currHours++; 
        }
        return currHours <= (long)hours;
    }
}
