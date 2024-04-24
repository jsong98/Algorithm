package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int r, c, max;
    static String[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static class Pos {
        int x;
        int y;
        String s;

        Pos(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        if(r == 1 && c == 1) {
            System.out.println(1);
            return ;
        }
        map = new String[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
        }   // input

        max = Integer.MIN_VALUE;
        dfs(new Pos(0, 0, ""));
        System.out.println(max);
    }

    static void dfs(Pos p) {
        if(p.s.contains(map[p.y][p.x])) {
            if(p.s.length() > max) max = p.s.length();
            return;
        } else {
            p.s += map[p.y][p.x];
        }

        for (int i = 0; i < 4; i++) {
            int nx = p.x+dx[i];
            int ny = p.y+dy[i];
            if(nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
            dfs(new Pos(nx, ny, p.s));
        }
    }
}
