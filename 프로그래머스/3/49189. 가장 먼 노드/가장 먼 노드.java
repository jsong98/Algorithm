import java.util.*;
class Solution {
    List<List<Integer>> list;
    boolean[] visited;
    int[] record;
    int cnt;
    public int solution(int n, int[][] edge) {
        list = new ArrayList<>();
        record = new int[n+1];
        int MAX_VALUE = Integer.MAX_VALUE;
        Arrays.fill(record, MAX_VALUE);
        record[1] = 0;
        cnt = 0;
        for(int i =0; i <= n; i++) list.add(new ArrayList<>());
        for(int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        dfs(1, 1);
        int max = -1;
        // System.out.println(Arrays.toString(record));
        for(int i = 2; i < record.length; i++) {
            if(record[i] == MAX_VALUE) continue;
            if(record[i] > max) {
                cnt = 1;
                max = record[i];
            } else if(record[i] == max) {
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int n, int move) {
        List<Integer> temp = list.get(n);
        for(int i : temp) {
            if(move < record[i]) {
                record[i] = move;
                dfs(i, move+1);
            }
        }
    }
}