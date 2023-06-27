package GreedyAlgorithm.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class JobScheduling {
    // most otimized approach : using priority Queue and sorting the job arr on deadline
    // Intutition : 
    // Since we want to put the most profitable job at as close to deadline as possible
    // we start from the biggest deadline, at this deadline only those jobs are candidate which have
    // deadline greater than or equal to this
    // so we maintain a max heap based on profit and keep jobs into priorityQueue
    // until we get some slots between currDeadline and next Jobs Deadline
    // if we have more than one slot empty more than one jobs will be taken from the queue
    // to check the number of slots available we check the difference of deadline between two
    // consecutive jobs
    
    // time complexity : O(nlogn)
    // space complexity : O(n)
    int [] JobSchedulingO( Job arr[], int n ){
        // sort the jobs arr with by their time lines
        Arrays.sort(arr, (x, y) -> y.deadline - x.deadline);
        PriorityQueue<Job> queue = new PriorityQueue<>((x, y)->y.profit - x.profit);
        int currJobs, currProfit;
        currJobs = currProfit = 0;
        for ( int i = 0; i < n; i++  ){
            int timeSlots;
            if ( i == n - 1){
                // since we will as many timeslots as the deadline of last task
                // i.e if last job in array has deadline of 4, we have 4 timeslots
                timeSlots = arr[i].deadline; 
            }else{
                // if arr[i].deadline = 4 and arr[i+1].deadline = 2, we have 2 timeslots
                timeSlots = arr[i].deadline - arr[i+1].deadline;
            }
            queue.add(arr[i]);
            while ( timeSlots-- > 0 && !queue.isEmpty() ){
                Job currJob = queue.poll();
                currJobs++;
                currProfit += currJob.profit;
            }
        }
        return new int [] { currJobs, currProfit };
    }
    // approach : we will sort the jobs by profit 
    // and then select the job of maximum profit and then 
    // execute them as late as possible
    // we will maintain a schedule array to keep a track of which job should 
    // be perfomred when we a slot empty
    
    // time complexity : O(nlogn) + O(n*n)
    int[] JobSchedulingBF(Job arr[], int n){
        // sorting the arrays by profit
        Arrays.sort( arr, (x, y) -> y.profit - x.profit);
        // since the deadline is always less than equal to n
        int [] schedule = new int [n+1];
        int currJobs = 0, currProfit = 0;
        int currJobIdx = 0;
        while ( currJobIdx < n){
            int currJobSchedule = arr[currJobIdx].deadline;
            while ( schedule[currJobSchedule] != 0 ){
                currJobSchedule--;
            }
            if ( currJobSchedule != 0 ){
                schedule[currJobSchedule] = arr[currJobIdx].id;
                currJobs++;
                currProfit += arr[currJobIdx].profit;
            }
            currJobIdx++;
        }
        return new int [] { currJobs,  currProfit};
    }
}


class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}