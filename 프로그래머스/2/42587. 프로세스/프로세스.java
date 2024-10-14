import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] arr = new int[10];    // 1~9까지의 우선순위 중 어떤 우선순위가 몇 개 남았는지 체크하는 배열
        int highest = -1;           // 큐 안에 남은 프로세스 중 가장 높은 우선순위
        int position = location;    // 큐 내에서 target의 위치
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int i = 0; i < priorities.length; i++) {
            arr[priorities[i]]++;
            que.offer(priorities[i]);
        }
        highest = getHighest(arr);

        while(true) {
            int k = que.poll();
            if(k == highest) {
                answer++;                           // 프로세스 처리
                if(position == 0) return answer;    // 가장 우선순위가 높은 것이면서, target이면 return
                position--;                         // target의 위치 조정
                arr[k]--;                         
                highest = getHighest(arr);
            } else {
                que.offer(k);
                position = position == 0 ? que.size()-1 : position - 1;
            }
        }
        
        // return answer;
    }
    public int getHighest(int[] arr) {
        for(int i = arr.length-1; i > 0; i--) {
            if(arr[i] != 0) return i;
        }
        return 0;
    }
}