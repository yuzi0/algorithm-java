// https://programmers.co.kr/learn/courses/30/lessons/42883

import java.util.Arrays;
class Solution {
    public String solution(String number, int k) {
        // 1. number의 앞에 (k+1)개 중에서 가장 큰 수 찾기
        // 2. 가장 큰 수(n1) 앞에 다 지우기
        // ...
        // N(n1+n2+...) == k가 될 때까지 반복
        
        String answer = "";
        String left_num = number;
        int left_k = k;
        do {
            int big = left_num.charAt(0);
            int idx = 0;
            for(int i=1; i<=left_k; i++) {
                if(big < left_num.charAt(i)) {
                    big = left_num.charAt(i);
                    idx = i;
                }
            }
            left_k -= idx;
            answer += Character.toString(big);
            left_num = (answer.length() < number.length() - k)? left_num.substring(idx+1) : "";
        } while((left_num.length() > 0) && (left_k > 0));
        return answer + left_num;
    }
}
// Stack으로 변환해서 풀면 더 좋을 듯..