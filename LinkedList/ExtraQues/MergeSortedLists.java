package ExtraQues;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ( list1 == null || list2 == null ){
            return list1 == null? list2 : list1;
        }
        ListNode curr, head;
        if ( list1.val > list2.val ){
            curr = list2;
            list2 = list2.next;
        }else{
            curr = list1;
            list1 = list1.next;
        }
        // head pointer to store the first element of the merged list
        head = curr;

        while ( list1 != null && list2 != null ){
            if( list1.val > list2.val ){
                curr.next = list2;
                list2 = list2.next;
            }else{
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 == null ) ? list2 : list1;
        return head;
    }
}
