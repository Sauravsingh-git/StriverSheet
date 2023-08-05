package Recursion.Hard;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        char [] wordArr = word.toCharArray();
        for ( int i = 0; i < rows; i++ ){
            for ( int j = 0; j < cols; j++ ){
                if ( existUtil(board, new boolean[rows][cols], i, j, wordArr, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean existUtil(char [][] board, boolean [][] visited, int row, int col, char [] word, int idx ){
        if ( idx == word.length ){
            return true;
        }

        if ( !isValidIdx(row, col, board.length, board[0].length)) return false;
        if ( visited[row][col]) return false;
        if ( board[row][col] != word[idx]) return false;
        visited[row][col] = true;
        boolean result = existUtil(board, visited, row+1, col, word, idx+1) ||
                        existUtil(board, visited, row, col+1, word, idx+1)||
                        existUtil(board, visited, row-1, col, word, idx+1)||
                        existUtil(board, visited, row, col-1, word, idx+1);
        visited[row][col] = false;
        return result;
    }

    private boolean isValidIdx( int row, int col, int rows, int cols ){
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
}
