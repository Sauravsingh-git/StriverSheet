package BinarySearch.FindingAnswersByBs;

public class NthRoot {

   public int NthRootFinder(int n, int m)
    {
        if ( n == 1) return m;
        int low = 1;
        int high = (int)Math.sqrt(m);
        while ( low <= high){
            int mid = ( low + high ) >> 1;
            if ( Math.pow(mid, n) == m ){
                return mid;
            }else if ( Math.pow(mid, n) < m ){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    
}
