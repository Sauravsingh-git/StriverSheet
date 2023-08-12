package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class AddingOperators{
    public List<String> addOperators(String num, int target) {
        List<String> resultSet = new ArrayList<>();
        addOperatorsUtil(num, target, "", 0, 0, 0, resultSet);
        return resultSet;
    }

    public void addOperatorsUtil( String num, int target, String currExp, int idx, long result, long prevVal, List<String> resultSet ){
        if ( idx == num.length() ){
            if ( result == target ){
                resultSet.add(currExp);
            }
        }
        for ( int j = idx; j < num.length(); j++ ){ 
            // this skips the number with leading zeros
            // i.e. for 2 0 2 target = 4
            // we only want to consider expression like 2 + 0 + 2, 20 * 2, 20 - 2 and not 2 + 02, 2 * 02
            // so when we encounter 0 as first digit we only consider 0 as single digit
            if ( j > idx && num.charAt(idx) == '0' )
                break;
            
            long currNum = Long.parseLong(num.substring(idx, j+1));
            if ( idx == 0 ){
                addOperatorsUtil(num, target, currExp + currNum, j+1, currNum, currNum, resultSet );
            }else{
                addOperatorsUtil(num, target, currExp + "*" + currNum, j+1, result - prevVal + prevVal * currNum, prevVal * currNum, resultSet );
                addOperatorsUtil(num, target, currExp + "+" + currNum, j+1, result + currNum , currNum, resultSet );
                addOperatorsUtil(num, target, currExp + "-" + currNum, j+1, result - currNum, -currNum, resultSet );
            }
        }
    }
}