// https://programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
  public boolean solution(int x) {
    String nums = Integer.toString(x);
    int sum = 0;
    for(int i=0; i<nums.length(); i++) {
        sum += nums.charAt(i) - '0';
    }
    return x%sum==0;
  }
}