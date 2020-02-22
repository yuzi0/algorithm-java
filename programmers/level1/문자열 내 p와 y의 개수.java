// https://programmers.co.kr/learn/courses/30/lessons/12916

class Solution {
    boolean solution(String s) {
        int check = 0;
        for(int i=0; i<s.length(); i++) {
            char chr = s.charAt(i);
            if(chr == 'P' || chr == 'p') { check++; }
            else if(chr == 'Y' || chr == 'y') { check--; }
        }
        return check==0;
    }
}