package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static String[][] map;
	static boolean[][] visited;
	static int res;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pos {
		int r;
		int c;
		
		public Pos() {
		}
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][m];
		visited = new boolean[n][m];
		Pos init = new Pos();
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = s[j];
				if(map[i][j].equals("I")) {
					init.r = i;
					init.c = j;
				}
			}
		}
		
		res = 0;
		visited[init.r][init.c] = true; 
		bfs(init);
		
		if(res == 0) System.out.println("TT");
		else System.out.println(res);
	}
	
	public static void bfs(Pos init) {
		Queue<Pos> que = new LinkedList<>();
		que.offer(init);
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if(visited[nr][nc] || map[nr][nc].equals("X")) continue;
				if(map[nr][nc].equals("P")) res++;
				visited[nr][nc] = true;
				que.add(new Pos(nr, nc));
			}
		}
	}
}
