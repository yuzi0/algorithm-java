// https://programmers.co.kr/learn/courses/30/lessons/43164
// 작성 중

import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    ArrayList<String[][]> routes;
    
    public String[] solution(String[][] tickets) {
        int num = tickets.length;
        String[] answer = new String[num + 1];
        String[][] route = new String[num][2];
        boolean[] visited = new boolean[num];
        
        routes  = new ArrayList<String[num][2]>
    
        permutation(tickets, route, visited, 0);

        answer[0] = routes[0][0];
        for (int i = 0; i < routes.length; i++) {
            answer[i+1] = routes[i][1];
            System.out.println(Arrays.toString(routes[i]));
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    String[][] permutation(String[][] list, String[][] output, boolean[] visited, int depth) {
		if ( depth == list.length && checkLine(output) ) {
            return output;
        }
        
		for (int i = 0; i < list.length; i++) {
			if ( !visited[i] ) {
				visited[i] = true;
				output[depth] = list[i];
				permutation(list, output, visited, depth + 1);
				visited[i] = false;
			}
		}
        
        return output;
	}
    
    boolean checkLine(String[][] tickets) {
        for (int i = 0; i < tickets.length - 1; i++) {
            if (tickets[i][1] != tickets[i+1][0]) {
                return false;
            }
        }
        
        return true;
    }
}