package Heaps.Medium;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class MergeSortedKArrays {
// approach : upload every element in priorityQueue
    // then remove ele from priorityQueue and add them to  list one by one
    // time complexity : O (k^2log(k^2))
    // space complexity : O(k^2)
    public static ArrayList<Integer> mergeKArraysBF(int[][] arr,int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for ( int [] currArr : arr){
            for ( int x : currArr)
                pq.offer(x);
        }
        
        while (!pq.isEmpty() ){
            list.add(pq.poll());
        }
        return list;
        
    }
    
    // using priorityQueue which has maximum of k elements at a time
    // time complexity : O (K^2logk)
    // space complexity : O(k^2)
    public static ArrayList<Integer> mergeKArrays( int [][] arr, int k ){
        PriorityQueue <Node> pq = new PriorityQueue<>((x, y) -> x.value - y.value );
        for ( int i = 0; i < k; i++ ){
            pq.offer(new Node( arr[i][0], i, 0));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while ( !pq.isEmpty() ){
            Node currNode = pq.poll();
            list.add(currNode.value);
            if ( currNode.colIdx == k -1 ) continue;
            int nextEle = arr[currNode.rowIdx][currNode.colIdx + 1];
            pq.offer( new Node( nextEle, currNode.rowIdx, currNode.colIdx + 1));
        }
        
        return list;
    }
}

class Node{
    int value;
    int rowIdx;
    int colIdx;
    
    public Node( int value, int rowIdx, int colIdx){
        this.value = value;
        this.rowIdx = rowIdx;
        this.colIdx = colIdx;
    }
}