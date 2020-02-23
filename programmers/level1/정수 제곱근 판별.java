// https://programmers.co.kr/learn/courses/30/lessons/12934

import java.lang.Math;
class Solution {
  public long solution(long n) {
      long num = (long)Math.sqrt(n);
      return num*num==n? (num+1)*(num+1) : -1;
  }
}