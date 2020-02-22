// https://programmers.co.kr/learn/courses/30/lessons/12948

class Solution {
  public String solution(String phone_number) {
      return "*".repeat(phone_number.length()-4) + phone_number.substring(phone_number.length()-4);
  }
}