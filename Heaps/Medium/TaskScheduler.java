package Heaps.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        // we need to create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)-> y-x);
        int [] charMap = new int [26];
        int time = 0;
        for ( char ch : tasks)
            charMap[ch-'A']++;
        
        for( int i = 0; i < 26; i++ ){
            if ( charMap[i] != 0 )
                pq.offer(charMap[i]);
        }
        
        while ( !pq.isEmpty() ){
            // since after an element the same element can be only used after n other elemenets or idle time slots
            int cycle = n + 1;
            List<Integer> remainingTasks = new ArrayList<>();
            while ( cycle > 0 && !pq.isEmpty() ){
                int currTasks = pq.poll();
                if ( currTasks > 1 ){
                    remainingTasks.add(currTasks-1);
                }
                time++;
                cycle--;
            }

            // add the remainingTasks to the queue again
            for ( int task : remainingTasks){
                pq.offer(task);
            }
            
            // if priorityQueue is empty
            if ( pq.isEmpty() ) break;
            // this counts the idle time
            time += cycle;
        }

        return time;
    }
}
