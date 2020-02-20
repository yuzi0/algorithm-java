// https://programmers.co.kr/learn/courses/30/lessons/42840

class Solution {
    public int[] solution(int[] answers) {
        int[] man1 = {1, 2, 3, 4, 5};
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int man1_num = 0;
        int man2_num = 0;
        int man3_num = 0;
        
        for(int i=0; i<answers.length; i++) {
            man1_num += checkAnswer(i, answers[i], man1);
            man2_num += checkAnswer(i, answers[i], man2);
            man3_num += checkAnswer(i, answers[i], man3);
        }
        System.out.println(man1_num + " : " + man2_num + " : " + man3_num);
        
        return isSame(man1_num, man2_num, man3_num);
    }
    int checkAnswer(int i, int answer, int[] man){
        int num = i%man.length;
        if(answer == man[num]) return 1;
        return 0;
    }
    int[] isSame(int man1_num, int man2_num, int man3_num) {
        if(man1_num > man2_num && man1_num > man3_num ) return new int[]{1};
        if(man1_num < man2_num && man3_num < man2_num ) return new int[]{2};
        if(man1_num < man3_num && man2_num < man3_num ) return new int[]{3};
        if(man1_num == man2_num && man3_num == man2_num)return new int[]{1, 2, 3};
        if(man1_num == man2_num)                        return new int[]{1, 2};
        if(man3_num == man2_num)                        return new int[]{2, 3};
        if(man3_num == man1_num)                        return new int[]{1, 3};
        return null;
    }
}