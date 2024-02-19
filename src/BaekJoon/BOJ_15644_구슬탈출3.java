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
import java.util.StringTokenizer;

public class BOJ_15644_구슬탈출3 {

    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb  = new StringBuilder();
    static String[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

            }
        }
    }
}
