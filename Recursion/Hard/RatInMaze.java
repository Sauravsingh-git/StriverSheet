package Recursion.Hard;

import java.util.ArrayList;

public class RatInMaze {
    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> resultSet = new ArrayList<>();
        boolean [][] visited = new boolean[n][n];
        if ( maze[0][0] == 1)
            findPathUtil( maze, n, 0, 0, visited, "", resultSet);
        return resultSet;
    }
    
    private static void findPathUtil(int [][] maze, int n, int currRow, int currCol, boolean [][] visited, String currPath, ArrayList<String> resultSet ){
        if ( currRow == n-1 && currCol == n-1 ){
            resultSet.add(currPath);
            return;
        }
        visited[currRow][currCol] = true;
        // downwards
        if ( isValid(maze, currRow + 1, currCol, n, visited)){
            findPathUtil(maze, n, currRow +1, currCol, visited, currPath + "D", resultSet);
        }
        
        // left
        if ( isValid(maze, currRow, currCol -1, n, visited)){
            findPathUtil(maze, n, currRow, currCol -1, visited, currPath + "L", resultSet);
        } 
       
        // right
        if ( isValid(maze, currRow, currCol + 1, n, visited)){
            findPathUtil(maze, n, currRow, currCol + 1, visited, currPath + "R", resultSet);
        }
        
         // upwards
        if ( isValid(maze, currRow -1, currCol, n, visited)){
            findPathUtil(maze, n, currRow -1, currCol, visited, currPath + "U", resultSet);
        }
        
        
        visited[currRow][currCol] = false;
    }
    
    private static boolean isValid ( int [][] maze, int row, int col, int n, boolean [][] visited ){
        if ( row < 0 || row >= n || col < 0 || col >= n  || maze[row][col] == 0 || visited[row][col]) return false;
        return true;
    }
}
