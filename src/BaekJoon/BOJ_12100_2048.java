package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12100_2048 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<int[]> cases = new ArrayList<>();
    static int N;
    static int[][] map;
    static int[][] originMap;
    static boolean[][] isCombined;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        originMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }   // input
        backtracking(0, new int[5]);    // 완탐 경우의 수 생성

    }

    static void backtracking(int idx, int[] result) {
        if (idx == 5) {
            int[] temp = new int[5];
            System.arraycopy(result, 0, temp, 0, result.length);
            cases.add(temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            result[idx] = i;
            backtracking(idx + 1, result);
        }
    }

    static void move(int cmd) {
        int w1 = 0;
        int w2 = 0;
        int srt = 0;
        if (cmd == 0) {
            // 아래 -> 위
        }
        if (cmd == 1) {
            // 좌 -> 우
        }
        if (cmd == 2) {
            // 위 -> 아래
        }
        if (cmd == 3) {
            // 우 -> 좌
        }
        for (int r = srt; 0 <= r && r < N; r += w1) {
            for (int c = srt; 0 <= c && c < N; c += w2) {
                if (map[r][c] == 0) continue;
                int nr = r + dr[cmd];
                int nc = c + dc[cmd];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[r][c] == map[nr][nc]) {
                    // 합치고 끝으로 밀기
                    map[nr][nc] += map[r][c];
                    map[r][c] = 0;
                    while (true) {
                        if ((nr - 1) < 0 || map[nr - 1][nc] != 0) break;
                        int temp = map[nr][nc];
                        map[nr][nc] = 0;
                        nr -= 1;
                        map[nr][nc] = temp;
                    }
                } else if (map[nr][nc] == 0) {
                    //밀다가 합치고 끝까지 밀기

                }
            }
        }
    }
}
