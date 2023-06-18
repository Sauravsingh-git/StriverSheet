package BinarySearch.BinarySearch2D;

import java.util.ArrayList;
import java.util.Collections;

public class MatrixMedian {
    // brute force approach
    // convert 2d list to 1d list and find the median
    public int findMedian1(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> list = new ArrayList<>();
        for ( int i = 0; i < A.size(); i++ ){
            for ( int j = 0; j < A.get(i).size(); j++ ){
                list.add(A.get(i).get(j));
            }
        }
        Collections.sort(list);
        int totalEle = list.size();
        
        return totalEle%2 == 0 ? (list.get(totalEle/2) + list.get(totalEle/2-1))/2 : list.get(totalEle/2);
    }
    
    // do the binary search on the range of arr[i]
    // check if the mid is such that
    // number of elements <= mid is equal to (rows *cols )/2
    // to find how many numbers of elements are smaller
    // apply binary search of every row to found the upper bound
    public int findMedian(ArrayList<ArrayList<Integer>> matrix){
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int low = 1;
        int high = 1000000000;
        while ( low <= high ){
            int mid = ( low + high ) >>  1;
            int count = 0;
            for ( int i = 0; i < rows; i++ ){
                count += numberIsGreaterThanEqualTo(matrix.get(i), mid);
            }
            if ( count <= (rows * cols)/2){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }    

    
    public int numberIsGreaterThanEqualTo( ArrayList<Integer> row, int target){
        int len = row.size();
        int low = 0;
        int high = len-1;
        while ( low <= high ){
            int mid = ( low + high )>>1;
            if ( row.get(mid) <= target){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
