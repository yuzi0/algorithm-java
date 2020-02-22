// https://programmers.co.kr/learn/courses/30/lessons/12943

class Solution {
  public int solution(long num) {
      int i;
      for(i = 0; i < 500; i++) {
          if(num==1) return i;
          num = (num%2==0)? num/2 : num*3+1;
      }
      return -1;
  }
}