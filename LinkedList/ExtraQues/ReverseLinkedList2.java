package ExtraQues;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head, prev = null;
        
        while ( left-- > 1 ){
            prev = curr;
            curr = curr.next;
            right--;
        }
        ListNode prev1 = null, next1 = null, curr1 = curr;
        while ( right-- > 0){
            next1 = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = next1;
        }

        curr.next = curr1;
        if ( prev == null ){
            // case when left = 1
            head = prev1;
        }else{
            // case when left > 1
            prev.next = prev1;
        }
        return head;
    }
}
