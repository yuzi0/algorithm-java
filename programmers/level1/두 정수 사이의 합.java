// https://programmers.co.kr/learn/courses/30/lessons/12912

class Solution {
  public long solution(int a, int b) {
      long answer = 0;
      int big = a>b? a:b;
      int small = a<b? a:b;
     
      for(int i=small; i<=big; i++) {
          answer += i;
      }
      return answer;
  }
}