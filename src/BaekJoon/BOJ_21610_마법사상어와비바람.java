package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
5 4
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3
3 4
8 1
4 8

5 1
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3

*/

public class BOJ_21610_마법사상어와비바람 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited; // 새 구름 생성 할 때 사용
	// 왼쪽부터 시계방향
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static List<Cloud> cloudList;
	// 대각선 4방(좌측 위부터 시계방향)
	static int[] wr = {-1,-1,1,1};
	static int[] wc = {-1,1,1,-1};
	
	public static class Cloud{
		int r;
		int c;
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		cloudList = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
				
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloudList.add(new Cloud(n-2, 0));
		cloudList.add(new Cloud(n-1, 0));
		cloudList.add(new Cloud(n-2, 1));
		cloudList.add(new Cloud(n-1, 1));
		
		for(int i = 0; i < m; i++) {
//			System.out.println("*******************************");
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d-1, s);
//			status();
			rain();
//			status();
			waterDup();
//			status();
			newCloud();
//			status();
		}
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				res += map[i][j];
			}
		}
		
		System.out.println(res);
	}
	
	public static void move(int d, int s) {
		for(int i = 0; i < cloudList.size(); i++) {
			Cloud c = cloudList.get(i);
			
			int nr = c.r;
			int nc = c.c;
			for(int j = 0; j < s; j++) {
				nr += dr[d];
				nc += dc[d];
				if(nr < 0) {
					nr = n-1;
				} else if(nr == n) {
					nr = 0;
				}
				if(nc < 0) {
					nc = n-1;
				} else if(nc == n) {
					nc = 0;
				}		
			}
			
			cloudList.set(i, new Cloud(nr, nc));
		}
	}
	
	public static void rain() {
		for(Cloud c : cloudList) {
			map[c.r][c.c] += 1;
		}
	}
	
	public static void waterDup() {
		for(Cloud c : cloudList) {
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				int nr = c.r + wr[i];
				int nc = c.c + wc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if(map[nr][nc] == 0) continue;
				cnt++;
			}
			map[c.r][c.c] += cnt; 
		}
	}
	
	public static void newCloud() {
		visited = new boolean[n][n];
		for(Cloud c : cloudList) {
			visited[c.r][c.c] = true;
		}
		cloudList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					cloudList.add(new Cloud(i, j));
				}
			}
		}
	}
	
	public static void status() {
		System.out.println("------------map 상태----------");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("------------cloud 상태----------");
		
		for(Cloud c : cloudList) {
			System.out.println(c.r + " " + c.c);
		}
		
		System.out.println();
	}
}
