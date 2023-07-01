package Heaps.Medium;

import java.util.PriorityQueue;

public class MergingKSotedLists {
    ListNode mergeKList(ListNode[]arr,int K)
    {
        ListNode resultHead = new ListNode(342);
        ListNode currListNode = resultHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y)->x.data - y.data);
        for ( ListNode ListNode : arr){
            if( ListNode != null )
                queue.offer(ListNode);
        }
        while ( !queue.isEmpty() ){
            ListNode temp = queue.poll();
            if ( temp.next != null ) 
                queue.offer(temp.next);
            currListNode.next = temp;
            currListNode = currListNode.next;
            
        }
        return resultHead.next;
    }

}


class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
        next = null;
    }
}