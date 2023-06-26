package Graph.Traversals;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited =new boolean [V];
        queue.offer(0);
        visited[0] = true;
        while ( !queue.isEmpty() ){
            int currNode = queue.poll();
            bfsTraversal.add(currNode);
            
            if ( adjList.get(currNode).size() == 0)
                continue;
            for ( int node : adjList.get(currNode)){
                if ( visited[node] ) continue;
                queue.add(node);
                visited[node] = true;
            }
        }
        return bfsTraversal;
    }
}
