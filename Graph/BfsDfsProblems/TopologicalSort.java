package Graph.BfsDfsProblems;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    // In a topological sorted arrray, if a vertex ( u, v ) belongs to the graph
    // then u will always be before v in the array
    // approach : using dfs
    // apply a normal dfs and insert the node into stack after processing
    // empty the stack into a list
    // the list will be topologically sorted
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        boolean [] visited = new boolean [V];
        Stack <Integer> stack = new Stack<>();
        // calling dfs on every vertex because graph can be disconnected
        for ( int i = 0; i < V; i++ ){
            if ( visited[i] ) continue;
            dfs(i, adj, visited, stack);
        }
        
        int [] topologicalSorted = new int [V];
        for ( int i = 0; i < V; i++ ){
            topologicalSorted[i] = stack.pop();
        }
        return topologicalSorted;
    }
    
    void dfs( int currNode, ArrayList<ArrayList<Integer>> adjList, boolean [] visited, Stack<Integer> stack ){
        visited[currNode] = true;
        
        for( int node : adjList.get(currNode)){
            if ( visited[node] ) continue;
            dfs(node, adjList, visited, stack);
        }
        // after processing add the node to the  stack
        stack.push(currNode);
    }
}
