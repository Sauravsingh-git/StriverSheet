package MediumDLL;

public class DLL {
    ListNode head = null;
    ListNode tail = null;

    public void insertAtEnd(int val ){
        ListNode temp = new ListNode(val);
        if( head == null ){
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }
}
class ListNode{
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        prev = null;
        next = null;
    }
}
