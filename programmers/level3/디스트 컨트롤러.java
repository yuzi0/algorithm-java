// https://programmers.co.kr/learn/courses/30/lessons/42627
// 실패

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> waitingJobs = new ArrayList<>();
        int total_waiting_time = jobs[0][1];
        int time = jobs[0][1];
        
        for (int i = 1; i < jobs.length && waitingJobs.isEmpty();) {
            // 해당 시간동안 들어온 작업 추가
            while ( time >= jobs[i][0] || waitingJobs.isEmpty() ) {
                Job job = new Job();
                job.request_time = jobs[i][0];
                job.task_time = jobs[i][1];
                waitingJobs.add(job);
                
                if ( i >= jobs.length - 1 ) break; 
                i++; 
            }
            if ( i >= jobs.length - 1 ) i++;
            
            System.out.println(waitingJobs.toString());
            
            // 정렬
            Collections.sort(waitingJobs);
            
            // 작업시간이 짧은 작업 꺼내기
            do {
                Job shortestJob = waitingJobs.get(0);
                total_waiting_time += (time - shortestJob.request_time + shortestJob.task_time);
                time += shortestJob.task_time;
            } while ( i < jobs.length - 1 || !waitingJobs.isEmpty() );
            
            //System.out.println(shortestJob.toString());
        }
        
        return total_waiting_time / jobs.length;
    }
    
    public class Job implements Comparable<Job> {
        int request_time;
        int task_time;
        
        @Override
        public int compareTo(Job o) {
            return this.task_time - o.task_time;
        }
        
        @Override
        public String toString() {
            return "[request_time : " + request_time + ", task_time : " + task_time + "]";
        }
    }
}