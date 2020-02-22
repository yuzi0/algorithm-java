// https://programmers.co.kr/learn/courses/30/lessons/12926

class Solution {
  public String solution(String s, int n) {
      String answer = "";
      // 65 A - 90 Z
      // 97 a - 122 z
      
      for(int i=0; i<s.length(); i++) {
          int temp =  s.charAt(i);
          if(temp>=65 && temp<=90) {
              temp = temp+n<=90? temp+n : temp+n-26;
          } else if(temp>=97 && temp<=122) {
              temp = temp+n<=122? temp+n : temp+n-26;
          }
          answer += (char)temp;
      }
      return answer;
  }
}