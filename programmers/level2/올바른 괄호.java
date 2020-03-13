// https://programmers.co.kr/learn/courses/30/lessons/12909

class Solution {
    boolean solution(String s) {
        int check = 0;
        char[] chars = s.toCharArray();
        for(char ch : chars) {
            if(check<0) return false;
            if(ch == '(') check++;
            else check--;
        }
        return check==0;
    }
}