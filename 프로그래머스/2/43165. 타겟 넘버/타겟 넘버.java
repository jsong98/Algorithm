class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, new boolean[numbers.length], 0, target);
        return answer;
    }
    public void dfs(int[] numbers, boolean[] visited, int depth, int target) {
        if(depth == numbers.length) {
            int num = 0;
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    num += numbers[i];
                    continue;
                }
                num -= numbers[i];
            }
            if(num == target) answer++;
            return ;
        }
        
        visited[depth] = true;
        dfs(numbers, visited, depth + 1, target);
        visited[depth] = false;
        dfs(numbers, visited, depth + 1, target);
    }
}