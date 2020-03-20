// https://programmers.co.kr/learn/courses/30/lessons/17684

import java.util.HashMap;
import java.util.ArrayList;

class Solution {
  public int[] solution(String msg) {
      ArrayList<Integer> answer = new ArrayList<Integer>();
      HashMap<String , Integer> map = new HashMap<String , Integer>();
      for(char i='A'; i<='Z'; i++) {
          map.put(Character.toString(i), i-'A'+1);
      }
      for(int i=0; i<=msg.length(); i++) {
          for(int j=1; j+i<=msg.length(); j++) {
              if(!map.containsKey(msg.substring(i, i+j))) {
                  map.put(msg.substring(i, i+j), map.size()+1);
                  answer.add(map.get(msg.substring(i, i+j-1)));
                  i = i + j - 1;
                  break;
              }
          }
          if(map.containsKey(msg.substring(i, msg.length()))) {
              answer.add(map.get(msg.substring(i, msg.length())));
              break;
          }
          i--;
      }
      return convertIntegers(answer);
  }
    
  int[] convertIntegers(ArrayList<Integer> integers) {
    int[] ret = new int[integers.size()];
    for(int i=0; i<integers.size(); i++) {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
  }
}