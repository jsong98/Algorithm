import java.util.*;
class Solution {
    static List<String> answer;
    static int total;
    static boolean isEnd;
    public List<String> solution(String[][] tickets) {
        answer = new ArrayList<String>();
        isEnd = false;
        total = tickets.length+1;
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                for(int i = 0; i < 3; i++) {
                    if(s1[1].charAt(i) != s2[1].charAt(i)) return s1[1].charAt(i) - s2[1].charAt(i);
                }
                return -1;
            }
        });
        List<String> pathes = new ArrayList<>();
        pathes.add("ICN");
        dfs(tickets, new boolean[tickets.length], pathes, "ICN");
        
        return answer;
    }
    
    public void dfs(String[][] tickets, boolean[] visited, List<String> pathes, String current) {
        if(isEnd) return;
        if(pathes.size() == total) {
            isEnd = true;
            for(int i = 0; i < pathes.size(); i++) {
                answer.add(pathes.get(i));
            }
            return ;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(visited[i]) continue;
            if(!tickets[i][0].equals(current)) continue;
            
            visited[i] = true;
            String dest = tickets[i][1];
            pathes.add(dest);
            dfs(tickets, visited, pathes, dest);
            
            visited[i] = false;
            pathes.remove(pathes.size()-1);
        }
    }
}