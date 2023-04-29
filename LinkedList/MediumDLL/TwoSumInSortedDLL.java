package MediumDLL;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;


class TwoSumInSortedDLL{
    public static void main(String [] args){
        DLL dll = new DLL();
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);
        dll.insertAtEnd(6); 
        dll.insertAtEnd(8); 
        dll.insertAtEnd(9); 
        TwoSumInSortedDLL obj = new TwoSumInSortedDLL();
        List<List<Integer>> list = obj.getPairs(dll.head, 7);
        System.out.println(list);

    }

    // if the given doubly link list is sorted 
    public List<List<Integer>> getPairs(ListNode head, int target){
        // two pointers approach
        List<List<Integer>> result = new ArrayList<>();
        ListNode left = head, right = head;
        while( right.next != null ){
            right = right.next;
        }
        while(left != right && left.prev != right){
            int temp = left.val + right.val;
            if( temp < target)
                left = left.next;
            else if  ( temp > target )
                right = right.prev;
            else{
                result.add(new ArrayList<>(Arrays.asList(left.val, right.val)));
                left = left.next;
                right = right.prev;
            }
        }
        return result;
    }

    // if the list is not given in sorted order and you have to return the pairs in asceding order by the first element of the pair
    public  ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, ListNode head) {
        // code here
        Set<Integer> set = new HashSet<>();
        Set<Integer> firstEleSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ListNode curr = head;
        while ( curr != null ){
            
            if( !firstEleSet.contains(target-curr.val) && set.contains(target - curr.val)){
                result.add(new ArrayList<>(Arrays.asList(target-curr.val, curr.val)));
                firstEleSet.add(target-curr.val);
            }
                set.add(curr.val);
            
            curr = curr.next;
            
        }
        Collections.sort(result, (l1, l2)->l1.get(0) - l2.get(0));
        return result;
    }
}