package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1986_체스 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static String[][] board;
	static boolean[][] visited;
	static int[] knightR = {-2,-1,1,2,2,1,-1,-2};
	static int[] knightC = {1,2,2,1,-1,-2,-2,-1};
	static int[] queenR = {-1,0,1,1,1,0,-1,-1};
	static int[] queenC = {1,1,1,0,-1,-1,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new String[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) Arrays.fill(board[i], "");
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) continue;
			for(int j = 0; j < num; j++) {
				int r = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				if(i == 0) {
					board[r][c] = "Q";
					visited[r][c] = true;
				} else if(i == 1) {
					board[r][c] = "K";
					visited[r][c] = true;
				} else {
					board[r][c] = "P";
					visited[r][c] = true;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j].equals("K")) {
					knight(i, j);
				}
				if (board[i][j].equals("Q")) {
					queen(i, j);
				}
			}
		}
		
//		for(boolean[] test : visited) {
//			System.out.println(Arrays.toString(test));
//		}
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) res++;
			}
		}
		System.out.println(res);
	}
	
	static void knight(int r, int c) {
		for(int i = 0; i < 8; i++) {
			int nr = r + knightR[i];
			int nc = c + knightC[i];
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
		}
	}

	static void queen(int r, int c) {
		outer:
		for(int i = 0; i < 8; i++) {
			int k = 1;
			while(true) {
			int nr = r + k * queenR[i];
			int nc = c + k * queenC[i];
//			System.out.println(r + ", " + c + " / " + nr + ", " + nc);
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue outer;
			if(!board[nr][nc].equals("")) continue outer;
			visited[nr][nc] = true;
			k++;
			}
		}
	}
}
