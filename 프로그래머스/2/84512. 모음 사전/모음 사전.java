import java.util.*;
class Solution {
    int cnt;
    int answer;
    public int solution(String word) {
        answer = 0;
        String str = "AEIOU";
        cnt = 0;
        dfs(str, "", word);
        return answer;
    }
    public void dfs(String str, String s, String word) {
        if(s.length() == 5) return ;
        
        for(int i = 0; i < str.length(); i++) {
            String temp = s + str.charAt(i);
            cnt++;
            if(temp.equals(word)) answer = cnt;
            dfs(str, temp, word);
        }
    }
}