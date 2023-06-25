package GreedyAlgorithm.Easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int noOfChildrenContent = 0;
        int idx1 = g.length-1, idx2 = s.length-1;
        while ( idx1 >= 0 && idx2 >= 0){
            if ( g[idx1] <= s[idx2]){
                noOfChildrenContent++;
                idx1--;
                idx2--;
            }else { 
                idx1--;
            }
        }
        return noOfChildrenContent;
    }
}
