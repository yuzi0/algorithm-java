// https://programmers.co.kr/learn/courses/30/lessons/12931

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=(int)Math.log10((double)n); i>=0; i--) {
            answer += n/(int)Math.pow(10, i);
            n = n%(int)Math.pow(10, i);
        }
        return answer;
    }
}