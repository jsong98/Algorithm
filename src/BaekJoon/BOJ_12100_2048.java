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
    static int N, ret;
    static int[][] map;
    static int[][] originMap;
    static int[] dr = {-1, 0, 1, 0};    // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};

    static class Pos {
        int r;
        int c;
        int value;
        boolean isCombined;

        Pos(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        originMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                originMap[i][j] = map[i][j];
            }
        }   // input
        ret = 2;
//        int[] arr = {1,0,1,2,1};
//        for (int i = 0; i < arr.length; i++) {
//            move(arr[i]);
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < N; c++) {
//                    System.out.print(map[r][c] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//        move(0);
        backtracking(0, new int[5]);    // 완탐 경우의 수 생성

        System.out.println(ret);
    }

    static void backtracking(int idx, int[] result) {
        if (idx == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = originMap[i][j];
                }
            }

            for (int i = 0; i < result.length; i++) {
                move(result[i]);
//                System.out.println(result[i]);
//                for (int r = 0; r < N; r++) {
//                    for (int c = 0; c < N; c++) {
//                        System.out.print(map[r][c] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > ret) ret = map[i][j];
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            result[idx] = i;
            backtracking(idx + 1, result);
        }
    }

    static void move(int cmd) {
        boolean[][] combined = new boolean[N][N];
        if (cmd == 0) {
            // 위로 밀착
            for (int c = 0; c < N; c++) {
                for (int r = 0; r < N; r++) {
                    if (map[r][c] == 0) continue;
                    Pos p = new Pos(r, c, map[r][c]);
                    while (true) {
                        int nr = p.r + dr[cmd];
                        int nc = p.c + dc[cmd];

                        // 다음 이동할 좌표가 맵을 벗어나면 break
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }
                        // 이동할 좌표의 value가 0이 아니고, 현재 좌표의 value와 이동할 좌표의 value가 다르면 break
                        if (map[nr][nc] != 0 && map[p.r][p.c] != map[nr][nc]) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }

                        // 다음 좌표의 value가 0인 경우
                        if (map[nr][nc] == 0) {
                            map[nr][nc] = map[p.r][p.c];
                            map[p.r][p.c] = 0;

                        } else if (map[nr][nc] == map[p.r][p.c] && (combined[nr][nc] || p.isCombined)) {
                            combined[p.r][p.c] = true;
                            break;
                        }
                        else if (map[nr][nc] == map[p.r][p.c] && !combined[nr][nc] && !p.isCombined) {
                            // 다음 좌표와 현재 좌표가 같은 경우
                            map[nr][nc] *= 2;
                            map[p.r][p.c] = 0;
                            p.isCombined = true;
                        }
                        p.r = nr;
                        p.c = nc;
                    }
                }
            }
        }
        if (cmd == 1) {
            // 오른쪽으로 밀착
            for (int r = 0; r < N; r++) {
                for (int c = N - 1; c >= 0; c--) {
                    if (map[r][c] == 0) continue;
                    Pos p = new Pos(r, c, map[r][c]);
                    while (true) {
                        int nr = p.r + dr[cmd];
                        int nc = p.c + dc[cmd];

                        // 다음 이동할 좌표가 맵을 벗어나면 break
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }
                        // 이동할 좌표의 value가 0이 아니고, 현재 좌표의 value와 이동할 좌표의 value가 다르면 break
                        if (map[nr][nc] != 0 && map[p.r][p.c] != map[nr][nc]) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }

                        // 다음 좌표의 value가 0인 경우
                        if (map[nr][nc] == 0) {
                            map[nr][nc] = map[p.r][p.c];
                            map[p.r][p.c] = 0;

                        } else if (map[nr][nc] == map[p.r][p.c] && (combined[nr][nc] || p.isCombined)) {
                            combined[p.r][p.c] = true;
                            break;
                        }
                        else if (map[nr][nc] == map[p.r][p.c] && !combined[nr][nc] && !p.isCombined) {
                            // 다음 좌표와 현재 좌표가 같은 경우
                            map[nr][nc] *= 2;
                            map[p.r][p.c] = 0;
                            p.isCombined = true;
                        }
                        p.r = nr;
                        p.c = nc;
                    }
                }
            }
        }
        if (cmd == 2) {
            // 아래로 밀착
            for (int c = N - 1; c >= 0; c--) {
                for (int r = N - 1; r >= 0; r--) {
                    if (map[r][c] == 0) continue;
                    Pos p = new Pos(r, c, map[r][c]);
                    while (true) {
                        int nr = p.r + dr[cmd];
                        int nc = p.c + dc[cmd];

                        // 다음 이동할 좌표가 맵을 벗어나면 break
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }
                        // 이동할 좌표의 value가 0이 아니고, 현재 좌표의 value와 이동할 좌표의 value가 다르면 break
                        if (map[nr][nc] != 0 && map[p.r][p.c] != map[nr][nc]) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }

                        // 다음 좌표의 value가 0인 경우
                        if (map[nr][nc] == 0) {
                            map[nr][nc] = map[p.r][p.c];
                            map[p.r][p.c] = 0;

                        } else if (map[nr][nc] == map[p.r][p.c] && (combined[nr][nc] || p.isCombined)) {
                            combined[p.r][p.c] = true;
                            break;
                        }
                        else if (map[nr][nc] == map[p.r][p.c] && !combined[nr][nc] && !p.isCombined) {
                            // 다음 좌표와 현재 좌표가 같은 경우
                            map[nr][nc] *= 2;
                            map[p.r][p.c] = 0;
                            p.isCombined = true;
                        }
                        p.r = nr;
                        p.c = nc;
                    }
                }
            }
        }
        if (cmd == 3) {
            // 왼쪽으로 밀착
            for (int r = N - 1; r >= 0; r--) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 0) continue;
                    Pos p = new Pos(r, c, map[r][c]);
                    while (true) {
                        int nr = p.r + dr[cmd];
                        int nc = p.c + dc[cmd];

                        // 다음 이동할 좌표가 맵을 벗어나면 break
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }
                        // 이동할 좌표의 value가 0이 아니고, 현재 좌표의 value와 이동할 좌표의 value가 다르면 break
                        if (map[nr][nc] != 0 && map[p.r][p.c] != map[nr][nc]) {
                            if (p.isCombined) {
                                combined[p.r][p.c] = true;
                            }
                            break;
                        }

                        // 다음 좌표의 value가 0인 경우
                        if (map[nr][nc] == 0) {
                            map[nr][nc] = map[p.r][p.c];
                            map[p.r][p.c] = 0;

                        } else if (map[nr][nc] == map[p.r][p.c] && (combined[nr][nc] || p.isCombined)) {
                            combined[p.r][p.c] = true;
                            break;
                        }
                        else if (map[nr][nc] == map[p.r][p.c] && !combined[nr][nc] && !p.isCombined) {
                            // 다음 좌표와 현재 좌표가 같은 경우
                            map[nr][nc] *= 2;
                            map[p.r][p.c] = 0;
                            p.isCombined = true;
                        }
                        p.r = nr;
                        p.c = nc;
                    }
                }
            }
        }

    }
}
