package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;
	static int[][] arr;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	static int M;
	static int N;
	static int K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j]==1&&!visited[i][j]) {
						check(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void check(int r, int c) {
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			if(r+dr[i]>=0&&r+dr[i]<N&&c+dc[i]>=0&&c+dc[i]<M) {
				if(arr[r+dr[i]][c+dc[i]]==1 && !visited[r+dr[i]][c+dc[i]]) {
					check(r+dr[i], c+dc[i]);
				}
			}
		}
	}

}
