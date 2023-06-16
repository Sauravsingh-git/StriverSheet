package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    // we have 3 variations for it 
    // variation1 : for given numRow return all levels from 1 to numRow
    // variation2 : for given numRow only print the currRow
    // variation3 : for a row and col print the element

    // variation1 
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>(Arrays.asList(1)));
        for ( int i = 1; i < numRows; i++ ){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for ( int j = 1; j < i; j++ ){
                int val = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                temp.add(val);
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }

    // variation 2 : for particular row
    // brute force  : 
    // generate all rows using variation1 and then return the required row


    // variation2 : better approach
    // we don't need only previous row to find the next row, so only keep that row
    // n -> rowIdx
    // time complexity : O ( n^2 )
    // space complexity : O( n )
    public List<Integer> getRow1(int rowIdx) {
        Integer [] prevLayer = new Integer [rowIdx+1];
        Integer [] currLayer;
        prevLayer[0] = 1;
        for ( int i = 1; i <= rowIdx; i++ ){
            currLayer = new Integer [rowIdx+1];
            currLayer[0] = 1;
            currLayer[i] = 1;
            for( int j = 1; j < i; j++ ){
                currLayer[j] = prevLayer[j] + prevLayer[j-1];
            }
            prevLayer = currLayer;
        }
        return Arrays.asList(prevLayer);
    }
    // variation2 : optimal approach
    // time complexity : O(number of elements in the requiredRow)
    // space complexity : O(1)
    // USE LONG DATATYPE TO CALCULATE THE COMBINATION
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for ( int r = 1; r <= rowIndex; r++ ){
            int prevEle = row.get(r-1);
            long currEle = (long)prevEle * (rowIndex + 1 - r);
            currEle /= r;
            row.add((int)currEle);
        }
        return row;
    }

    // variation 3
    // brute force : generate all the levels using variation one 
    
    // semi efficeint : generate only the curr level

    // optimized : calculate nCr
}
