package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/*
10 10 8
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

5 5 2
1 0 1 1 1
0 1 1 1 1
1 0 1 0 1
1 1 0 1 0
1 0 1 0 1
*/

public class BOJ_17135_캐슬디펜스 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, d;
	static int ar, ac;
	static int[][] map;
	static int[][] temp;
	static int[] combArr;
	static int[] combOutput;
	static List<int[]> cases;
	static List<int[]> deleteList;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	static int cnt;
	
	static class Pos {
		int r;
		int c;
		int dis;
		
		public Pos(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n+1][m];
		combArr = new int[m];
		for(int i = 0; i < m; i++) {
			combArr[i] = i;
		}
		combOutput = new int[3];
		cases = new ArrayList<>();
		comb(0,0);
		
		for(int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int[] pos : cases) {
			cnt = 0;
			temp = new int[n+1][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					temp[i][j] = map[i][j];
				}
			}
			while(!endChk()) {
				deleteList = new ArrayList<>();
				for(int p : pos) {
					PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
						@Override
						public int compare(Pos p1, Pos p2) {
							if(p1.dis == p2.dis) {
								return p1.c - p2.c;
							} else {
								return p1.dis - p2.dis;
							}
						}
					});
					
					visited = new boolean[n+1][m];
					visited[n][p] = true;
					ar = n;
					ac = p;
					dfs(new Pos(n, p, 0), pq);
					if(pq.isEmpty()) continue;
					Pos candidate = pq.poll();
					int[] canArr = new int[] {candidate.r, candidate.c};
					deleteList.add(canArr);
					pq.clear();
				}
				for(int[] arr : deleteList) {
					if(temp[arr[0]][arr[1]] == 1) {
						temp[arr[0]][arr[1]] = 0;
						cnt++;
					}
				}
				
				move();
			}
			if(cnt > max) max = cnt;
		}
		
		System.out.println(max);
	}
	
	public static void dfs(Pos p, PriorityQueue<Pos> pq) {
		for(int i = 0; i < 4; i++) {
			int nr = p.r + dr[i];
			int nc = p.c + dc[i];
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			if(visited[nr][nc] || getDist(ar, ac, nr, nc) > d) continue;
			visited[nr][nc] = true;
			if(temp[nr][nc] == 1) pq.add(new Pos(nr, nc, getDist(ar, ac, nr, nc)));
			dfs(new Pos(nr, nc, getDist(ar, ac, nr, nc)), pq);
		}
	}
	
	public static int getDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
	
	public static void move() {
		for(int i = n-2; i >= 0; i--) {
			for(int j = 0; j < m; j++) {
				temp[i+1][j] = temp[i][j];
			}
		}
		for(int i = 0; i < m; i++) {
			temp[0][i] = 0;
		}
	}
	
	public static boolean endChk() {
		for(int i = n-1; i >= 0; i--) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == combOutput.length) {
			int[] temp = new int[combOutput.length];
			for(int i = 0; i < combOutput.length; i++) {
				temp[i] = combOutput[i];
			}
			cases.add(temp);
			return ;
		}
		if(idx == combArr.length) return ;
		
		combOutput[sidx] = combArr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
}
