// https://programmers.co.kr/learn/courses/30/lessons/12903

class Solution {
  public String solution(String s) {
      int leng = s.length();
      String answer = leng%2 == 1? s.substring(leng/2, leng/2+1) : s.substring(leng/2-1, leng/2+1);
      return answer;
  }
}