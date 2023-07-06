package Graph.BfsDfsProblems;

import java.util.ArrayList;

public class CycleDetection {
    // using dfs
    // Approach : If you find a node which has already been visited and its not equal to the parent node
    // i.e, the node which you just came from, then cycle is present
    // apply dfs recursively
    // also you need to run dfs on every vertex since graph can be disconnected and could contain cycle
    // time complexity : O(V)
    // space complexity : O()V
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean [V];
        for ( int i = 0; i < V; i++ ){
            if ( visited[i] ) continue;
            if ( dfs(adj, i, -1, visited) ) return true;
        }
        return false;
    }
    
    public boolean dfs( ArrayList<ArrayList<Integer>> adjList, int currNode, int parent, boolean [] visited){
        visited[currNode] = true;
        for ( int node : adjList.get(currNode)){
            if ( visited[node] ) {
                if ( node == parent )
                    continue;
                else 
                    return true;
            }
            if ( dfs( adjList, node, currNode, visited)) return true;
        }
        return false;
    }
}
