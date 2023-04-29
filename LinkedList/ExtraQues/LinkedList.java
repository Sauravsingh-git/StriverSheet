package ExtraQues;

public class LinkedList {
    ListNode head = null;
    public void insert( int val ){
        ListNode temp = new ListNode(val);
        if ( head == null ){
            head = temp;
            return;
        }
        ListNode curr = head;
        while ( curr.next != null ){
            curr = curr.next;
        }
        curr.next = temp;
    }

    public void printList(ListNode head ){
        ListNode temp = head;
        while( temp != null ){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val ){
        this.val = val;
        next = null;
    }
}
