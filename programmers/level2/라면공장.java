// https://programmers.co.kr/learn/courses/30/lessons/42629

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        // 내림차순 정렬 Priority Queue
        PriorityQueue<Integer> ordered_supplies = new PriorityQueue<>(
            new Comparator<Integer> () { 
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            }
        );
        //PriorityQueue<Integer> ordered_supplies = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
        
        int i=0;
        while(stock<k) {
            while((i<dates.length)&&(stock >= dates[i])) {
                ordered_supplies.add(supplies[i]);
                i++;
            }
            answer++;
            stock += ordered_supplies.poll();
        }
        return answer;
    }
}