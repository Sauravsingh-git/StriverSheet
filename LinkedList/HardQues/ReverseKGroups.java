package HardQues;

public class ReverseKGroups {
    // Iterative Approach
    // time complexity : O(n)
    // space complexity : O(n)
    public ListNode reverseKGroup(ListNode head, int k ){
        if ( head.next == null ) return head;
        ListNode curr = head, prev, next;
        ListNode resHead = new ListNode(342);
        prev = resHead;
        while ( curr != null ){
            ListNode tempHead = curr;
            int temp = k;
            while ( tempHead != null && --temp > 0 )
                tempHead = tempHead.next;
            // If the list contains less than k elements
            if ( tempHead == null ){
                prev.next = curr;
                break;
            }
            next = tempHead.next;
            // breaking the link
            tempHead.next = null;
            // reversing the list
            prev.next = reverse(curr);
            // updating the prev and currrPointer
            prev = curr;
            curr = next;
        }
        return resHead.next;
    }

    public ListNode reverse(ListNode head){
        if( head == null || head.next == null ) return head;
        ListNode prev = null, curr = head, next = head;
        while ( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //--------------------------------------------------------------------------------------------

    // Solution with recursion
    public ListNode reverseKGroup1(ListNode head, int k) {
        // recursive approach
        // time complexity : O(n)
        // space complexity : O(1)
        if(head == null || head.next == null ) return head;
        int temp = k;
        ListNode curr = head;
        while ( --temp > 0  && curr != null ){
            curr = curr.next;
        }
        if( curr == null ) return head;
        ListNode rest = reverseKGroup1(curr.next, k);
        ListNode prev = rest, next = null;
        curr = head;
        while ( k-- > 0 ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
