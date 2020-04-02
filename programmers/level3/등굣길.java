// https://programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // answer : 집에서 학교까지 갈 수 있는 최단 경로의 개수
        // m, n : 경로의 크기
        // pubbles : 장애물의 위치

        // 결국은 오른쪽으로 m번, 아래로 n번 움직이기만 하면 됨
        // 언제 오른쪽으로, 아래로 움직이는지에 따라 경로가 정해짐
        // 장애물을 지나는 경우에 대해서만 제하면 됨 
        
        // 해당 문제에 대한 규칙을 찾아서 {모든 경로 - 해당 위치를 지나는 경로} 구하기
        // 해당 위치를 지나는 경로 = 해당 위치까지의 경로 * 해당 위치부터 도착 지점까지의 경로
        
        return answer;
    }   
}