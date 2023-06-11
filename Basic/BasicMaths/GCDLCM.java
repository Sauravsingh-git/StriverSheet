package Basic.BasicMaths;

public class GCDLCM {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long [] result = new Long[2];
        result[1] = findGCD(A, B);
        result[0] = findLCM(A, B, result[1]);
        return result;
    }
    static public Long findGCD(Long x, Long y ){
        if ( y == 0 ) return x;
        if ( y > x ) return findGCD(y, x);
        return findGCD(y, x%y);
    }
    static public Long findLCM( Long x, Long y , Long gcd){
        return (x * y) / gcd;
    }
    // slower approach
    // not optimized
    static public Long findLCM( Long x ,Long y){
        Long small = Math.min(x,y);
        Long LCM = Math.max(x,y);
        Long bigger = Math.max(x,y);
        while ( LCM%small != 0 ){
            LCM += bigger;
        }
        return LCM;
    }
}
