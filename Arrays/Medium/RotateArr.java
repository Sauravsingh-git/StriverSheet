package Arrays.Medium;

public class RotateArr {

    //brute force
    //use extra array to rotate the array


    // optimized array
    // First transpose the array
    // the reverse the rows
    // time complexity : O(n*m)
    // Space complexity : O(1)
        public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for ( int i = 0; i < matrix.length; i++ ){
            reverseArray(matrix[i]);
        }
    }

    public void reverseArray( int [] arr ){
        int low = 0, high = arr.length-1;
        while ( low < high ){
            swap(arr, low++, high--);
        }
    }

    public void swap( int [] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}