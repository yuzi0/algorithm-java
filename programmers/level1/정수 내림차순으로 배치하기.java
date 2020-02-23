// https://programmers.co.kr/learn/courses/30/lessons/12933

import java.util.Arrays;
class Solution {
  public long solution(long n) {
      String[] str = Long.toString(n).split("");
      Arrays.sort(str);
      return Long.parseLong(new StringBuilder(String.join("",str)).reverse().toString());
  }
}