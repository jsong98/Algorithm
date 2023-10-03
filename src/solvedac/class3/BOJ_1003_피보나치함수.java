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
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		while(T-- > 0 ) {
			int n = Integer.parseInt(br.readLine());
			fibo(n);
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}

	public static int[] fibo(int i) {
		if(i == 0) {
			return new int[] {1, 0};
		} else if(i == 0) {
			return new int[] {0, 1};
		} else {
			return new int[] {fibo(i-1)[0] + fibo(i-2)[0], fibo(i-1)[1] + fibo(i-2)[1]};
		}
	}
}
