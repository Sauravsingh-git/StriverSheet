package GreedyAlgorithm.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingIn1Room {
    // Greedy approach : we are going to sort list of meetings by their finish time
    // by approaching to the meetings with their finish time we will be able 
    // to accomodate maximum meetings in the list
    // time complexity : O(nlogn)
    // space complexity : O(n)
    public static int maxMeetings(int start[], int end[], int n){
        int len = start.length;
        // creating a list for meetings
        List<Meeting> meetings = new ArrayList<>();
        for ( int i = 0; i < len; i++ ){
            meetings.add(new Meeting(start[i], end[i]));
        }
        
        // sorting them according to the finish time
        Collections.sort(meetings, (x, y)->{
            return x.end - y.end == 0 ? y.start - x.start : x.end - y.end;
        });
        
        int meetingsCount = 0;
        int endTime = 0;
        for ( int i = 0; i < len; i++ ) {
            Meeting currMeeting = meetings.get(i);
            if ( currMeeting.start > endTime ){
                meetingsCount++;
                endTime = currMeeting.end;
            }
        }
        return meetingsCount;
        
    }
}


class Meeting{
    int start, end;
    public Meeting( int start, int end) {
        this.start = start;
        this.end = end;
    }
}
