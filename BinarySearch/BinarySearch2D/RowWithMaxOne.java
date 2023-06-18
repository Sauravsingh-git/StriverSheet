package BinarySearch.BinarySearch2D;

public class RowWithMaxOne {
    // brute force approach 
    // time complexity : O(n*m)
    int rowWithMax1sbf(int arr[][], int n, int m) {
        int maxCount = 0;
        int maxCountIdx = -1;
        for ( int i = 0; i < n; i++ ){
            int currCount = 0;
            for ( int j = 0; j < m; j++ ){
                if (arr[i][j] == 1) currCount++;
            }
           if ( maxCount < currCount ){
               maxCount = Math.max(maxCount, currCount);
               maxCountIdx = i;
           }
        }
        return maxCountIdx;
    }
    
    // approach 2 : using binary search to count number of ones
    // time complexity : O(nlogm)
    int rowWithMax1s2 ( int arr[][], int n, int m ){
        int maxCount = 0;
        int maxCountIdx = -1;
        for ( int i = 0; i < n; i++ ){
            int currCount = m - findFirstOne(arr[i],m) ;
            if ( maxCount < currCount){
                maxCount = currCount;
                maxCountIdx = i;
            }
        }
        return maxCountIdx;
    }
    
    int findFirstOne( int [] arr, int len ){
        int high = len -1;
        int low = 0;
        int firstOneIdx = len;
        while ( low <= high ){
            int mid = ( high + low ) >> 1;
            if ( arr[mid] == 1){
                firstOneIdx = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return firstOneIdx;
    }
    
    // approach 3 : get the first occurence of one in row 1
    // and then check in row2 from first occurence + 1
    // stop if you have already found the row where first occurence == 0 idx
    
    int rowWithMax1s ( int [][] arr, int n, int m){
        // gettting the firstOne in row one
        int firstOccurence = m;
        int maxOneRow = 0;
        
        for ( int i = m-1; i >= 0; i-- ){
            if ( arr[0][i] == 0 ) break;
            firstOccurence = i;
        }
        if ( firstOccurence == 0) return 0;
        // checking for every row
        for ( int i = 1; i < n; i++ ){
        if ( firstOccurence == 0 ) return i-1;
            int j = firstOccurence;
            while ( j > 0 && arr[i][j-1] == 1 )
                j--;
            
            if ( j < firstOccurence){
                firstOccurence = j;
                maxOneRow = i;
            };

        }
        
        return firstOccurence  == m ? -1 : maxOneRow;
        
    }
}
