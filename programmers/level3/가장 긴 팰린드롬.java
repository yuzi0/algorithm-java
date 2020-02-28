// https://programmers.co.kr/learn/courses/30/lessons/12904

class Solution
{
    public int solution(String s)
    {
        char[] chr = s.toCharArray();
        for (int leng = s.length(); leng > 1; leng--) {
            for (int start = 0; start + leng <= s.length(); start++) {
                boolean chk = true;
                for (int i = 0; i < leng/2; i++) {
                    if (chr[start + i] != chr[start + leng  - i - 1]) {
                        chk = false;
                        break;
                    }
                }
                if (chk) return leng;
            }
        }
        return 1;
    }
}