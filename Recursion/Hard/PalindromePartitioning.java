package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
     public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        partitionUtil(s, new ArrayList<String>(), partitions);
        return partitions;
    }

    public void partitionUtil(String s, List<String> currList, List<List<String>> resultSet){
        if( s.length() == 0 ){
            resultSet.add(new ArrayList<>(currList));
            return;
        } 

        for ( int i = 0; i < s.length(); i++ ){
            String firstPartition = s.substring(0, i+1);
            if ( isPalindrome(firstPartition)){
                currList.add(firstPartition);
                partitionUtil(s.substring(i+1), currList, resultSet);
                currList.remove(currList.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s ){
        int low = 0;
        int high = s.length()-1;
        while ( high > low ){
            if ( s.charAt(low++) == s.charAt(high--)) continue;
            return false;
        }
        return true;
    }
}
