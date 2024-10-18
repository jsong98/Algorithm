class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(computers[i], computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int[] computer, int[][] computers) {
        for(int i = 0; i < computer.length; i++) {
            if(computer[i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(computers[i], computers);
            }
        }
    }
}