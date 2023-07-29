package Recursion.SubsequencePattern;
import java.util.*;
public class GenerateAllBinaryStrings {
    // optimized approach
    // time complexity : O(2^n)
    // space complexity : O(2^n)
    public static List<String> generateBinaryStrings(int n){
        List<String> binaryStrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateBinaryStringsUtil(sb, false, binaryStrings, n);
        return binaryStrings;
    }
    
    
    public static void generateBinaryStringsUtil(StringBuilder sb, boolean previousDigitIsOne, List<String> list, int n ){
        if ( sb.length() == n ){
            list.add(sb.toString());
            return;
        }
        if ( previousDigitIsOne ){
            sb.append('0');
            generateBinaryStringsUtil(sb, false, list, n);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append('0');
            generateBinaryStringsUtil(sb, false, list, n);
            sb.deleteCharAt(sb.length()-1);
            sb.append('1');
            generateBinaryStringsUtil(sb, true, list, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    // brute force approach
    // time complexity : O(2^n * n)
    // space complexity : O(2^n * n)
  public static List<String> generateBinaryStringsBF(int n) {
    List<String> binaryStrings = new ArrayList<>();
    generateBinaryStringsBF("", n, binaryStrings);
    List<String> binaryStringsWithoutConsecutiveOnes = new ArrayList<>();
    for ( int i = 0; i < binaryStrings.size(); i++){
        if ( !containsConsecutiveOnes(binaryStrings.get(i)) )
            binaryStringsWithoutConsecutiveOnes.add(binaryStrings.get(i));
    }
    return binaryStringsWithoutConsecutiveOnes;
  }
  
  public static boolean containsConsecutiveOnes(String str ){
      for ( int i = 0; i < str.length() -1; i++ ){
          if ( str.charAt(i) == '1' && str.charAt(i+1) == '1'){
              return true;
          }
      }
      
      return false;
  }
  public static void generateBinaryStringsBF(String str, int n, List<String> list){
      if ( str.length() == n ) {
          list.add(str);
          return;
      }
      
      generateBinaryStringsBF(str + "0", n, list);
      generateBinaryStringsBF(str + "1", n, list);
  }
}
