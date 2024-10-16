import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }
    public int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for(int[] d : dungeons) {
            int p = d[0], q = d[1];
            if(k >= p) {
                d[0] = 10000;
                cnt = Math.max(1 + dfs(k-q, dungeons), cnt);
                d[0] = p;
            }
        }
        return cnt;
    }
}