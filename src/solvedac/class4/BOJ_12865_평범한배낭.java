package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, k;
	static int[] w;
	static int[] v;
	static int[][] dp;
    
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		w = new int[n];
		v = new int[n];
		dp = new int[n][k+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(knapsack(n-1, k));
//		for(int[] test : dp) {
//			System.out.println(Arrays.toString(test));
//		}
	}
	
	public static int knapsack(int i, int k) {
		if(i < 0) {
			return 0;
		}
		
		if(dp[i][k] == 0) {
			if(w[i]>k) {
				dp[i][k] = knapsack(i-1, k);
			}
			else {
				dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-w[i]) + v[i]);
			}
		}
		
		return dp[i][k];
	}
}
