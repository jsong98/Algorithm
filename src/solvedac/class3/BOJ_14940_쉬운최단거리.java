package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
 * */

public class BOJ_14940_쉬운최단거리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, sr, sc;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	
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
				if(arr[i][j] == 2) {
					sr = i;
					sc = j;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			outer:
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == 1) {
						for(int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
							if(arr[nr][nc] == 2) continue outer;
						}
						arr[i][j] = -1;
					}
				}
		}
		
		bfs();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs() {
		arr[sr][sc] = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {sr, sc, 0});
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int tr = temp[0];
			int tc = temp[1];
			int tm = temp[2];
			
			for(int i = 0; i < 4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				int nm = tm + 1;
				if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || arr[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				arr[nr][nc] = nm;
				que.offer(new int[] {nr, nc, nm});
			}
		}
	}
}
