package ExtraQues;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists){
        // Optimized approach
        // time complexity : O (Nlogk) 
        // k -> number of lists
        // N -> number of nodes
        // space complexity : O(1)
        if( lists.length == 0 ) return null;
        return mergeKListsUtil(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsUtil(ListNode [] lists, int left, int right ){
        if ( left == right )
            return lists[left];
        int k = right - left +1;
        ListNode head1 = mergeKListsUtil(lists, left, left + k/2-1);
        ListNode head2 = mergeKListsUtil(lists, left + k/2, right);
        
        if ( head1 == null || head2 == null ) 
            return head1 == null ? head2 : head1;
        
        ListNode head, curr;
        if( head1.val > head2.val ){
            curr = head2;
            head2 = head2.next;
        }else{
            curr = head1;
            head1 = head1.next;
        }
        head = curr;

        while( head1 != null && head2 != null ){
            if(head1.val > head2.val){
                curr.next = head2;
                head2 = head2.next;
                curr = curr.next;
            }else{
                curr.next = head1;
                head1 = head1.next;
                curr = curr.next;
            }
        }

        curr.next = head1 == null ? head2 : head1;
        return head;
    }

//--------------------------------------------------------------------------------------------------------------
    public ListNode mergeKLists1(ListNode[] lists) {
        // brute force approach
        // time complexity : O (kN) 
        // O(sum([for i in range (1 , k-1) [i* N/k]]) + N/k )
        // k -> number of lists
        // N -> number of nodes
        // space complexity : O(1)
        if(lists.length == 0) return null;
        for ( int i = 0; i < lists.length-1; i++ ){
            lists[i+1] = mergeTwoLists(lists[i], lists[i+1]);
        }
        return lists[lists.length -1];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if( list1 == null || list2 == null ){
            return list1 == null ? list2 : list1;
        }
        ListNode resultHead;
        ListNode currResultNode;
        ListNode curr1 = list1, curr2 = list2;
        if(curr1.val > curr2.val){
            currResultNode = curr2;
            curr2 = curr2.next;
        }else{
            currResultNode = curr1;
            curr1 = curr1.next;
        }
        resultHead  = currResultNode;

        while ( curr1 != null && curr2 != null ){
            if( curr1.val > curr2.val ){
                currResultNode.next = curr2;
                curr2 = curr2.next;
                currResultNode = currResultNode.next;
            }else{
                currResultNode.next = curr1;
                curr1 = curr1.next;
                currResultNode = currResultNode.next;
            }
        }
        currResultNode.next = curr1 == null ? curr2 : curr1;
        return resultHead;
    }
}
