package Arrays.Easy;

import java.util.ArrayList;

public class Union {
    // input arrays are sorted
    // output should also be sorted
    // time complexity : O(n)
    // space complexity : O(1)
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> list =  new ArrayList<>();
        int i= 0, j = 0;
        // adding an element to the list so that list.get(list.size()-1)
        // does not giveout -1 ( out of bound exception)
        list.add(arr1[i] > arr2[j] ? arr2[j] : arr1[i]);
        while ( i < n && j < m ){
            if ( arr1[i] == list.get(list.size()-1) ){
                i++;
            }else if ( arr2[j] == list.get(list.size()-1) ) {
                j++;
            }else if ( arr2[j] < arr1[i] ){
                list.add(arr2[j++]);
            }else{
                list.add(arr1[i++]);
            }
        }
        
        while ( i < n ){
            if ( arr1[i] == list.get(list.size() -1))
                i++;
            else
                list.add(arr1[i]);
        }
        
        while ( j < m ){
            if ( arr2[j] == list.get(list.size() -1))
                j++;
            else
                list.add(arr2[j]);
        }
        return list;
    }
}
