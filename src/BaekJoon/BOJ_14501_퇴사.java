package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 <= N <= 15
1 <= T <= 5
1 <= P <= 1,000

input 1
10
5 10
5 9
5 8
5 7
5 6
5 10
5 9
5 8
5 7
5 6

output 1
20

input 2
10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50

output 2
90

input 3
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

output 3
45
0   0   10  30  30  45  45

 */

public class BOJ_14501_퇴사 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dp;
    static int N;
    static int[][] input;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        input = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        // i는 dp 배열의 index == 최대 일수
        for (int i = 1; i <= N; i++) {
            // j는 각 상담을 나타내는 pointer
            for (int j = 1; j <= N; j++) {
                
            }
        }
    }
}
