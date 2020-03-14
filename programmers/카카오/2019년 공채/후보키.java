// https://programmers.co.kr/learn/courses/30/lessons/42890

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public ArrayList<ArrayList<Integer>> candidateKeys = new ArrayList<>();
    public String[][] table;
    
    public int solution(String[][] relation) {
        table = relation;
        int n = relation[0].length;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        
        for (int i = 1; i <= n ;i++) {
            combination(arr, new boolean[n] , 0, n, i);
        }
        
        return candidateKeys.size();
    }
    
    void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            checkMinimality(arr, visited, n);
            return;
        
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    void checkMinimality(int[] arr, boolean[] visited, int n) {
        HashSet<Integer> key = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                key.add(i);
        }
        
        // 기존의 candidateKey와 같은 원소가 있는지 확인하기
        for (ArrayList<Integer> candidateKey : candidateKeys) {
            n = 0;
            for (Integer tuple : candidateKey) {
                if (key.contains(tuple)) 
                    n++;
            }

            if (n == candidateKey.size()) {
                return;
            }
        }
        
        // 유일성 확인
        if (checkUniqueness(key)) {
            addCandidateKey(key);
        }
    }
    
    boolean checkUniqueness(HashSet<Integer> key) {
        HashSet<String> tmp = new HashSet<String>();
        
        for (int i = 0; i < table.length; i++) {
            StringBuilder tmpStr = new StringBuilder();
            
            for (Integer tuple : key) {
                tmpStr.append(table[i][tuple]);
            }
            
            // 해당 복합키가 유일한지 확인하기
            if (tmp.contains(tmpStr.toString())) {
                return false;
            }
            
            tmp.add(tmpStr.toString());
        }
        
        return true;
    }
    
    void addCandidateKey(HashSet<Integer> key) {
        ArrayList<Integer> candidateKey = new ArrayList<Integer>();
        
        for (Integer tuple : key) {
            candidateKey.add(tuple);
        }
        
        candidateKeys.add(candidateKey);
    }
}