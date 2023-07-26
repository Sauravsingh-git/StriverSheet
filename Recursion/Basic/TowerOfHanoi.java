package Recursion.Basic;

public class TowerOfHanoi {
    // intution : for only 2 plates
    // we only need to perform operations
    // remove plate FROM pole and put in HELPER
    // put the last plate FROM pole to DESTINATION pole
    // remove plate from HELPER pole and put on DESTINATION pole
    // for more plates, we transfer n-1 plates to HELPER, transfer last plate to DESTINATION
    // then from HELPER pole transfer previously transfered n-1 discs to the DESTINATION pole
    public void toh(int from, int destination, int helper, int discs){
        if ( discs == 0 ) return;

        toh(from, helper, destination, discs- 1);
        System.out.println("From " + from + " to " + destination + " using helper "+ helper);
        toh(helper, destination, from, discs-1);  
    }
}
