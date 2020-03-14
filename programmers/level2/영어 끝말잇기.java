// https://programmers.co.kr/learn/courses/30/lessons/12981

import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        // HashSet
        HashMap<String, Integer> word = new HashMap<String, Integer>();
        word.put(words[0], 0);
        for(int i=1; i<words.length; i++) {
            if((words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)) || 
               (word.containsKey(words[i])))
                return new int[] {i%n+1, i/n+1};
            word.put(words[i], 0);
        }
        return new int[] {0,0};
    }
}