import java.util.*;
import java.lang.Math;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 0; i < progresses.length; i++) {
            int k = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            que.offer(k);
        }
        
        List<Integer> answer = new ArrayList<Integer>();
        int t = 0;
        while(!que.isEmpty()) {
            int k = que.peek();
            int temp = 0;
            while(k <= t) {
                temp++;
                que.poll();
                if(que.isEmpty()) {
                    answer.add(temp);
                    break;
                }
                k = que.peek();
                if(k > t) {
                    System.out.println(temp);
                    answer.add(temp);
                }
                
            }
            
            t++;
        }
        
        return answer;
    }
}