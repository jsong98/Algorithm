package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int h;
	static int n;
	static int m;
	static int[] dx = {-1,0,1,0,0,0}; //상하좌우위아래
	static int[] dy = {0,1,0,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	
	static int[][][] arr;
	static Queue<Tomato> que;
	
	static class Tomato{
		int x;
		int y;
		int z;
		
		public Tomato(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][n][m];
		que = new LinkedList<Tomato>();
		for(int i = 0; i < h; i++) {			// 상자 개수
			for(int j = 0; j < n; j++) {		// 상자의 row
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {	// 상자의 column
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k]==1) que.add(new Tomato(i, j, k)); 
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		while(!que.isEmpty()){
			Tomato t = que.remove();
			
			int z = t.z;
			int x = t.x;
			int y = t.y;
			
			for(int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx>=0 && ny>=0 && nz>=0 && nx < n && ny < m && nz < h) {
					if(arr[nz][nx][ny]==0) {
						que.add(new Tomato(nz,nx,ny));
						arr[nz][nx][ny] = arr[z][x][y] +1;
					}
				}
			}
			
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(arr[i][j][k]==0) return -1;
					res = Math.max(res, arr[i][j][k]);
				}
			}
		}
		
		if(res==1) return 0;
		else return res-1;
	}
}
