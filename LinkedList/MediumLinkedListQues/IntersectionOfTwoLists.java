package MediumLinkedListQues;

public class IntersectionOfTwoLists {
    
    public ListNode getIntersectionNode( ListNode headA, ListNode headB ){
        // optimized approach
        // time complexity : O (m + n)
        // space complexity : O(1)
        ListNode currA = headA, currB = headB;
        while( currA != null && currB != null ){
            currA = currA.next;
            currB = currB.next;
        }
        boolean isAGreater = currB == null;
        int extraNodes = 0;
        while( currA!= null ) {
            extraNodes++;
            currA = currA.next;
        }
        while ( currB != null ){
            extraNodes++;
            currB = currB.next;
        }

        // reinitializing currA and currB to headA and headB respectively
        currA = headA;
        currB = headB;
        if(isAGreater){
            while( extraNodes-- > 0)
                currA = currA.next;
        }else{
            while( extraNodes-- > 0)
                currB = currB.next;
        }

        while(currA != currB ){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // brute force with O(m*n) time complexity 
        ListNode currA, currB;
        currA = headA;
        currB = headB;
        //    To check if 2 lists intersect or not by check the last nodes of both the lists
        while( currA.next != null ) currA = currA.next;
        while(currB.next != null ) currB = currB.next;
        if( currA != currB ) return null;
        //    reinitializing currA and currB to headA and headB respectively
        currA = headA;
        currB = headB;
        while( currA != null ){
            currB = headB;
            while( currB != null ){
                if ( currA == currB ){
                    return currA;
                }
                currB = currB.next;
            }
            currA = currA.next;
        }
        return null;
    }
}
