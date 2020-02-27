// https://programmers.co.kr/learn/courses/30/lessons/12945

class Solution {
  int[] data = new int[100_101];
  public int solution(int n) {
      return fibo(n);
  }
  public int fibo(int n) {
      if(n<=2) return 1;
      if(data[n]!=0) return data[n];
      return data[n] = (fibo(n-2)+fibo(n-1))%1234567;
  }
}