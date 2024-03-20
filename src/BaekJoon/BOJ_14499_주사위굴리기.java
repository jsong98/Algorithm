package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input1
4 2 0 0 8
0 2
3 4
5 6
7 8
4 4 4 1 3 3 3 2

output1
0
0
3
0
0
8
6
3
----------------------------------init
  0
0 0 0
  0
  0#

0* 2
3 4
5 6
7 8
----------------------------------1
  0#
  0
0 3 0
  0

0 2
0* 4
5 6
7 8
==> 0
----------------------------------2
  0
  0#
  3
0 5 0

0 2
0 4
0* 6
7 8
==> 0
----------------------------------3
0 7 0
  0
  3#
  5

0 2
0 4
0 6
0* 8
==> 3
----------------------------------4
7 0 3
  0
  0#
  5

0 2
0 4
0 6
0 0*
==> 0


*/
public class BOJ_14499_주사위굴리기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Pos {
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int bottom;
    static int top;
    static int left;
    static int right;
    static int e1;
    static int e2;
    static int N;
    static int M;
    static int[][] map;
    static Pos pos;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        pos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int cmdNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bottom = 0;
        top = 0;
        left = 0;
        right = 0;
        e1 = 0;
        e2 = 0;
        st = new StringTokenizer(br.readLine());
        int temp;
        for (int i = 0; i < cmdNum; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    if(pos.c+1 >= M) break;
                    pos.c++;
                    temp = left;
                    left = bottom;
                    bottom = right;
                    right = top;
                    top = temp;
                    if(map[pos.r][pos.c] == 0) {
                        map[pos.r][pos.c] = bottom;
                    } else {
                        bottom = map[pos.r][pos.c];
                        map[pos.r][pos.c] = 0;
                    }
                    System.out.println(top);
                    break;
                case 2:
                    if(pos.c-1 < 0) break;
                    pos.c--;
                    temp = top;
                    top = right;
                    right = bottom;
                    bottom = left;
                    left = temp;
                    if(map[pos.r][pos.c] == 0) {
                        map[pos.r][pos.c] = bottom;
                    } else {
                        bottom = map[pos.r][pos.c];
                        map[pos.r][pos.c] = 0;
                    }
                    System.out.println(top);
                    break;
                case 3:
                    if(pos.r-1 < 0) break;
                    pos.r--;
                    temp = e2;
                    e2 = top;
                    top = e1;
                    e1 = bottom;
                    bottom = temp;
                    if(map[pos.r][pos.c] == 0) {
                        map[pos.r][pos.c] = bottom;
                    } else {
                        bottom = map[pos.r][pos.c];
                        map[pos.r][pos.c] = 0;
                    }
                    System.out.println(top);
                    break;
                case 4:
                    if(pos.r+1 >= N) break;
                    pos.r++;
                    temp = bottom;
                    bottom = e1;
                    e1 = top;
                    top = e2;
                    e2 = temp;
                    if(map[pos.r][pos.c] == 0) {
                        map[pos.r][pos.c] = bottom;
                    } else {
                        bottom = map[pos.r][pos.c];
                        map[pos.r][pos.c] = 0;
                    }
                    System.out.println(top);
                    break;
            }
        }
    }
}
