// https://programmers.co.kr/learn/courses/30/lessons/12910

import java.util.*;

class Solution {
  public int[] solution(int[] arr, int divisor) {
      int[] answer = new int[arr.length];
      int length = 0;
      for(int num : arr) {
          if(num%divisor == 0){
              answer[length] = num;
              length++;
          }
      }
      if(length == 0) {
          return new int[]{-1};
      }
      answer = Arrays.copyOf(answer, length);
      Arrays.sort(answer);
      return answer;
  }
}