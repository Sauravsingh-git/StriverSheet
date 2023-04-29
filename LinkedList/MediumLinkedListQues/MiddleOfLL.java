package MediumLinkedListQues;

public class MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while( fast!= null && fast.next!= null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String [] args){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        MiddleOfLL obj = new MiddleOfLL();
        ListNode middle = obj.middleNode(ll.head);
        System.out.println(middle.val);
    }
}
