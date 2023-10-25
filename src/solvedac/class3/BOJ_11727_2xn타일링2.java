package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_2xn타일링2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1]%10007) + (2*dp[i-2]%10007);
		}
		System.out.println(dp[n]%10007);
		
	}
	
}
