package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
*/

public class BOJ_9465_스티커 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int T;
    static int[][] arr;
    static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[2][n+1];
			dp = new int[2][n+1];
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
			}
			
//			for(int[] test : dp) {
//				System.out.println(Arrays.toString(test));
//			}
			
			sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
		}
		System.out.println(sb);
	}
	
//	public static int dp(int r, int c) {
//		if(c==0) {
//			return dp[r][c];
//		}
//		
//		if(dp[r][c] == 0) {
//			if(r == 0) {
//				dp[r][c] = Math.max(dp(1, c-1) + arr[r][c], dp(0, c-1));
//			}
//			
//			if(r == 1) {
//				dp[r][c] = Math.max(dp(0, c-1) + arr[r][c], dp(1, c-1));
//			}
//		}
//		
//		return dp[r][c];
//	}
	
}
