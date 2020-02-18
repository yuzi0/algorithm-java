// https://programmers.co.kr/learn/courses/30/lessons/42862

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length; i++){
            n--;
            if(Arrays.binarySearch(reserve, lost[i]) >= 0) {
                reserve[Arrays.binarySearch(reserve, lost[i])] = -1;
                lost[i] = -1;
                n++;
            }
        }
        Arrays.sort(reserve);

        for(int los : lost){
        	if(los != -1) {
                if(Arrays.binarySearch(reserve, los-1) >= 0) {
                    reserve[Arrays.binarySearch(reserve, los-1)] = -1;
                    n++;
                }else if(Arrays.binarySearch(reserve, los+1) >= 0) {
                    reserve[Arrays.binarySearch(reserve, los+1)] = -1;
                    n++;
                }

        	}

        }
        return n;
    }
}
