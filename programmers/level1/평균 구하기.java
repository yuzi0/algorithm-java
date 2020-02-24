// https://programmers.co.kr/learn/courses/30/lessons/12944

class Solution {
  public double solution(int[] arr) {
      double answer = 0;
      for(int data : arr) answer += data;
      return answer/arr.length;
  }
}