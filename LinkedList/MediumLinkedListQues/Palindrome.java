package MediumLinkedListQues;

public class Palindrome {
    // Que. Check if the given linkedList is a palindrome
    ListNode frontPtr;
    public static void main(String [] args){
        Palindrome obj = new Palindrome();
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(1);
        System.out.println(obj.isPalindrome(ll.head));

    }
    
    public boolean isPalindromeRec(ListNode head){
        // Time complexity : O(N)
        // Space complexity : O(N)
        frontPtr = head;
        return solve(head);
    }
    public boolean solve(ListNode currPtr){
        if( currPtr != null ){
        if(!solve(currPtr.next)) return false;
        if( currPtr.val != frontPtr.val) return false;
        frontPtr = frontPtr.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head){
        // base case 
        if ( head == null || head.next == null ) return true;
        // find the middle of the node
        ListNode slowPtr = head, fastPtr = head;
        while( fastPtr != null && fastPtr.next != null ){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        if(fastPtr != null )
            slowPtr = slowPtr.next;
        ListNode temp = reverse(slowPtr, null);
        ListNode curr = head;
        while( temp != null ){
            if( curr.val != temp.val ) return false;
            curr = curr.next;
            temp  = temp.next;
        }
        return true;
    }

    public ListNode reverse(ListNode curr, ListNode prev){
        if( curr == null ) return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(temp, curr);
    }
}
