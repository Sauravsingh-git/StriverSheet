package GreedyAlgorithm.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinNumberOfPlatforms {

    // Optimized approach
    // we create an arr which tracks you about net sum of trains arriving or departing 
    // particular time i.e, increement for incoming arr and decreement for departing train
    // then we calculate cummulative sum of the array to find the max platforms under use
    // at any particular instance
    // since for a platform, 2 trains cannot have same arriving or departure time
    // we reduce the platforms after time + 1 minute
    // time complexity : O(n)
    // space complexity : O(1)
    static int findPlatform(int arr[], int dep[], int n)
    {
        int [] trains = new int [2361];
        for ( int ele : arr )
            trains[ele]++;
        for ( int ele  : dep)
        // we are decreementing ele + 1 since the arriving time and dept of 
        // trains at a platform cannot be same
        // so platform will only be free at time + 1 secs
            trains[ele+1]--;
            
        // taking the cummulative sum to get maxNumber of trains at an instance
        int maxPlatforms = 0;
        for ( int i= 1; i < 2361; i++ ){
            trains[i] += trains[i-1];
            maxPlatforms = Math.max(maxPlatforms, trains[i]);
        }
        return maxPlatforms;
    }

    // greedy approach
    // create sort all the arrival and dept time and then sort them
    // now increase the number of platforms required when a train is coming
    // and decrease the number of platforms when train is departing
    // and update the maxPlatform counter accordingly
    // time complexity : O (nlogn)
    // space complexity : O(n)
    static int findPlatform1(int arr[], int dep[], int n){
        List<TrainTime> trainSchedule = new ArrayList<>();
        
        for ( int i = 0; i < n; i++ ){
            trainSchedule.add(new TrainTime(arr[i], 'a'));
            trainSchedule.add(new TrainTime(dep[i], 'd'));
        }
        
        // sort the trainSchedule based on the timing
        // for same time arrival should be before departure
        // since arrival and departure time cannot be same 
        // so if arrival is before departure it would correctly increement the number of platform
        // before updating maxPlatform variable
        int maxPlatforms = 0;
        int currPlatforms = 0;
        Collections.sort( trainSchedule, (train1, train2)-> train1.time - train2.time == 0 ? train1.status - train2.status : train1.time - train2.time);
        for ( int i = 0; i < trainSchedule.size(); i++){
            if ( trainSchedule.get(i).isTrainArriving())
                currPlatforms++;
            else 
                currPlatforms--;
            
            maxPlatforms = Math.max(maxPlatforms, currPlatforms);
        }
        
        return maxPlatforms;
    }
    
}

class TrainTime{
    int time;
    char status;
    public TrainTime(int time, char status){
        this.time = time;
        this.status = status;
    }
    
    public boolean isTrainArriving(){
        return this.status == 'a';
    }
}
