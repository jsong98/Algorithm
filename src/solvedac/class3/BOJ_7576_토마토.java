package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_7576_토마토 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[] dx = {-1,0,1,0}; //상하좌우
	static int[] dy = {0,1,0,-1};
	
	static int[][] arr;
	static Queue<Tomato> que;
	
	static class Tomato{
		int x;
		int y;
		
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		que = new LinkedList<Tomato>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					que.add(new Tomato(i, j));
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		while(!que.isEmpty()) {
			Tomato t = que.poll();
			int x = t.x;
			int y = t.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(arr[nx][ny]==0) {
						arr[nx][ny] = arr[x][y] + 1;
						que.offer(new Tomato(nx, ny));
					}
				}
			}
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					return -1;
				}
				if(arr[i][j] > res) {
					res = arr[i][j];
				}
			}
		}
		if(res==1) return 0;
		else return res-1;
	}
}

