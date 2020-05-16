// https://programmers.co.kr/learn/courses/30/lessons/17678#
// 66.7점
// 3, 5, 7, 13, 19, 22, 23, 24 실패

import java.util.Arrays;

public class Solution {
	public String solution(int n, int t, int m, String[] timetable) {
        String answer;
		String busTime = "09:00";
		int wating = 0;
		
		Arrays.sort(timetable);

		for (int i = 0, j = 0; i < timetable.length; i++) {
			if (timetable[i].compareTo(busTime) <= 0) {
				wating++;
			} else if (j < n-1) {
				wating = 0;
				i--;
				j++;
				busTime = getBusTime(j, t);
			}
		}

        if (wating >= m) {
            answer = before1min(timetable[timetable.length - 1 - (wating - m)]);
        } else {
            answer = busTime;
        }

		return answer;
	}

	String getBusTime(int i, int t) {
		StringBuilder time = new StringBuilder();

		int hour = 9;
		int minute = i * t;
		if (minute >= 60) {
			hour += minute / 60;
			minute = minute % 60;
		}

		time.append((hour >= 10) ? hour : "0" + hour);
		time.append(":");
		time.append((minute >= 10) ? minute : "0" + minute);

		return time.toString();
	}

	String before1min(String time) {
		StringBuilder before1min = new StringBuilder();
		String[] t = time.split(":");

		int hour = Integer.parseInt(t[0]);
		int minute = Integer.parseInt(t[1]) - 1;
		if (minute < 0) {
			hour--;
			minute = 59;
		}

		before1min.append((hour >= 10) ? hour : "0" + hour);
		before1min.append(":");
		before1min.append((minute >= 10) ? minute : "0" + minute);

		return before1min.toString();
	}
}