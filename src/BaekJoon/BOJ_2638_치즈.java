package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2638_치즈 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringBuilder sb = new StringBuilder();
    static class Pos {
        int r;
        int c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int n, m, cheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Queue<Pos> que;
    static List<Pos> temp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }   // intput
        que = new LinkedList<>();
        checkOutside(0, 0);
        int ret = 0;
        while(cheese > 0) {
            visited = new boolean[n][m];
            que = new LinkedList<>();
            temp = new ArrayList<>();

            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        que.add(new Pos(i, j));
                        visited[i][j] = true;
                        bfs();
                    }
                }
            }
            meltDown();
            ret++;
//            System.out.println(cheese);
        }
        System.out.println(ret);
    }

    static void checkOutside(int r, int c) {
        que.add(new Pos(r, c));
        while (!que.isEmpty()) {
            Pos p = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 0) {
                    map[nr][nc] = -1;
                    que.add(new Pos(nr, nc));
                }
            }

        }
    }

    static void meltDown() {
        for (Pos pos : temp) {
            map[pos.r][pos.c] = 0;
            cheese--;
        }
        for(Pos pos : temp) {
            if(map[pos.r][pos.c] == 0) {
                map[pos.r][pos.c] = -1;
                checkOutside(pos.r, pos.c);
            }
        }
    }

    static void bfs() {
        while(!que.isEmpty()) {
            Pos p = que.poll();

            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(map[nr][nc] == -1) {
                    count++;
                }
            }
            if(count >= 2) {
                temp.add(new Pos(p.r, p.c));
            }
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    que.add(new Pos(nr, nc));
                }
            }
        }
    }
}
