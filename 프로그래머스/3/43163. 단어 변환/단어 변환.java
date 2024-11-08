import java.util.*;
class Solution {
    static int min;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        min = Integer.MAX_VALUE;
        dfs(words, new boolean[words.length], target, begin, 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public void dfs(String[] words, boolean[] visited, String target, String current, int cnt) {
        if(current.equals(target)) {
            if(cnt < min) min = cnt;
            return ;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            if(!check(words[i], current)) continue;
            visited[i] = true;
            dfs(words, visited, target, words[i], cnt+1);
            visited[i] = false;
        }
    }
    
    public boolean check(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        
        return cnt == 1 ? true : false;
    }
}