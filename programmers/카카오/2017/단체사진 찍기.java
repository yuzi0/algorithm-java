// https://programmers.co.kr/learn/courses/30/lessons/1835

import java.util.Arrays;

class Solution {
  public String[] datas;
  public int leng = 8;
  public int num = 0;
    
  public int solution(int n, String[] data) {
      char[] list = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
      char[] output = new char[8];
      boolean[] visited = new boolean[8];

      datas = data;

      permutation(list, output, visited, 0); 

      return num;
  }
    
    void permutation(char[] list, char[] output, boolean[] visited, int depth) {
		if ( depth == leng && checkData(output) ) {
            num++;
            return;
        }
        
		for (int i = 0; i < leng; i++) {
			if ( !visited[i] ) {
				visited[i] = true;
				output[depth] = list[i];
				permutation(list, output, visited, depth + 1);
				visited[i] = false;
			}
		}
	}
    
    boolean checkData(char[] list) {
        for ( String data : datas ) {
            char chr1 = data.charAt(0);
            char chr2 = data.charAt(2);
            int compareN = data.charAt(4) - '0';
            int N = getDistance(list, chr1, chr2);
            
            
            switch ( data.charAt(3) ) {
                case '=':
                    if ( N == compareN ) continue;
                    break;
                case '<':
                    if ( N < compareN ) continue;
                    break;
                case '>':
                    if ( N > compareN ) continue;
                    break;
            }
            return false;
            
        }
        return true;
    }
    
    int getDistance(char[] list, char chr1, char chr2) {
        int distance = -1;
        
        for (int i = 0; i < leng; i++) {
            if ( distance != -1 ) distance++;
            
            if ( list[i] == chr1 || list[i] == chr2 ) {
                if ( distance == -1 ) distance++;
                else break;
            }
        }
        
        return distance-1;
    }
}