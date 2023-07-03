package Heaps.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if ( len%groupSize != 0 ) return false;
        if ( groupSize == 1) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // populating the hashMap
        for ( int card : hand )
            map.compute(card, (key, value)-> value == null ? 1 : value+1);
        
        for ( int card : map.keySet())
            pq.offer(card);

        while ( !pq.isEmpty() ){
            int cards = groupSize;
            List<Integer> remainingList = new ArrayList<>();
            int prevCard = -1;
            while ( cards > 0 ){
                // this condition is important as the list could have 3,3,3
                // 3 will be removed in 1st iteration and put into remainingList
                // in the next iteration pq will be empty and throw null pointer exception
                // this type of case will not be captured by len%group == 0
                if ( pq.isEmpty() ) return false;
                int currCard = pq.poll();
                map.compute(currCard, (k, v)-> v-1);
                if ( map.get(currCard) != 0 )
                    remainingList.add(currCard);
                if ( cards != groupSize && currCard != prevCard + 1) return false;
                prevCard = currCard;
                cards--;
            }

            for ( int ele : remainingList)
                pq.offer(ele);
            
        }
        return true;
    }
}