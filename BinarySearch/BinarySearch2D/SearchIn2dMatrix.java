package BinarySearch.BinarySearch2D;

import java.util.ArrayList;
import java.util.List;

public class SearchIn2dMatrix {
    // brute force approach
    // time complexity : o(n*m)
    // space complexity : O(n*m)
    public boolean searchMatrix1(int[][] matrix, int target) {
        List <Integer> array = new ArrayList<>();
        for ( int [] row : matrix ){
            for ( int ele : row )
                array.add(ele);
        }
        return binarySearch ( array, 0, array.size()-1, target);
    }

    public boolean binarySearch ( List<Integer> list, int low, int high, int target){
        if ( low > high ) return false;
        int mid = ( low + high ) >> 1;
        if ( list.get(mid) == target ) return true;
        if ( list.get(mid) > target ) return binarySearch ( list, low, mid-1, target);
        else return binarySearch( list, mid+1, high, target);
    }

    // optimized approach
    // time complexity  : O(log(m*n))
    // space complexity : O(1)

    public boolean searchMatrix ( int [][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        return binarySearchIn2dMatrix(matrix, 0, row*col-1, target);
    }

    private boolean binarySearchIn2dMatrix(int [][] matrix, int low, int high, int target){
        if ( high < low ) return false;
        int mid = (low + high)>>1;
        int [] rowAndCol = findRowAndCol(matrix, mid);
        if ( matrix[rowAndCol[0]][rowAndCol[1]] == target )
             return true;
        if ( matrix[rowAndCol[0]][rowAndCol[1]] > target )
            return binarySearchIn2dMatrix(matrix, low, mid-1, target);
        else
            return binarySearchIn2dMatrix(matrix, mid+1, high, target);
    }

    private int [] findRowAndCol( int[][] matrix, int pos){
        int col = matrix[0].length;
        return new int [] {pos/col, pos%col};
    }
}
