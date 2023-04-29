package HardQues;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null || head.next == null) return head;
        int len = 0;
        ListNode curr = head;
        while( curr != null ){
            curr = curr.next;
            len++;
        }
        int pivot = k % len;
        if(pivot == 0 ) return head;
        pivot = len - pivot;
        curr = head;
        while( --pivot > 0 ){
            curr = curr.next;
        }
        ListNode next = curr.next;
        ListNode tail = curr;
        while ( curr.next != null )
            curr = curr.next;
        curr.next = head;
        tail.next = null;
        return next;
    }
}
