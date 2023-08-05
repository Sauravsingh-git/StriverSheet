package Recursion.Hard;
import java.util.List;
import java.util.ArrayList;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        boolean [] rowArray = new boolean[n];
        boolean [] upperDiagonalArray = new boolean [2*n - 1];
        boolean [] lowerDiagonalArray = new boolean [2*n - 1];
        char [][] grid = new char [n][n];
        for ( char [] charArray : grid ){
            for ( int i = 0; i < n; i++ ){
                charArray[i] = '.';
            }
        }

        List<List<String>> resultSet = new ArrayList<>();
        solveNQueens(grid, n, 0, resultSet, rowArray, upperDiagonalArray, lowerDiagonalArray);
        return resultSet;
    }

    public void solveNQueens(char [][] grid, int n, int col, List<List<String>> resultSet, boolean [] rowArray, boolean [] upperDiagonalArray, boolean [] lowerDiagonalArray ){
        if ( n == col ){
            addToResultSet(grid, resultSet);
            return;
        }
        for ( int i = 0; i < n; i++ ){
            if ( isValidPosition(grid, n, i, col, rowArray, upperDiagonalArray, lowerDiagonalArray ) ){
                grid[i][col] = 'Q';
                rowArray[i] = true;
                upperDiagonalArray[n - i + col - 1] = true;
                lowerDiagonalArray[i + col] = true;
                solveNQueens(grid, n, col+1, resultSet, rowArray, upperDiagonalArray, lowerDiagonalArray);
                grid[i][col] = '.';
                rowArray[i] = false;
                upperDiagonalArray[n - i + col - 1] = false;
                lowerDiagonalArray[i + col] = false;
            }
        }
    }

    private boolean isValidPosition(char [][] grid, int n, int rPos, int cPos, boolean [] row, boolean [] upperDiagonal, boolean [] lowerDiagonal ){
        if ( row[rPos] || lowerDiagonal[cPos + rPos] || upperDiagonal[n - rPos + cPos - 1] ) return false;
        return true;
    }

    private void addToResultSet(char [][] grid, List<List<String>> resultSet){
        List<String> currBoard = new ArrayList<>();
        for (char [] charArray : grid ){
            String currRow = new String(charArray);
            currBoard.add(currRow);
        }
        resultSet.add(currBoard);
    }
}
