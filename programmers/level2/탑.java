// https://programmers.co.kr/learn/courses/30/lessons/42588

import java.util.Arrays;
class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i=heights.length-1; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(heights[i] < heights[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}