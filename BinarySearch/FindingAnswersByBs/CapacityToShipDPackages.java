package BinarySearch.FindingAnswersByBs;

public class CapacityToShipDPackages {
    public int shipWithinDays(int[] weights, int days) {
        int  max = 0;
        int sum = 0;
        for(int ele : weights) {
            max = Math.max(max, ele);
            sum += ele;
            }
        int low, mid, high;
        low = max;
        high = sum;
        while(low < high){
            mid = low + (high - low)/2;
            if(!capacity(weights, mid, days)) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public boolean capacity(int [] weights, int maxWeight, int days){
        int currWeight = 0;
        int currDays = 1;
        for(int i=0; i<weights.length; i++){
            if(currWeight + weights[i] <= maxWeight){
                currWeight = currWeight + weights[i];
            }else{
                currDays++;
                currWeight = weights[i];
            }
            if(currDays > days) return false;
        }
        return true;
    }
}
