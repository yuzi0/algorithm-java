// https://programmers.co.kr/learn/courses/30/lessons/64064
// 실패

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

class BadUser {
	public int solution(String[] user_id, String[] banned_id) {
		int answer = 1;
		Arrays.sort(user_id);
		Arrays.sort(banned_id);

		HashMap<String, Integer> hash = new HashMap<String, Integer>();

		for (int i = 0; i < banned_id.length; i++) {
			hash.put(banned_id[i], 0);

			for (int j = 0; j < user_id.length; j++) {
				if (isBanned(banned_id[i], user_id[j])) {
					hash.put(banned_id[i], hash.get(banned_id[i]) + 1);
				}
			}
		}

		Collection<Integer> values = hash.values();
		for (Object value : values.toArray()) {
			if ((int) value > 0) {
				answer *= (int) value;
			}
		}

		return answer;
	}

	public boolean isBanned(String banned_id, String user_id) {
		if (banned_id.length() != user_id.length()) {
			return false;
		}
		
		for (int i = 0; i < banned_id.length(); i++) {
			if (banned_id.charAt(i) != '*' && banned_id.charAt(i) != user_id.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}