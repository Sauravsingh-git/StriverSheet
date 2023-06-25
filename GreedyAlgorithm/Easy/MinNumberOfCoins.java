package GreedyAlgorithm.Easy;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfCoins {
    static List<Integer> minPartition(int N)
    {
        // this is a greedy problem
        List<Integer> coins = new ArrayList<>();
        int [] currency = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int idx = currency.length-1;
        while ( idx >= 0 && N > 0 ){
            if ( currency[idx] > N){
                idx--;
                continue;
            }
            N -= currency[idx];
            coins.add(currency[idx]);
        }
        return coins;
    }
}
