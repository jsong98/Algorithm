package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17626_FourSquares {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		int min = 0;
		for(int i = 2; i <= n; i++) {
			min = Integer.MAX_VALUE;
			
			for(int j = 1; Math.pow(j, 2) <= i; j++) {
				int sub = i - (int)Math.pow(j, 2);
				min = Math.min(min, dp[sub]);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[n]);
		
	}

}
