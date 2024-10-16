import java.util.*;
class Solution {
    int answer;
    int t;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        t = -1;
        boolean[] visited = new boolean[dungeons.length];
        int len = dungeons.length;
        perm(dungeons, new boolean[len], new int[len][2], 0, len, k);
        return answer;
    }
    
    public void perm(int[][] dungeons, boolean[] visited, int[][] arr, int depth, int r, int k) {
        if(depth == r) {
            int count = 0;
            t = k;
            for(int[] dungeon : arr) {
                if(t >= dungeon[0]) {
                    count++;
                    t -= dungeon[1];
                    continue;
                }
                break;
            }
            if(count > answer) answer = count;
            return ;
        }
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = dungeons[i];
                perm(dungeons, visited, arr, depth+1, r, k);
                visited[i] = false;                
            }
        }
    }
}