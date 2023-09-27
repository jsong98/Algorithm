package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11726_2xn타일링 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				dp[i] += (dp[j] + dp[i-j]);
			}
		}
		System.out.println(Arrays.toString(dp));
	}

}
