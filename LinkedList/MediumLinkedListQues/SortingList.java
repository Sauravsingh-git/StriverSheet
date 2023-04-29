package MediumLinkedListQues;

public class SortingList {
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode mid = getMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right){
        ListNode resultCurr = new ListNode(1);
        ListNode resultHead = resultCurr;
        while(left!= null && right!= null ){
            if(left.val > right.val){
                resultCurr.next = right;
                right = right.next;
                resultCurr = resultCurr.next;
            }else{
                resultCurr.next = left;
                left = left.next;
                resultCurr = resultCurr.next;
            }
        }
        resultCurr.next = (left == null ) ? right : left;
        return resultHead.next;
    }
    ListNode getMiddleNode( ListNode head ){
        ListNode slowPtr = null;
        while ( head != null && head.next != null ){
            // we do this because we want element preceeding the middle element
            slowPtr = (slowPtr == null ) ? head : slowPtr.next;
            head = head.next.next;
        }
        ListNode mid =  slowPtr.next;
        slowPtr.next = null;
        return mid;
    }
}
