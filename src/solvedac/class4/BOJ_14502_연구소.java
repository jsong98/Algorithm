package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int max;
    static int[][] arr;
    static int[][] temp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class Pos{
    	int r;
    	int c;
    	
    	public Pos(int r, int c) {
    		this.r = r;
    		this.c = c;
		}
    }
    
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		dfs(0);
		
		System.out.println(max);
	}
	
	public static void dfs(int wallNum) {
		if(wallNum==3) {
			bfs();
			return ;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j]==0) {
					arr[i][j] = 1;
					dfs(wallNum+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Pos> que = new LinkedList<>();
		
		int[][] temp = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] == 2) {
					que.offer(new Pos(i, j));
				}
			}
		}
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nr >= n || nc<0 || nc >= m) continue;
				if(temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					que.offer(new Pos(nr, nc));
				}
			}
		}
		
		if(count(temp)>max) max = count(temp);
	}
	
	public static int count(int[][] input) {
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(input[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}
}
