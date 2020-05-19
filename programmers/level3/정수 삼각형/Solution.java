// 실패코드

class Solution {
    private int bigNum = 0;
    public int solution(int[][] triangle) {
        dfs(triangle, 0, 0, 7);
        return bigNum;
    }
    private void dfs(int[][] triangle, int i, int j, int sum) {
        if (i == triangle.length - 1) {
            if (sum > bigNum) bigNum = sum;
            return;
        }
        dfs(triangle, i+1, j, sum + triangle[i+1][j]);
        int j2 = (triangle[i+1].length-1 == j)? j-1 : j+1;
        dfs(triangle, i+1, j2, sum + triangle[i+1][j2]);
    }
}