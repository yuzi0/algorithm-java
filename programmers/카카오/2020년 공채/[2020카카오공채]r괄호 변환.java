// https://programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Stack;

class Solution {
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        
        // 균형잡힌 괄호 문자열로 분리
        Stack<String> brackets = new Stack<String>();
        int chk = 0;
        for(int i=0; i<p.length(); i++) {
            chk = (p.charAt(i) == '(')? chk+1 : chk-1;
            if(chk == 0) {
                brackets.push(p.substring(0, i+1));
                p = p.substring(i+1);
                i = -1;
            }
        }
        brackets.push("");
        
        // 문자열 p를 올바른 괄호 문자열로 바꾸기
        while(brackets.size() > 1) {
            String v = brackets.pop();
            String u = brackets.pop();
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면
            if(u.charAt(0) == ')') {
                brackets.push("(" + v + ")" + reverseBracket(u));
            } else { // 3. 문자열 u가 "올바른 괄호 문자열"이라면
                brackets.push(u + v);
            }
        }
        return brackets.pop();
    }
    
    // 4-4 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집는다.
    String reverseBracket(String bracket) {
        if(bracket.equals("")) return "";
        
        StringBuilder rBracket = new StringBuilder();
        for(int i=1; i<bracket.length()-1; i++) {
            rBracket.append((bracket.charAt(i) == '(')? ")" : "(");
        }
        return rBracket.toString();
    }
}