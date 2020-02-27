// https://programmers.co.kr/learn/courses/30/lessons/17682

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
  public int solution(String dartResult) {
      String[] scoreStr = new String[3];
      int[] score = new int[3];
      int answer = 0;
      Pattern pattern = Pattern.compile("(\\d+[SDT][*#]?)");
      Matcher matcher = pattern.matcher(dartResult);
      // 문자열 분리(group) -> String 배열에 넣기
      for(int i=0; matcher.find(); i++) {
          //System.out.println(matcher.group());
          scoreStr[i] = matcher.group();
      }
      // 3개의 점수에 대한 계산 처리
      for(int i=0; i<3; i++) {
          int k=0;
          if(scoreStr[i].charAt(1) >= '0' && scoreStr[i].charAt(1) <= '9' ) {
              score[i] = (scoreStr[i].charAt(0)-'0')*10 + scoreStr[i].charAt(1)-'0';
              k = 2;
          } else {
              score[i] = scoreStr[i].charAt(0)-'0';
              k = 1;
          }
          switch(scoreStr[i].charAt(k)) {
              case 'S':
                  break;
              case 'D':
                  score[i] = score[i]*score[i];
                  break;
              case 'T':
                  score[i] = score[i]*score[i]*score[i];
                  break;
              default:   
          }
          k++;
          if(scoreStr[i].length()>k) {
             if(scoreStr[i].charAt(k) == '*') {
                 score[i] *= 2;
                 if(i!=0) score[i-1] *= 2;
             } else if(scoreStr[i].charAt(k) == '#') {
                 score[i] *= -1;
             }
          }
      }
      // 합계
      for(int sum : score) answer += sum;
      return answer;
  }
}