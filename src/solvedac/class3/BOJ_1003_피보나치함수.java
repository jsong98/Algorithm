package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			fibo(n);
			sb.append(dp[n][0] + " " + dp[n][1] + "\n");
		}
		System.out.println(sb);
	}

	public static int[] fibo(int n) {
		
		if(dp[n][0] == 0 && dp[n][1] == 0) {
			dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
		}
		
		return dp[n];
	}
}
