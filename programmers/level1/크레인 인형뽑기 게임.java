// https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int heigth = board.length;
        int[] loc = new int[board[0].length];
        Stack<Integer> bucket = new Stack<>();
        
        for(int[] b : board) {
            for(int i = 0; i < b.length; i++) {
                if (b[i] > 0) {
                    loc[i]++;
                }
            }
        }
        
        for(int move : moves) {
            move--;
            if (loc[move] > 0) {
                if (!bucket.isEmpty() && (bucket.peek() == board[heigth - loc[move]][move])) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(board[heigth - loc[move]][move]);
                }
                loc[move]--;
            }
        }
            
        return answer;
    }
}