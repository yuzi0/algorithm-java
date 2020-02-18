// https://programmers.co.kr/learn/courses/30/lessons/12901

class Solution {
  public String solution(int a, int b) {
      int day_int = 0;
      String[] day_str = new String[] {"SUN","MON","TUE","WED","THU","FRI","SAT"};
      int[] month_day = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
      int num = 0;
      for(int i=1; i<a; i++){
          num += month_day[i-1];
      }
      num += b;
      day_int = (num + 4) % 7;

      return day_str[day_int];
  }
}
