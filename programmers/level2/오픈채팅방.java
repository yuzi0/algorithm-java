//https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] record) {
        String[][] recordSplit = new String[record.length][3];
        HashMap<String, String> uid = new HashMap<String, String>();
        ArrayList<String> answer = new ArrayList<String>();
        
        for(int i=0; i<record.length; i++) {
            recordSplit[i] = record[i].split(" ");
            if(!recordSplit[i][0].equals("Leave")) uid.put(recordSplit[i][1], recordSplit[i][2]);
        }
        
        for(int i=0; i<record.length; i++) {
            if(!recordSplit[i][0].equals("Change")) {
                String nickname = uid.get(recordSplit[i][1]);
                answer.add(nickname + (recordSplit[i][0].equals("Enter")? "님이 들어왔습니다." : "님이 나갔습니다."));
            }
        }
        return answer.toArray(new String[0]);
    }
}