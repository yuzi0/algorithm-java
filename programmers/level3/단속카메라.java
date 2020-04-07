// https://programmers.co.kr/learn/courses/30/lessons/42884
// 단속카메라(탐욕법)

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // 1. 각 위치에 해당 차량이 지나갔다는 데이터가 쌓이게 구현
        // 2. 먼저 데이터가 가장 많이 쌓인 구간에 단속카메라를 설치한다.
        // 3. 그리고 해당 구간을 지나간 차량은 visit[n] = true 와 같이 처리한다.
        // (반복)1. visit[n] = false 인 차량이 지나가는 위치에 데이터를 쌓이게 한다.
        // ...
        // visit가 모두 true가 될 때까지 반복한다.
        return answer;
    }
}