// https://programmers.co.kr/learn/courses/30/lessons/42898
// 실패
// 테스트 1번만 통과함 => 처음부터 다시 풀 것.

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // answer : 집에서 학교까지 갈 수 있는 최단 경로의 개수
        // m, n : 경로의 크기
        // pubbles : 장애물의 위치
        
        // 해당 문제에 대한 규칙을 찾아서 {모든 경로 - 해당 위치를 지나는 경로} 구하기
        // 해당 위치를 지나는 경로 = 해당 위치까지의 경로 * 해당 위치부터 도착 지점까지의 경로

        // 경로 법칙 route[i][j] = route[i-1][j] + route[i][j-1]

        int[][] routes = new int[n][m];
        
        // 초기화
        for (int i = 0; i < n; i++) {
            routes[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            routes[0][i] = 1;
        }
        
        
        for (int i = 1; i < n; i++) {         
            for (int j = 1; j < m; j++) {
                if (isPuddle(i, j, puddles))
                    routes[i][j] = 0;
                else
                    routes[i][j] = routes[i-1][j] + routes[i][j-1];
            }
        }

        answer = routes[n-1][m-1];

        return answer;
    }
    
    boolean isPuddle(int i, int j, int[][] puddles) {
        for (int[] puddle : puddles) {
            if ((puddle[0] == i && puddle[0] == j) || (puddle[0] == i && puddle[0] == j)) {
                return true;
            }
        }
        
        return false;
    }
}