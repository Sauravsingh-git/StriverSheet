package Heaps.Medium;

import java.util.PriorityQueue;

public class ReplaceEleByTheirRank {
    int[] replaceWithRank(int arr[], int N) {
    int [] result = new int [N];
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y)-> x.val - y.val);
    for( int i = 0; i < N; i++ ){
        pq.offer(new Node(arr[i], i));
    }
    int pos = 0, prevEle = -1;
    while ( !pq.isEmpty() ){
        Node currNode = pq.poll();
        if ( currNode.val > prevEle) pos++;
        result[currNode.idx] = pos;
        prevEle = currNode.val;
        
    }
    return result;
  }
}

class Node{
    int val;
    int idx;
    public Node( int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
