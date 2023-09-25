package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int max=Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int r, int c, int sum, int cnt) {
		if(cnt==4) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
			
			if(!visited[nr][nc]) {
				if(cnt==2) {
					visited[nr][nc] = true;
					dfs(r, c, sum+arr[nr][nc], cnt+1);
					visited[nr][nc] = false;
				}
				visited[nr][nc] = true;
				dfs(nr, nc, sum+arr[nr][nc], cnt+1);
				visited[nr][nc] = false;
			}
		}
	}
	
}
