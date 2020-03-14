// 실패
// https://programmers.co.kr/learn/courses/30/lessons/42890

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public ArrayList<ArrayList<Integer>> candidateKeys = new ArrayList<>();
    public String[][] table;
    
    public int solution(String[][] relation) {
        int n = relation.length;
        int[] arr = new int[n];
        table = relation;
        
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        
        for (int i = 1; i <= n ;i++) {
            combination(arr, new boolean[n] , 0, n, i);
        }
        return candidateKey.size();
    }
    
    void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            checkMinimality(arr, visited, n);
            return;
        } else {
            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    void checkMinimality(int[] arr, boolean[] visited, int n) {
        // 기존의 candidateKey와 같은 원소가 있는지 확인하기
        HashSet<Integer> hash = new HashSet<Integer>;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                hash.add(i);
        }
        
        for (ArrayList<Integer> candidateKey : candidateKeys) {
            int n = 0;
            for (Integer key : candidateKey) {
                if (hash.isContain(key)) n++;
            }
            if (n == candidateKey.size()) return
        }
        // 여기서 candidateKey에 추가하기
        ArrayList<Integer> candidateKey = new ArrayList<Integer>;
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                candidateKey.add(i);
            }
        }
    
    }
}