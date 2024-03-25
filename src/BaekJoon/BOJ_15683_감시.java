package BaekJoon;

/*
input1
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0

output1
20

input2
6 6
0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5

output2
15

사무실 세로, 가로의 최대 크기 = 8
cctv 최대 개수 = 8

1 2 3 4 5
4 2 4 4 1

backtracking + bruteforce

모든 cctv의 모든 경우 탐색
한 case의 최대 경우의 수
  ==> cctv 8대 배치 + 모든 cctv가 4가지 경우의 수
  ==> 4 * 8 = 32
1번 cctv     [0], [1], [2], [3]
2번 cctv     [0,2], [1,3]
3번 cctv     [0,1], [1,2], [2,3], [3,4]
4번 cctv     [3,0,1], [0,1,2], [1,2,3], [2,3,0]
5번 cctv     [0,1,2,3]

맵 데이터를 읽으면서 cctv가 입력으로 들어오면 해당 cctv 인스턴스 생성
    cctv 인스턴스는 좌표값과 가질수 있는 상태값(List에 저장)을 갖고 있음
Cctv 인스턴스들이 저장된 list를 기반으로 backtracking
    가능한 모든 경우의 수를 찾아 cases에 저장
cases에서 하나씩 꺼내서 모든 경우의 수 탐색

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15683_감시 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Cctv {
        int r;
        int c;
        List<int[]> status;
        public Cctv(int r, int c) {
            this.r = r;
            this.c = c;
            this.status = new ArrayList<>();
        }
    }
    static int[][] map;
    static int[][] originMap;
    static int N, M, cctvCnt, result;
    static boolean[] visited = new boolean[44444555];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static List<Cctv> list = new ArrayList<>(); // 입력으로 주어진 Cctv 인스턴스 저장
    static List<List<int[]>> cases = new ArrayList<>(); // 나올 수 있는 모두 경우의 수 저장
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        originMap = new int[N][M];
        cctvCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                originMap[i][j] = k;
                if(k == 0 || k == 6) continue;
                cctvCnt++;
                if(k == 1) {
                    Cctv cctv = new Cctv(i, j);
                    cctv.status.add( new int[]{0});
                    cctv.status.add( new int[]{1});
                    cctv.status.add( new int[]{2});
                    cctv.status.add( new int[]{3});
                    list.add(cctv);
                }
                if(k == 2) {
                    Cctv cctv = new Cctv(i, j);
                    cctv.status.add( new int[]{0,2});
                    cctv.status.add( new int[]{1,3});
                    list.add(cctv);
                }
                if(k == 3) {
                    Cctv cctv = new Cctv(i, j);
                    cctv.status.add( new int[]{0,1});
                    cctv.status.add( new int[]{1,2});
                    cctv.status.add( new int[]{2,3});
                    cctv.status.add( new int[]{3,0});
                    list.add(cctv);
                }
                if(k == 4) {
                    Cctv cctv = new Cctv(i, j);
                    cctv.status.add( new int[]{3,0,1});
                    cctv.status.add( new int[]{0,1,2});
                    cctv.status.add( new int[]{1,2,3});
                    cctv.status.add( new int[]{2,3,0});
                    list.add(cctv);
                }
                if(k == 5) {
                    Cctv cctv = new Cctv(i, j);
                    cctv.status.add( new int[]{0,1,2,3});
                    list.add(cctv);
                }
            }
        }   // input

        comb(0, new ArrayList<>(), list);

        result = Integer.MAX_VALUE;
        for (List<int[]> aCase : cases) {   // 각 경우의 수 탐색
            for (int i = 0; i < aCase.size(); i++) {
                int r = list.get(i).r;
                int c = list.get(i).c;  // cctv가 설치된 위치
                for(int d : aCase.get(i)) {
                    /*
                    d == cctv가 감시하는 방향(0 == 북, 2 == 남)
                    로직 추가
                    */
                    int nr = r;
                    int nc = c;
                    while(true) {
                        nr = nr + dr[d];
                        nc = nc + dc[d];
                        if(nr >= N || nr < 0 || nc >= M || nc < 0 || map[nr][nc] == 6) break;
                        if(map[nr][nc] != 0) {
                            continue;
                        }
                        map[nr][nc] = -1;
                    }

                }
            }
            int temp = checkMap();
            if(temp < result) result = temp;
            initMap();
        }

        System.out.println(result);
    }

    /*
    경우의 수를 저장할 List<List<int[]>> cases
    Cctv 인스턴스들이 저장된 List<Cctv> list
    경우의수 탐색을 위한 List<int[]> temp
    */
    static void comb(int index, List<int[]> temp, List<Cctv> list) {
        if(temp.size() == cctvCnt) {
            List<int[]> push = new ArrayList<>(temp);
            cases.add(push);
            return ;
        }

        for (int i = 0; i < list.get(index).status.size(); i++) {
            temp.add(index, list.get(index).status.get(i));
            comb(index + 1, temp, list);
            temp.remove(index);
        }
    }

    static int checkMap() {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) ret++;
            }
        }
        return ret;
    }

    static void initMap() {
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(originMap[i], 0, map[i], 0, M);
        }
    }
}
