// https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
    	
        for(int i = 0; i < completion.length; i++) {
        	if(participant[i].equals(completion[i]) == false) {
        		return participant[i];
        	}
        }
        return participant[participant.length - 1];
    }
}
// 딱 1시간 걸림 ㅜㅜ String 문자열 비교할 때 == 대신 equals 사용하니깐 해결됨..