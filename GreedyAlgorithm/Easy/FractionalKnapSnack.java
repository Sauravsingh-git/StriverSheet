package GreedyAlgorithm;

import java.util.Arrays;

public class FractionalKnapSnack {
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        
        Arrays.sort(arr, (x, y)->{
            double valuePerUnit1 = (double)x.value/x.weight;
            double valuePerUnit2 = (double)y.value/y.weight;
            return valuePerUnit1 - valuePerUnit2 > 0? 1 : -1;
        });
        
        double maxValue = 0;
        int idx = arr.length-1;
        while ( W > 0 && idx >= 0 ){
            if ( W > arr[idx].weight){
                maxValue += arr[idx].value;
                W -= arr[idx].weight;
                idx--;
            }else{
                double valuePerUnitWeight = (double)arr[idx].value/arr[idx].weight;
                maxValue += valuePerUnitWeight * W;
                W= 0;
            }
        }
        return maxValue;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }

    public String toString(){
        return "value : " + value+ " weight :  " + weight +" ";
    }
}