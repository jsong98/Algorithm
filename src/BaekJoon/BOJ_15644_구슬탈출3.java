package BaekJoon;

/*
input
 . : 빈칸
 # : 장애물
 o : 구멍위치
 R : 빨간 구슬
 B : 파란 구슬
+가장 자리는 전부 #

output
첫째줄: 최소 몇번 만에 빨간 공을 구멍을 통해 빼낼 수 있는지,
둘째줄: 어떻게 기울여야 하는지 순서대로(LRUD)
+10번 이하로 못빼내면 -1


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15644_구슬탈출3 {

    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb  = new StringBuilder();
    static String[][] map;
    static int[] dr = {-1,0,1,0};   // {0, 1, 2, 3} == {상, 우, 하, 좌}
    static int[] dc = {0,1,0,-1};
    static Queue<Balls> que;

    static class Balls {
        int rr;
        int rc;
        int br;
        int bc;
        String move;
        int from ;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        Balls balls = new Balls();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if(map[i][j].equals("R")) {
                    balls.rr = i;
                    balls.rc = j;
                }else if(map[i][j].equals("B")) {
                    balls.br = i;
                    balls.bc = j;
                }
            }
        }   // input

        balls.from = -1;    // 아직 안움직여서 마지막 방향 -1로 초기화
        que = new LinkedList<>();
        que.offer(balls);
        
        while(!que.isEmpty()) {
            Balls b = que.poll();

            for (int i = 0; i < 4; i++) {
                if(b.from == i) continue;
            }
        }

    }

    public static void move(Balls balls, int dir) {
        int nrr = balls.rr;
        int nrc = balls.rc;
        int nbr = balls.br;
        int nbc = balls.bc;
        if(dir == 0) {  // 위
            if(nrr < nbr) { // red가 blue보다 위에 있는 경우
                while (!map[nrr][nrc].equals("#")) {
                    nrr--;
                    if(map[nrr][nrc].equals("O")) {

                    }
                }
                nrr++;
                while (!map[nbr][nbc].equals("#")) {
                    nbr--;
                    if(map[nrr][nrc].equals("O")) {

                    }
                    if(nrr == nbr && nrc ==nbc) break;
                }
                nbr++;
            } else {
                
            }
        } else if (dir == 1) {  // 오른쪽
            if(nrc > nbc) { // red가 blue보다 오른쪽에 있는 경우
                
            } else {
                
            }
        } else if (dir == 2) {  // 아래
            if (nrr > nbr) { // red가 blue보다 아래에 있는 경우
                
            } else {
                
            }
        } else {    // 왼쪽
            if (nrc < nbc) { // red가 blue보다 왼쪽쪽에 있는 경우
                
            } else {
                
            }
        }
    }
}
