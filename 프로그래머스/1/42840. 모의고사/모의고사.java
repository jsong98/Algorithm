import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i1++]) a1++;
            if(answers[i] == p2[i2++]) a2++;
            if(answers[i] == p3[i3++]) a3++;
            if(i1 == p1.length) i1 = 0;
            if(i2 == p2.length) i2 = 0;
            if(i3 == p3.length) i3 = 0;
        }
        int max = Math.max(a1, Math.max(a2, a3));
        if(a1 == max) answer.add(1);
        if(a2 == max) answer.add(2);
        if(a3 == max) answer.add(3);
        
        return answer;
    }
}