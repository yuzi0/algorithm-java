// https://programmers.co.kr/learn/courses/30/lessons/17676

// 풀이
// PriorityQueue에 로그의 끝나는 시간을 넣는다.
// 새로운 로그가 추가될 때마다, 새 로그의 시작 시간이랑 queue의 끝나는 시간을 비교해서 시간이 1초 이상 차이나면 queue에서 뺀다.
// queue의 최대 크기를 기록해놓고 queue의 사이즈가 0이 되면, 최대 크기를 반환한다.

// 실패 : 63.6점
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;
import java.text.ParseException;

class MaxTraffic {
	public int maxTraffic(String[] lines) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int max = 0;

		System.out.println(Arrays.toString(lines));
		
		for (String line : lines) {
			String datetime = line.substring(0, 23);
			int millisec = (int) (Float.valueOf(line.substring(24, line.length() - 1)) * 1000);
			
			Calendar cal = Calendar.getInstance();
			Timestamp original = convertStringToTimestamp(datetime, formatter);
			cal.setTimeInMillis(original.getTime());
			Long now = (new Timestamp(cal.getTime().getTime())).getTime();
			
			cal.add(Calendar.MILLISECOND, millisec);
			Long later = (new Timestamp(cal.getTime().getTime())).getTime();
			
			System.out.println("Now " + now + " : " + datetime);
			System.out.println("Aft " + later + " : " + millisec);
			
			while (true) {
				if ((pq.isEmpty()) || (Math.abs(pq.peek() - now) < 999)) {
					break;
				}
				pq.poll();
			}

			pq.add(later);

			if (pq.size() > max) {
				max = pq.size();
			}
		}

		System.out.println();
		return max;
	}

	public static Timestamp convertStringToTimestamp(String str_date, SimpleDateFormat formatter) {
		try {
			Date date = formatter.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
			return timeStampDate;

		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}
}