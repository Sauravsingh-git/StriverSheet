package MediumDLL;

public class DeletionOfAllOccur {
    ListNode deleteAllOccurOfX(ListNode head, int x) {
        if ( head == null ) return head;
        // removing the nodes from starting
        while(  head!= null && head.val == x ){
            head = head.next;
        }
        if( head != null )
            head.prev = null;
        ListNode curr = head;
        while ( curr != null ){
            if(curr.val == x){
                ListNode prev = curr.prev;
                if(curr.next != null )
                    curr.next.prev = prev;
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
