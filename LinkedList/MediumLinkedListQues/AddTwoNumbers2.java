package MediumLinkedListQues;

public class AddTwoNumbers2 {
    boolean carry = false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Approach 1 : Reverse Both the Lists and use the method used in Add Two Numbers I
        // Then reverse the resultant list and return it

        // Follow Up questions: Can you do it without revering the input lists
        ListNode currL1 = l1, currL2 = l2;
        while( currL1 != null && currL2 != null ){
            currL1 = currL1.next;
            currL2 = currL2.next;
        }
        int counter = 0;
        // check which list has more nodes
        boolean isL1Bigger = currL2 == null;
        while( currL1 != null ){
            counter++;
            currL1 = currL1.next;
        } 
        while( currL2 != null ){
            counter++;
            currL2 = currL2.next;
        }
        
        ListNode currResNode = new ListNode(1), resHead;
        resHead = currResNode;
        currL1 = l1;
        currL2 = l2;
        if(isL1Bigger){
            while(counter-- > 0 ){
                currResNode.next = new ListNode(currL1.val);
                currL1 = currL1.next;
                currResNode = currResNode.next;
            }
        }else{
            while(counter-- > 0 ){
                currResNode.next = new ListNode(currL2.val);
                currL2 = currL2.next;
                currResNode = currResNode.next;
            }
        }
        while( currL1 != null ){
            int temp = currL1.val + currL2.val;
            currResNode.next = new ListNode(temp);
            currL1 = currL1.next;
            currL2 = currL2.next;
            currResNode = currResNode.next;
        }
        shiftCarry(resHead.next);
        return carry? resHead : resHead.next;
    }

    public void shiftCarry(ListNode head){
        if( head == null ) return;
        shiftCarry(head.next);
        int temp = head.val;
        if ( carry ) temp++;
        head.val = temp%10;
        if ( temp > 9 )
            carry = true;
        else 
            carry = false;

    }
}
