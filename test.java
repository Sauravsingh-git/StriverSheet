import java.util.Arrays;
public class test {
    public static String countSort(String word)
    {
        char [] arr = word.toCharArray();
        int len = arr.length;
        int [] map = new int[26];
        for ( char ch : arr )
            map[ch-'a']++;
             
        
        // getting the actual posititons of the characters
        for ( int i = 1; i < 26; i++ ){
            map[i] += map[i-1];
        }

        System.out.println(Arrays.toString(map));
        // populating the new array
        char [] outputarr = new char [len];
        
        for ( int i = len-1; i >= 0; i--){
            outputarr[map[arr[i]-'a']-1] = arr[i];
        }
        return new String(outputarr);
    }

    public static void main(String [] args){
        String str = countSort("edsab");
        System.out.println(str);
    }
}
