// https://programmers.co.kr/learn/courses/30/lessons/12932

class Solution {
  public int[] solution(long n) {
      String num = Long.toString(n);
      int[] answer = new int[num.length()];
      for(int i=0; i<num.length(); i++) { 
          answer[i] = num.charAt(num.length()-i-1)-48; 
      }
      return answer;
  }
}