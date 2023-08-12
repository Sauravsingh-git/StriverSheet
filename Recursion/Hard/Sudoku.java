package Recursion.Hard;

public class Sudoku {
    public void solveSudoku(char[][] board) {
        solver(board);
    }
    
    public boolean solver(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char c='1'; c<='9'; c++){
                        if(isValid(i, j, c, board)){
                            board[i][j] = c;
                            if(solver(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }  
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, char c, char [][] board){
        for(int i=0; i<9; i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}
