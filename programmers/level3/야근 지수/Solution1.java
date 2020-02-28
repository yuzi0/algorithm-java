// https://programmers.co.kr/learn/courses/30/lessons/12927#
/*
    정확성 테스트 1번 실패
    효율설 테스트 1, 2번 실패
 */
 
import java.util.Arrays;

class Solution1 {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        
        int i = works.length - 1;
        
        while (n > 0) {
            if (finishWork(works)) return 0;
            
            if (i <= 0) {
                Arrays.sort(works);
                i = works.length - 1;
                continue;
            } else if (works[i] == works[i-1]) {
                works[i]--;
                n--;
                if (n > 0) {
                    works[i-1]--;
                    n--;
                }
            } else if (n >= works[i] - works[i-1]) {
                n -= works[i] - works[i-1];
                works[i] = works[i-1];
                
                i = 0;
                continue;
            } else {
                works[i] -= n;
                n = 0;
            }
            i--;
        }
        return getTiredness(works);
    }
    
    boolean finishWork(int[] works) {
        for (int work : works) {
            if (work > 0) return false;
        }
        return true;
    }
    
    int getTiredness(int[] works) {
        int sum = 0;
        for (int work : works) {
            sum += work * work;
        }
        return sum;
    }
}