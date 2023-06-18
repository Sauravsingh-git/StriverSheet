package BinarySearch.BinarySearch2D;

public class SearchInRowAndColwiseSortedMatrix {
    // brute force approach - Linear Search
    // time compelxity : O(m*n)
    // space complexity : O(1)
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for ( int i = 0; i < row; i++ ){
            for (int j = 0; j < col; j++ ){
                if ( matrix[i][j] == target ) return true;
            }
        }

        return false;
    }

    // appraoch 2 - binarySearch in individual rows
    // time complexity : O(nlogm)
    // space complexity : O(1)
    public boolean searchMatrix2( int [][] matrix, int target ){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean result = false;
        for ( int i = 0; i < rows; i++ ){
            result = result || binarySearch2(matrix[i], target, 0, cols-1);
            if ( result ) return result;
        }
        return result;
    }

    public boolean binarySearch2( int [] row, int target, int low, int high ){
        if ( high < low ) return false;
        int mid = ( high + low )>>1;
        if ( row[mid] == target ) return true;
        if ( row[mid] > target ) return binarySearch2( row, target, low, mid-1);
        else return binarySearch2(row, target, mid+1, high);
    }

    // most optimized solution
    // time complexity : O(log(m*n))
    // space complexity : O(1)
    // the search space is getting reduced by 1/4 is every search
    public boolean searchMatrix( int [][] matrix, int target ){
        int row = matrix.length;
        int col = matrix[0].length;
        return binarySearchIn2dMatrix(matrix, 0, 0, row-1, col-1, target);
    }

    public boolean binarySearchIn2dMatrix( int [][] matrix, int lbRow, int lbCol, int ubRow, int ubCol, int target){
        if ( ubRow < lbRow || ubCol < lbCol ) return false;
        int row = ubRow - lbRow + 1;
        int col = ubCol - lbCol + 1;
        int totalEle = row * col;
        int middleEle = totalEle/2;
        int midRow = lbRow + middleEle/col;
        int midCol = lbCol + middleEle%col;

        if ( matrix[midRow][midCol] == target ) return true;
        if ( matrix[midRow][midCol] > target ) return binarySearchIn2dMatrix( matrix, lbRow, lbCol, midRow-1, ubCol, target)
                || binarySearchIn2dMatrix(matrix, midRow, lbCol, ubRow, midCol-1, target);
        else return binarySearchIn2dMatrix(matrix, lbRow , midCol+1, midRow, ubCol, target) 
                || binarySearchIn2dMatrix(matrix, midRow+1, lbCol, ubRow, ubCol, target);
    }
}
