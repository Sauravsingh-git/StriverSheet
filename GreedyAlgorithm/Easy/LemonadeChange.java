package GreedyAlgorithm.Easy;

public class LemonadeChange {
    // time complexity : O(N)
    // space complexity : O(1)
    public boolean lemonadeChange(int[] bills) {
        int [] map = new int [4];
        for( int transaction : bills  ){
            map[transaction/5-1]++;
            if ( transaction == 10 ){
                if ( map[0] == 0 ) return false;
                map[0]--;
            }else if ( transaction == 20){
                if ( map[1] > 0){
                    map[1]--;
                    if ( map[0] == 0) return false;
                    map[0]--;
                }else{
                    if( map[0] < 3 ) return false;
                    map[0] -= 3;
                }
            }
        }
        return true;
    }
}
