// https://programmers.co.kr/learn/courses/30/lessons/42578

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> type = new HashMap<>();
        for(String[] cloth : clothes) {
            type.put(cloth[1], type.containsKey(cloth[1])? type.get(cloth[1]) + 1 : 1);
        }
        for (int value : type.values()) {
            answer *= (value+1);
        }
        return answer - 1;
    }
}