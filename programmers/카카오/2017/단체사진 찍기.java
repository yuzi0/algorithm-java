// https://programmers.co.kr/learn/courses/30/lessons/1835

import java.util.LinkedList;

class Solution {
  public int solution(int n, String[] data) {
      int answer = 0;
      LinkedList<Integer> list = new LinkedList<>();
      boolean[] visit = new boolean[8];
      
      // list 1~8까지 채우기
      //for (int i = 0; i < 8; i++) {
      //    list.add(i);
      //}
      
      // 순열
      permutation(list, visit, 8, 8, data, answer); 
      
      return answer;
  }
    
    void permutation(LinkedList<Integer> list, boolean[] visit, int n, int r, String[] data, int rt) {
		if (list.size() == r) { //&& checkData(list, data)) {
            rt++;
            return;
        }
        
		for (int i=0; i<n; i++){
			if (!visit[i]){//이미 뽑은 것은 뽑지 않도록 체크
				visit[i] = true;
				list.add(i);
				permutation(list, visit, n, r, data, rt);
				list.removeLast();//해당 넘버를 다시 제거 (즉,뽑지 않고 다음 번호 뽑기위함)
				visit[i] = false;
			}
		}
	}
    
    boolean checkData(LinkedList<Integer> list, String[] datas) {
        for (String data : datas) {
            char chr1 = data.charAt(0);
            char chr2 = data.charAt(3);
            int n = data.charAt(4) - '0';
            int compareN = checkBetween(list, chr1, chr2);
            
            switch (data.charAt(3)) {
                case '=':
                    if (n != compareN) return false;
                case '<':
                    if (n >= compareN) return false;
                case '>':
                    if (n <= compareN) return false;
            }
        }
        return true;
    }
    
    int checkBetween(LinkedList<Integer> list, char chr1, char chr2) {
        char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        int n = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (n != 0) n++;
            
            if (arr[list.get(i)] == chr1 || arr[list.get(i)] == chr2) {
                if (n == 0) n++;
                else break;
            }
        }
        
        return n;
    }
}