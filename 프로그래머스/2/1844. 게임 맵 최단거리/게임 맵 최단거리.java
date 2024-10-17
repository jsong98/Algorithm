import java.util.*;
class Solution {
    class Pos {
        int r;
        int c;
        int cnt;
        Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Pos> que = new LinkedList<>();
        int mr = maps.length;
        int mc = maps[0].length;
        que.offer(new Pos(0,0,1));
        while(!que.isEmpty()) {
            Pos p = que.poll();
            if(p.r == mr-1 && p.c == mc-1) {
                return p.cnt;
            }
            for(int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(nr < 0 || nr >= mr || nc < 0 || nc >= mc) continue;
                if(maps[nr][nc] == 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                que.offer(new Pos(nr, nc, p.cnt+1));
            }
        }
        return -1;
    }
}