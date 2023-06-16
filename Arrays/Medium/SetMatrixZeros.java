package Arrays.Medium;

public class SetMatrixZeros {
    public void setZeroes( int [][] matrix){
        // constant space complexity
        // use the first row and col to store whether there is zero in the curr row and col respectively
        // for first col we use a boolean check and use matrix[0][0] for row ( if zero is present in the row)
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zeroInFirstCol = false;
        for ( int i = 0; i < m; i++ ){
            if(matrix[i][0] == 0 ) 
                zeroInFirstCol = true;

            for ( int j = 1; j < n; j++ ){
                if( matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // updating the values
    
        for ( int i = 1; i < m; i++ ){
            for ( int j = 1; j < n; j++ ){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // check if first cell matrix[0][0] is zero
        if ( matrix[0][0] == 0 )
            for ( int i = 0; i < n; i++ )
                matrix[0][i] = 0;
        // check if zeroInFirstCol is true
        if ( zeroInFirstCol )
            for ( int i = 0; i < m; i++ )
                matrix[i][0] = 0;
    }

    // time complexity : O(m*n)
    // space complexity : O(m+n)
    public void setZeroes1(int[][] matrix) {
        // m + n space complexity
        int m = matrix.length;
        int n = matrix[0].length;
        boolean [] rows = new boolean [m];
        boolean [] cols = new boolean [n];
        for ( int i = 0; i < m; i++ ){
            for ( int j = 0; j < n; j++ ){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for ( int i = 0; i < m; i++ ){
            if(rows[i]) fillRowWithZeros(matrix, i, n);
        }

        for ( int i = 0; i < n; i++ ){
            if(cols[i]) fillColWithZeros(matrix, i, m);
        }
    }

    public void fillRowWithZeros( int [][] matrix, int row, int colLen ){
        for ( int i = 0; i < colLen; i++ ){
            matrix[row][i] = 0;
        }
    }

    public void fillColWithZeros( int [][] matrix, int col, int rowLen){
        for ( int i = 0; i < rowLen; i++ ){
            matrix[i][col] = 0;
        }
    }
}
