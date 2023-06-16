package Arrays.Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeIntervals {
     public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        int len = intervals.length;
        int idx = 0; 
        int currLb = intervals[0][0], currUb = intervals[0][1];
        List<int []> mergedIntervals = new ArrayList<>();
        while ( idx < len){
            if(mergableIntervals(new int []{currLb, currUb}, intervals[idx])){
                currUb = Math.max(currUb, intervals[idx][1]);
            }else{
                mergedIntervals.add(new int [] { currLb, currUb});
                currLb = intervals[idx][0];
                currUb = intervals[idx][1];
            }
            idx++;
        }
        mergedIntervals.add(new int [] { currLb, currUb});
        int size = mergedIntervals.size();
        int [][] result = new int [size][];
        for ( int i = 0; i < size; i++ ){
            result[i] = mergedIntervals.get(i);
        }
        return result;
    }

    public boolean mergableIntervals(int [] interval1, int [] interval2){      
        return (interval1[1] >= interval2[0] );
    }
}
