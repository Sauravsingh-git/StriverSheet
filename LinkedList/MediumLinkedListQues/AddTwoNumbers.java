package MediumLinkedListQues;

public class AddTwoNumbers {
    boolean carry = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // version 1: When the numbers are stored in reversed order
        boolean carry = false;
        ListNode result = new ListNode(0);
        ListNode additionResult = result;
        while(  l1 != null && l2 != null ){
            int temp = l1.val + l2.val;
            if ( carry ) temp++;
            result.next = new ListNode(temp%10);
            if( temp > 9 ) carry = true;
            else carry = false;
            
            // updating the pointers 
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while ( l1 != null ){
            int temp = l1.val;
            if ( carry ) temp++;
            result.next = new ListNode(temp%10);
            if ( temp > 9 ) carry = true;
            else carry = false;

            result = result.next;
            l1 = l1.next;
        }

        while ( l2 != null ){
            int temp = l2.val;
            if ( carry ) temp++;
            result.next = new ListNode(temp%10);
            if ( temp > 9 ) carry = true;
            else carry = false;

            result = result.next;
            l2 = l2.next;
        }

        if( carry ) 
        result.next = new ListNode(1);
        return additionResult.next;
    }
}
