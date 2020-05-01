// https://programmers.co.kr/learn/courses/30/lessons/17676

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

class Solution {
  public int solution(String[] lines) {
    int answer = 0;
    // PriorityQueue에 로그의 끝나는 시간을 넣는다.
    // 새로운 로그가 추가될 때마다,
    // 새 로그의 시작 시간이랑 queue의 끝나는 시간을 비교해서 시간이 1초 이상 차이나면 queue에서 뺀다.

    // queue의 최대 크기를 기록해놓고 queue의 사이즈가 0이 되면, 최대 크기를 반환한다.

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    PriorityQueue<Integer> pq = new PriorityQueue();
    int max = 0;

    for (String line : lines) {
      int out = 0;

      String datetime = line.substring(0, 23);
      Float sec = Float.valueOf(line.substring(24, line.length() - 1));
        
      Timestamp original = dateFormat.parse(datetime);
      Integer now = (int) original.getTime();
      Integer later = (int) (now + (sec * 1000L));

//       while (true) {
//         if (pq.isEmpty() && max == 0) {
//           pq.add(later);
//         } else if (pq.peek() - now <= 1000L) {
//           pq.poll();
//           out++;
//         } else {
//           break;
//         }
//       }

//       if (out > max) {
//         max = out;
//       }
        
    }
      
    return answer;
  }
}