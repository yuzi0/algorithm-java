// https://programmers.co.kr/learn/courses/30/lessons/12935

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[] solution(int[] arr) {
      List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList()); // int[] to List<Integer>
      list.remove(Collections.min(list)); // remove minimal number
      return list.size()!=0?list.stream().mapToInt(Integer::intValue).toArray():new int[]{-1}; // List<Integer> to int[]
  }
}