// https://programmers.co.kr/learn/courses/30/lessons/12946

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> answer = new ArrayList<>();
        
        int[][] oddRoutine = new int[][]{{1, 3}, {0, 0}, {3, 2}, {0, 0}, {2, 1}, {0, 0}};
        int[][] evenRoutine = new int[][]{{1, 2}, {0, 0}, {2, 3}, {0, 0}, {3, 1}, {0, 0}};
        int[] oddInit = new int[]{1, 3};
        int[] evenInit = new int[]{1, 2};
        
        int[][] routine;
        int[] init;
        
        answer.add(oddInit);
        
        for (int round = 2; round < n+1; round++) {
            ArrayList<int[]> tmp = new ArrayList<>();
            
            if (round % 2 != 0) {
                routine = oddRoutine;
                init = oddInit;
            } else {
                routine = evenRoutine;
                init = evenInit;
            }
            
            tmp.add(init);
            
            for (int i = 2; i < Math.pow(2, round); i++) {
                if (i % 2 == 0) {
                    tmp.add(answer.get(0));
                    answer.remove(0);
                } else {
                    tmp.add(routine[i % 6 - 1]);
                }
            }
            answer = tmp;
        }
        
        return toIntArray(answer);
    }

    int[][] toIntArray(ArrayList<int[]> list) {
        int[][] intArr = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            intArr[i] = list.get(i);
        }
        
        return intArr;
    }
}