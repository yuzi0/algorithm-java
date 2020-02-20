// https://programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
		int i = 1;
        int temp = arr[0];
        for(int num : arr) {
            if(num != temp){
                arr[i] = num;
                temp = num;
                i++;
            }
        }
        return Arrays.copyOf(arr, i);
	}
}