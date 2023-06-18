package BinarySearch.BinarySearch2D;

public class PeakIn2dMatrix {
    // brute force approach
    // do a linear search on the array, and check which element satisfies the condition
    // Time complexity : O(n*m)
    // Space complexity : O(1)
    public int[] findPeakGrid1(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for ( int i = 0; i < rows; i++ ){
            for ( int j = 0; j < cols; j++ ){
                if( isPeak(mat, i, j)) return new int [] { i, j};
            }
        }
        return new int [] {-1,-1};
    }

    private boolean isPeak(int [][] matrix, int row, int col ){
        int rows = matrix.length;
        int cols = matrix[0].length;
        return (row == 0 || matrix[row][col] > matrix[row-1][col]) &&
            (row == rows-1 || matrix[row][col] > matrix[row+1][col]) &&
            (col == cols-1 || matrix[row][col] > matrix[row][col+1]) &&
            (col == 0 || matrix[row][col] > matrix[row][col-1]);
    }

    // Approach : use binary search for rows
    // and for each row check the max element
    // Time complexity : O(nlogm)
    // space complexity : O(1)
    public int[] findPeakGrid(int[][] matrix){
        int rows = matrix.length;
        int low = 0, high = rows -1;
        while ( low <= high ){
            int mid = ( low + high ) >> 1;
            int maxIdx = findMax(matrix[mid]);
            if ( checkPeak(matrix, mid, maxIdx)) return new int [] { mid, maxIdx};
            if (mid < rows-1 &&  matrix[mid][maxIdx] > matrix[mid + 1][maxIdx])
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return new int []{-1, -1};
    }

    
    private int findMax( int [] arr){
        int len = arr.length;
        int max = arr[0], maxIdx = 0;
        for ( int i = 1; i < len; i++ ){
            if ( arr[i] > max ){
                max = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private boolean checkPeak(int matrix[][], int row, int col){
        int rows = matrix.length;
        return (row == 0 || matrix[row][col] > matrix[row-1][col]) && ( row == rows-1 || matrix[row][col] > matrix[row+1][col]);
    }
}
