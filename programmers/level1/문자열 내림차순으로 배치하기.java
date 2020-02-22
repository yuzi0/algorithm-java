// https://programmers.co.kr/learn/courses/30/lessons/12917

import java.util.Arrays;
import java.util.Collections;

class Solution {
  public String solution(String s) {
      String[] arr = s.split("");
      Arrays.sort(arr, Collections.reverseOrder());
      return String.join("", arr);
  }
}