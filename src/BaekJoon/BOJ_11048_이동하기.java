package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {0,-1,-1};
    static int[] dc = {-1,-1,0};
    
    public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		for(int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		for(int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				for(int k = 0; k < 3; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					int temp = map[i][j] + dp[nr][nc];
					if(temp > dp[i][j]) {
						dp[i][j] = temp;
					}
				}
			}
		}
		
		System.out.println(dp[n-1][m-1]);
	}
}
