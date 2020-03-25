// https://programmers.co.kr/learn/courses/30/lessons/49191
// 실패

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] scores = new int[n][n];
        
        if ( n == 1 ) return 1;
        
        // 점수판 생성
        for ( int[] result : results ) {
            scores[result[0]-1][result[1]-1] = 1;
            scores[result[1]-1][result[0]-1] = -1;
        }
        
        return answer;
    }
}