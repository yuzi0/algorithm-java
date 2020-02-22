// https://programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      StringBuilder tempStr = new StringBuilder("");
      int tempNum1;
      int tempNum2;
      
      for(int i=0; i<n; i++) {
          tempStr = new StringBuilder("");
          tempNum1 = arr1[i];
          tempNum2 = arr2[i];
          for(int j=0; j<n; j++) {
              if(tempNum1%2 == 1 || tempNum2%2 == 1 ) tempStr.insert(0,  "#");
              else tempStr.insert(0, " ");
              tempNum1 = tempNum1/2;
              tempNum2 = tempNum2/2;
              //tempNum1 = tempNum1 >> 1;
              //tempNum2 = tempNum2 >> 1;
          }
          answer[i] = tempStr.toString();
      }
      return answer;
  }
}