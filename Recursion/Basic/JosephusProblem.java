package Recursion.Basic;

public class JosephusProblem {
    // optimal solution
    // intuition : After we kill the kth guy, we again start from start from the next guy
    // but the next guy will be treated as 1 ( next guy -> guy next to the last person killed)
    // so will need to add k-1 to the answer returned by josephus(n-1, k) + k-1
    // since the number could exceed the total number we take the modulus and add 1 to it since we are using one based indexing
    // time complexity : O(n)
    // space complexity : O(n) auxillary space
    public int josephus( int n, int k ){
        if (n == 1) return n;
        
        return ( josephus(n-1, k ) + k-1)%n + 1;
    }
    // brute force approach
    // intuition : we will create a circular linkedlist and delete the kth node every time
    // time complexity : O(nk)
    // space complexity : O(n)
   public int josephusItr(int n, int k){
        if ( k == 1 ) return n;
        // creating a circular linked list
        Node head = new Node(1);
        Node curr = head;
        for ( int i = 2; i <= n; i++ ){
            curr.next = new Node(i);
            curr = curr.next;
        }
        curr.next = head;

        curr = head;
        while ( curr.next != curr ){
            int temp = k - 2;
            while ( temp != 0 ){
                curr = curr.next;
                temp--;
            }
            curr.next = curr.next.next;
            curr = curr.next;
        } 
        return curr.id;
    }
}

class Node{
    int id;
    Node next;
    public Node( int id ){
        this.id = id;
        next = null;
    }
}

