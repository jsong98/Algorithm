package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
8
71 39 44
32 83 55
51 37 63
89 29 100
83 58 11
65 13 15
47 25 29
60 66 19

39 32 63 29 11 13 47 19

--> 253
*/

public class BOJ_1149_RGB거리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int n;
	static int r = 0;
	static int g = 1;
	static int b = 2;
    static int[][] dp;
    static int[][] cost;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		dp = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][r] = cost[0][r];
		dp[0][g] = cost[0][g];
		dp[0][b] = cost[0][b];
		
		dp(n-1, r);
		dp(n-1, g);
		dp(n-1, b);
	
//		for(int[] test : dp) {
//			System.out.println(Arrays.toString(test));
//		}
		
		System.out.println(Math.min(Math.min(dp[n-1][r], dp[n-1][g]), dp[n-1][b]));
	}

	public static int dp(int d, int color) {
		if(dp[d][color] == 0) {
			if (color == r) {
				dp[d][r] = Math.min(dp(d-1, g),dp(d-1, b)) + cost[d][r];
			}
			
			if (color == g) {
				dp[d][g] = Math.min(dp(d-1, r),dp(d-1, b)) + cost[d][g];
			}
			
			if (color == b) {
				dp[d][b] = Math.min(dp(d-1, r),dp(d-1, g)) + cost[d][b];
			}
		}
		
		
		return dp[d][color];
	}
}
