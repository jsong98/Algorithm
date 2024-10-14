import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> que = new LinkedList<Integer>();
        int temp = -1;
        for(int i = 0; i < arr.length; i++) {
            if(temp != arr[i]) que.offer(arr[i]);
            temp = arr[i];
        }
        System.out.println(que.size());
        int[] answer = new int[que.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = que.poll();
        }
        return answer;
    }
}