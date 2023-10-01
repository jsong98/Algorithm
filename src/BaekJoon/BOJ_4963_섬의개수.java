package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int res;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0&&h==0) break;
			res = 0;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						res++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc]==0 || visited[nr][nc]) continue; 
			dfs(nr, nc);
		}
		
	}

}
