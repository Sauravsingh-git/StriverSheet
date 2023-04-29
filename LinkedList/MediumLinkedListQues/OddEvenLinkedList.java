package MediumLinkedListQues;

public class OddEvenLinkedList {
    public static void main(String [] args){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        OddEvenLinkedList obj = new OddEvenLinkedList();
        ListNode oddEvenList = obj.oddEvenList(ll.head);
        ll.printList(oddEvenList);
    }
    public ListNode oddEvenList(ListNode head ){
        if( head == null || head.next == null ) return head;
        // O(n) Time complexity and constant space complexity
        ListNode currOdd = head, currEven = head.next, evenHead = currEven;
        while(currEven != null && currEven.next != null ){
            currOdd.next = currOdd.next.next;
            currEven.next = currEven.next.next;

            currOdd = currOdd.next;
            currEven = currEven.next;
        }
        currOdd.next = evenHead;
        return head;

    }
}
