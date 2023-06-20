package BinarySearch.FindingAnswersByBs;

public class SquareRoot {
    public static void main(String [] args){
        floorSqrt(5);
    }
    static long floorSqrt(long x)
	 {
		long low = 0;
		long high = x;
		while ( low < high ){
		    long mid = ( low + high )>>1;

		    if ( mid*mid <= x ){
                low = mid +1;
            System.out.println("low value :" + low);
            }
		    else {
		        high = mid-1;
                System.out.println("high value " + high);
		    }
        }
		return low;
	 }
}
