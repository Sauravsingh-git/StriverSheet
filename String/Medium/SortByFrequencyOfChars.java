package String.Medium;
import java.util.*;
public class SortByFrequencyOfChars {
    // brute force approach
    // using HashMap to store occurences
    // then storing entrySet in arraylist and sorting it using collections.sort
    // time complexity : O(nlogn) n-> len(str)
    // space complexity : O(n)
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for ( char ch : s.toCharArray() ){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (entry1, entry2)-> entry2.getValue() - entry1.getValue()==0? entry1.getKey()-entry2.getKey() : entry2.getValue() - entry1.getValue());
        StringBuilder sb = new StringBuilder();
        for ( Map.Entry<Character, Integer> entry : entries){
            char ch = entry.getKey();
            int occurences = entry.getValue();
            while (occurences-- > 0)
                sb.append(ch);
        }

        return sb.toString();
    }
}
