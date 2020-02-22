// https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;
class Solution { 
    public String[] solution(String[] strings, int n) { 
        ArrayList<String> list = new ArrayList<>(); String[] answer; 
        for(int i=0;i<strings.length;i++) { 
            list.add(strings[i].charAt(n)+strings[i]);
        } 
        Collections.sort(list); 
        answer = new String[list.size()]; 
        for(int i=0;i<list.size();i++) { 
            answer[i] = list.get(i).substring(1, list.get(i).length()); 
        } 
        return answer; 
    } 
}