package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColorGraph {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int [] colors = new int [n];
        Arrays.fill(colors, -1);
        List<List<Integer>> adjList = new ArrayList<>();
        for ( int i = 0; i < graph.length; i++ ){
            adjList.add(new ArrayList<Integer>());
        }
        for ( int i = 0; i < graph.length; i++ ){
            for ( int j = 0; j < graph.length; j++ ){
                if ( graph[i][j] ){
                    adjList.get(i).add(j);
                }
            }
        }
        return graphColoringUtil(adjList, m, 0, colors);
    }
    
    private boolean graphColoringUtil(List<List<Integer>> adjList, int m, int currNode, int [] colors ){
        if ( currNode == adjList.size() ) return true;
        
        for ( int i = 0; i < m; i++ ){
            if ( canColorAlloted(adjList, i, currNode, colors ) ){
                colors[currNode] = i;
                if ( graphColoringUtil(adjList, m, currNode +1, colors)) return true;
                colors[currNode] = -1;
            }
        }
        
        return false;
    }
    
    private boolean canColorAlloted(List<List<Integer>> adjList, int color, int currNode, int [] colors ){
        for ( int node : adjList.get(currNode)){
            if ( colors[node] == color ) return false;
        }
        return true;
    }
}
