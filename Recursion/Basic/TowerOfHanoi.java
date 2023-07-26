package Recursion.Basic;

public class TowerOfHanoi {
    public static void main(String [] args){
        TowerOfHanoi obj = new TowerOfHanoi();
        obj.toh(1, 3, 2, 3);
    }

    public void toh(int from, int destination, int helper, int discs){
        if ( discs == 0 ) return;

        toh(from, helper, destination, discs- 1);
        System.out.println("From " + from + " to " + destination + " using helper "+ helper);
        toh(helper, destination, from, discs-1);  
    }
}
