import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 2; i <= total; i++) {
            if(total % i == 0) {
                list.add(i);
            }
        }
        for(int i = list.size()-2; i >= 0; i--) {
            int x = list.get(i);
            int y = total / x;
            System.out.println(x + " " + y);
            if( x >= y && (x-2)*(y-2)==yellow) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        return answer;
    }
}