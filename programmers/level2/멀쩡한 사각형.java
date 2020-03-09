// https://programmers.co.kr/learn/courses/30/lessons/62048

class Solution {
	public long solution(long w, long h) {
		return w * h - (w + h - gcd(w, h));
	}
    long gcd(long x, long y) {
        if(y==0)    return x;
        else        return gcd(y, x%y);
    }
}