// https://programmers.co.kr/learn/courses/30/lessons/60057
// 2020 카카오 공채 문제

class Solution {
    public int solution(String s) {
        int min = s.length();
        int len = s.length()/2+1;
        // 문자열 자르는 단위 : i ( 1부터 s.length()/2 까지 )
        for(int i = 1; i < len; i++) {
            String before = "";
            int sum = 0;
            int cnt = 1;
            // 문자열 자르는 시작 지점 : j
            for(int j = 0; j < s.length();) {    
                // j에서 j+i만큼 문자열 자르기
                int start = j;
                j = (j+i > s.length()) ? s.length():j+i;
                String temp = s.substring(start, j);
                // 이전 문자열이랑 비교
                if(temp.equals(before)) {
                    // 문자열이 같으면 cnt++
                    cnt++;
                } else {
                    // 문자열이 다르면
                    // 숫자 길이를 sum에 더해준다
                    if(cnt != 1) {
                        sum += (int)Math.log10(cnt)+1;
                    }
                    // cnt는 1로 초기화
                    cnt = 1;
                    // 이전 문자열을 sum에 더해준다
                    sum+=before.length();
                    // 앞의 문자열을 이전 문자열로 설정
                    before = temp;
                }
            }
            // 문자열 길이 + 숫자 길이
            sum+=before.length();
            if(cnt != 1) {
                sum += (int)Math.log10(cnt)+1;
            }
            // 짧은 문자열 길이 분별
            min = (min > sum) ? sum : min;
        }

        return min;
    }
}