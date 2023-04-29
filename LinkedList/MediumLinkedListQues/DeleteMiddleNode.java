package MediumLinkedListQues;

public class DeleteMiddleNode {
    //Que) A modified version of deleting the middle node
    // You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
    // The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
    // For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
    public static void main(String [] args){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.printList(ll.head);
        DeleteMiddleNode obj = new DeleteMiddleNode();
        ll.head = obj.deleteMiddle(ll.head);
        ll.printList(ll.head);
    }
    public ListNode deleteMiddle(ListNode head) {
        if ( head.next == null ) return null;
        ListNode fastPtr = head.next.next, slowPtr = head;
        while( fastPtr != null && fastPtr.next != null ){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;
        return head;
    }
}
