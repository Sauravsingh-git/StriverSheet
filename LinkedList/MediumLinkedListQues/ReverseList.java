package MediumLinkedListQues;

public class ReverseList {
    public static void main(String [] args){
        ReverseList obj = new ReverseList();
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ListNode temp = obj.reverseListItr(ll.head);
        ll.printList(temp);
        temp = obj.reverseListRec(temp);
        ll.printList(temp);
    }
    public ListNode reverseListItr(ListNode head) {
        // iterative method
        ListNode prev = null, curr = head, next = head;
        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRec( ListNode head){
        // recursive method
        return reverse(head, null, head);
    }
    public ListNode reverse( ListNode curr, ListNode prev, ListNode next){
        if(curr == null ) return prev;
        next = curr.next;
        curr.next = prev;
        return reverse(next, curr, next);
    }


}
