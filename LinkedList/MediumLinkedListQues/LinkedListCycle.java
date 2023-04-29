package MediumLinkedListQues;
// Que1) Detect Cycle in the LinkedList and return true and false accordingly
// Que2) Find the starting point of the cycle
// Que3) Find the length of the loop
public class LinkedListCycle {
    public static void main(String [] args){
        LinkedListCycle obj = new LinkedListCycle();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        if(obj.hasCycle(n1)){
            System.out.println("has cycle");
        }else{
            System.out.println("no cycle");
        }

        System.out.println("The length of the loop is : " + obj.findLoopLength(n1));

    }

    public boolean hasCycle(ListNode head) {
        // que 1
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        // que 2
        ListNode slowPtr, fastPtr;
        slowPtr = fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
                break;
        }

        if(fastPtr == null || fastPtr.next == null)
            return null;
        ListNode temp = head;
        while(temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public int findLoopLength(ListNode head){
        ListNode slowPtr, fastPtr;
        slowPtr = fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
                break;
        }
        if( fastPtr == null || fastPtr.next == null )
            return 0;
        slowPtr = slowPtr.next;
        int len = 1;
        while( fastPtr != slowPtr){
            slowPtr = slowPtr.next;
            len++;
        }
        return len;
    }

}
