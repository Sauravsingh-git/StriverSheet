package GreedyAlgorithm.Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestJobFirst {
     public int[] getOrder(int[][] tasks) {
        // min heap for jobs with shortest time
        PriorityQueue<Job> shortestJob = new PriorityQueue<>( (x, y) -> x.processingTime - y.processingTime == 0 ? x.jobNo - y.jobNo : x.processingTime - y.processingTime);
        // sort the array according to their enqueueTime
        int len = tasks.length;
        int [][] tasksWithProcessId = new int [len][3];
        for ( int i = 0; i < len; i++ ){
            tasksWithProcessId[i][0] = i;
            tasksWithProcessId[i][1] = tasks[i][0];
            tasksWithProcessId[i][2] = tasks[i][1];
        }
        Arrays.sort( tasksWithProcessId, (x, y)-> x[1] - y[1]);

        int currTime  = 1;
        int [] schedule = new int [len];
        int idx = 0, i= 0;
        while ( idx < len || !shortestJob.isEmpty() ){
            if ( shortestJob.isEmpty() && currTime < tasksWithProcessId[idx][1] ){
                currTime = tasksWithProcessId[idx][1];
            }
            while ( idx < len &&  tasksWithProcessId[idx][1] <= currTime){
                shortestJob.offer(new Job(tasksWithProcessId[idx][0], tasksWithProcessId[idx][1], tasksWithProcessId[idx][2]));
                idx++;
            }
            Job currJob = shortestJob.poll();
            schedule[i++] = currJob.jobNo;
            currTime += currJob.processingTime;
        }
        return schedule;
    }
}

class Job{
    int enqueueTime, processingTime, jobNo;
    public Job( int jobNo, int enqueueTime, int processingTime){
        this.jobNo = jobNo;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }
}