package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, l, r;
	static int sum, avg;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<List<Pos>> unions;
	static List<Integer> unionNum;
	
	static class Pos {
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
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		unionNum = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int t = 0;
		while(true) {
			getUnions();
			if(unions.size() == Math.pow(n, 2)) {
				break;
			}
//			for (int[] test : map) {
//				System.out.println(Arrays.toString(test));
//			}
			merge();
//			System.out.println();
//			for (int[] test : map) {
//				System.out.println(Arrays.toString(test));
//			}
//			System.out.println("-------------------------------");
			t++;
		}
		System.out.println(t);
	}

	public static void getUnions() {
		visited = new boolean[n][n];
		unions = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					bfs(new Pos(i, j));
				}
			}
		}
	}
	
	public static void merge() {
		for (List<Pos> union : unions) {
			if (union.size() == 1)
				continue;
			int sum = 0;
			int avg = 0;
			for (Pos p : union) {
				sum += map[p.r][p.c];
			}
			avg = sum / union.size();
			for (Pos p : union) {
				map[p.r][p.c] = avg;
			}
		}
	}
	
	public static void bfs(Pos p) {
		List<Pos> union = new ArrayList<>();
		Queue<Pos> que = new LinkedList<>();
		union.add(p);
		que.add(p);
		while(!que.isEmpty()) {
			Pos temp = que.poll();
			for(int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				int diff = Math.abs(map[temp.r][temp.c] - map[nr][nc]); 
				if(visited[nr][nc] || diff < l || diff > r) continue;
				visited[nr][nc] = true;
				union.add(new Pos(nr, nc));
				que.add(new Pos(nr, nc));
			}
		}
		unions.add(union);
	}
	
}
