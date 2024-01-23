package BaekJoon;

/*
1. 로봇이 위치한 칸 청소
2. 현재 주변 4칸 중 청소되지 않은 빈칸이 없는 경우,
    바라보는 방향 그대로 후진 가능하면 후진하고 1번으로 ㄱ
    바라보는 방향의 뒤쪽 칸이 벽이어서 후진 못하면 작동 멈춤
3. 현재 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    1. 반시계 방향으로 90도 회전
    2. 바라보는 방향 기준으로 앞쪽 칸이 청소되지 않은 칸인 경우 한칸 전진
    3. 1번으로 ㄱ

0:북/1:동/2:남/3:서

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

57

7 7
4 2 1
1 1 1 1 1 1 1
1 0 0 0 1 0 1
1 0 1 1 0 0 1
1 0 0 0 0 1 1
1 0 0 1 0 0 1
1 0 0 0 0 0 1
1 1 1 1 1 1 1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr  = {-1,0,1,0};
    static int[] dc  = {0,1,0,-1};

    static class Pos {
        int r;
        int c;
        int d;

        public Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        Pos p = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (map[p.r][p.c] == 0) {   // 첫 위치는 바로 청소
            res++;
            visited[p.r][p.c] = true;
        }
        
        boolean flag;   // 주위에 청소되지 않은 빈칸이 있는지 없는지 판별
        while (true) {
            flag = false;
            for (int i = 0; i < 4; i++) {   // 주위 4방 탐색
                int tr = p.r + dr[i];
                int tc = p.c + dc[i];
                if(map[tr][tc] == 1) continue;  // 체크한 곳이 벽이면 넘어감
                if(!visited[tr][tc]) {  // 청소되지 않은 곳이 있는 경우
                    flag = true;
                }
            }

            if (flag) { // 주위에 청소되지 않은 빈 칸이 있는 경우
                while (true) {
                    p.d = (p.d+3)%4; // 반시계 방향으로 90도 회전
                    int nr = p.r + dr[p.d];
                    int nc = p.c + dc[p.d];  // 새로 갈 위치
                    if(map[nr][nc] == 1 || visited[nr][nc]) continue;   // 벽이거나 청소된 곳이면 넘어감
                    p.r = nr;
                    p.c = nc;   // 해당 방향으로 한 칸 전진
                    visited[p.r][p.c] = true;   // 청소함
                    res++;
                    break;
                }
            } else {    // 없는 경우
                p.r = p.r - dr[p.d];
                p.c = p.c - dc[p.d];    // 후진
                if (map[p.r][p.c] == 1) {   // 벽이면 작동 중지
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
