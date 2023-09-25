package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] arr;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	// 0: 오른쪽, 1: 오른쪽 아래, 2: 아래
	static int cnt;
	
	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Pos front = new Pos(0, 1);
		Pos rear = new Pos(0, 0);
		cnt = 0;
		
		dfs(front, rear);
		
		System.out.println(cnt);
	}
	
	public static void dfs(Pos front, Pos rear) {
		if(front.r == n-1 && front.c == n-1) {
			cnt++;
			return ;
		}
		
		if(front.r == rear.r && front.c-rear.c==1) {
			// 가로로 놓여있는 경우
			int[] move = {0, 1};
			for(int i = 0; i < move.length; i++) {
				int nr = front.r + dr[move[i]];
				int nc = front.c + dc[move[i]];
				if(nr >= n || nc >= n || arr[nr][nc]==1) continue;
				if(move[i]==1) {
					if(arr[nr-1][nc]==1||arr[nr][nc-1]==1) continue;
				}
				dfs(new Pos(nr, nc), front);
			}
			
		}

		if (front.c == rear.c && front.r - rear.r == 1) {
			// 세로로 놓여있는 경우
			int[] move = {1, 2};
			for(int i = 0; i < move.length; i++) {
				int nr = front.r + dr[move[i]];
				int nc = front.c + dc[move[i]];
				if(nr >= n || nc >= n || arr[nr][nc]==1) continue;
				if(move[i]==1) {
					if(arr[nr-1][nc]==1||arr[nr][nc-1]==1) continue;
				}
				dfs(new Pos(nr, nc), front);
			}
		}
		
		if (front.r - rear.r == 1 && front.c - rear.c == 1) {
			// 대각선으로 놓여있는 경우
			int[] move = {0, 1, 2};
			for(int i = 0; i < move.length; i++) {
				int nr = front.r + dr[move[i]];
				int nc = front.c + dc[move[i]];
				if(nr >= n || nc >= n || arr[nr][nc]==1) continue;
				if(move[i]==1) {
					if(arr[nr-1][nc]==1||arr[nr][nc-1]==1) continue;
				}
				dfs(new Pos(nr, nc), front);
			}
		}
	}
}
