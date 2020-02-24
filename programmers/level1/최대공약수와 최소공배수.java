// https://programmers.co.kr/learn/courses/30/lessons/12940

class Solution {
  public int[] solution(int n, int m) {
      int answer = 0;
      for(int i=1; i<(n>m?n:m); i++) {
          if((n%i == 0)&&(m%i == 0)&&(i>answer)) {
              answer=i;
          }
      }
      return new int[] {answer, n*m/answer};
  }
}