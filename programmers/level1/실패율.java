// https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 각 스테이지에 클리어하지 못한 사용자 수
        int[] notClearUsers = new int[N + 1];
        for(int stage : stages) {
            notClearUsers[stage - 1]++;
        }
        
        // 실패율 계산
        float user = stages.length;
        float[] failure = new float[N + 1];
        for(int i = 0; i < N; i++) {
            if(user != 0) {
                failure[i] = notClearUsers[i] / user;
                user -= notClearUsers[i];
            } else {
                failure[i] = 0;
            }
        }
        
        // failure에 따라 내림차순 정렬하기
        float[] sortedFailure = new float[N];
        for(int i = 0; i < N; i++) {
            sortedFailure[i] = failure[i];
        }
        Arrays.sort(sortedFailure);
        for(int i = 0; i < N; i++) {
            for(int j = N-1; j >= 0; j--) {
                if(sortedFailure[i] == failure[j]) {
                    answer[N-i-1] = j+1;
                    failure[j] = 100;
                    break;
                }
            }
        }
        return answer;
    }
}