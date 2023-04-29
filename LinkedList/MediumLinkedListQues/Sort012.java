package MediumLinkedListQues;

public class Sort012 {
    public static void main(String [] args){
        LinkedList ll = new LinkedList();
        ll.insert(2);
        ll.insert(2);
        ll.insert(2);
        ll.insert(2);
        Sort012 obj = new Sort012();
        ListNode temp = obj.sortList(ll.head);
        ll.printList(temp);
    }

    public ListNode sortList( ListNode head ){
        ListNode zeroHead = new ListNode(0), oneHead = new ListNode(1), twoHead = new ListNode(2);
        ListNode currZero = zeroHead, currOne = oneHead, currTwo = twoHead;
        ListNode curr = head; 
        while ( curr != null ){
            if ( curr.val == 0 ){
                currZero.next = curr;
                currZero = currZero.next;
            }else if ( curr.val == 1){
                currOne.next = curr;
                currOne = currOne.next;
            }else{
                currTwo.next = curr;
                currTwo = currTwo.next;
            }
            curr = curr.next;
        }
        currTwo.next = null;
        if( zeroHead.next != null){
            head = zeroHead.next;
            if(oneHead.next != null ){
                currZero.next = oneHead.next;
                currOne.next = twoHead.next;
            }else{
                currZero.next = twoHead.next;
            }
        }else{
            if(oneHead.next != null ){
                head = oneHead.next;
                currOne.next = twoHead.next;
            }else{
                head = twoHead.next;
            }
        }
        return head;
    }    
}

