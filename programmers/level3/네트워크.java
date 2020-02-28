// https://programmers.co.kr/learn/courses/30/lessons/43162
// 실패

import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] network = new boolean[n];
        
        for (int i=0; i<n; i++) {
            HashSet<Integer> check = new HashSet<>();
            if (!network[i]) {
                for (int j=0; j<i; j++) {
                    if (computers[i][j] == 1 && network[i] == false) {
                        network = checkVisit(computers, i, j, network);
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    boolean[] checkVisit(int[][] computers, int i, int j, boolean[] visited) {
        visited[i] = true;
        visited[j] = true;
        
        for (int k=0; k<j; k++) {
            if (computers[j][k] == 1 && visited[k] == false) {
                visited = checkVisit(computers, i, j, visited);
            }
        }
        return visited;
    }
}