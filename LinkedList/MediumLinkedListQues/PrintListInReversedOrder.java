package MediumLinkedListQues;

public class PrintListInReversedOrder {
    // Que.) Print List in the reversed order without actually reversing the list
    public static void main(String [] args){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        printInReversedOrder(ll.head);
    }
    public static void printInReversedOrder(ListNode head){
        if ( head == null  ) return;
        printInReversedOrder(head.next);
        System.out.print(head.val + " ");
    }
}
