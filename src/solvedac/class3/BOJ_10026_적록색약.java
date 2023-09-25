package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs로 풀면 시간초과

public class BOJ_10026_적록색약 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean check;
	
	static String[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new String[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < n; j++) {
				arr[i][j] = s[j];
			}
			
		}
		
		int res1 = 0;
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs1(i, j, arr[i][j]);
					res1++;
				}
			}
		}
		
		int res2 = 0;
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs2(i, j, arr[i][j]);
					res2++;
				}
			}
		}
		
		System.out.println(res1 + " " + res2);
	}

	public static void dfs1(int r, int c, String s) {
		if(visited[r][c]) return ;
		visited[r][c] = true;
		int x = r;
		int y = c;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if ((arr[nx][ny].equals(s))) {
					dfs1(nx, ny, s);
				}
			}
		}
	}
	
	public static void dfs2(int r, int c, String s) {
		if(visited[r][c]) return ;
		visited[r][c] = true;
		int x = r;
		int y = c;
		
		if(s.equals("B")) {
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if ((arr[nx][ny].equals(s))) {
						dfs2(nx, ny, s);
					}
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if ((arr[nx][ny].equals("R") || arr[nx][ny].equals("G"))) {
						dfs2(nx, ny, s);
					}
				}
			}
		}
	}

//	public static void bfs(int r, int c) {
//		visited[r][c] = true;
//		Queue<int[]> que = new LinkedList<>();
//		que.offer(new int[] {r,c});
//		
//		while(!que.isEmpty()) {
//			int[] p = que.poll();
//			int x = p[0];
//			int y = p[1];
//			visited[x][y] = true;
//			String std = arr[x][y];
//			if(std.equals("R") || std.equals("G")) {
//				for(int i = 0; i < 4; i++) {
//					int nx = x + dr[i];
//					int ny = y + dc[i];
//					if(nx>=0 && nx<n && ny>=0 && ny<n) {
//						if((arr[nx][ny].equals("R") || arr[nx][ny].equals("G")) && !visited[nx][ny]) {
//							if(!arr[x][y].equals(arr[nx][ny])) check = true;
//							que.offer(new int[] {nx,ny});
//						}
//					}
//				}
//			} else {
//				for(int i = 0; i < 4; i++) {
//					int nx = x + dr[i];
//					int ny = y + dc[i];
//					if(nx>=0 && nx<n && ny>=0 && ny<n) {
//						if(arr[nx][ny].equals(std) && !visited[nx][ny]) {
//							que.offer(new int[] {nx,ny});
//						}
//					}
//				}
//			}
//		}
//	}

}
