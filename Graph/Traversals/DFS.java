package Graph.Traversals;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean [] visited = new boolean[V];
        ArrayList<Integer> dfsTraversal = new ArrayList<>();
        // we are doing this to handle disconected graphs
        for ( int i = 0; i < V; i++ ){
            dfsUtil(0, adjList, dfsTraversal, visited);
        }
        return dfsTraversal;
    }
    
    public void dfsUtil( int currNode, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfsTraversal, boolean [] visited){
        if( visited[currNode]) return;
        visited[currNode] = true;
        dfsTraversal.add(currNode);
        
        if ( adjList.get(currNode).size() == 0 ) return;
        for ( int node : adjList.get(currNode)){
            if(visited[node]) continue;
            dfsUtil(node, adjList, dfsTraversal, visited);
        }
    }
}
