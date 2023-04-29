package MediumDLL;

public class RemoveDuplicates {
    ListNode removeDuplicates(ListNode head){
        ListNode curr = head;
        while ( curr != null ){
            if( curr.next != null ){
                if(curr.val == curr.next.val){
                    curr.next = curr.next.next;
                    if(curr.next != null ){
                        curr.next.prev = curr;
                    }
                }else{
                    curr = curr.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}
