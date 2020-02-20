// https://programmers.co.kr/learn/courses/30/lessons/12921

class Solution {
  public int solution(int n) {
      int answer = 0;
      int[] check_prime = new int[n+1];
      for(int i=2; i<=n; i++) {
          if(check_prime[i]!=1){
              answer++;
              for(int j=i; j<=n; j=j+i) {
                  check_prime[j] = 1;
              }
          }
      }
      return answer;
  }
}