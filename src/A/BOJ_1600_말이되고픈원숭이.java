package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1
4 4
0 0 0 0
0 0 0 0
0 0 1 1
0 0 1 0 
*/

public class BOJ_1600_말이되고픈원숭이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int k, w, h;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] kr = {-2,-1,1,2,2,1,-1,-2};
	static int[] kc = {1,2,2,1,-1,-2,-2,-1};
	static int res;
	
	static class Pos {
		int r;
		int c;
		int move;
		int k;
		
		public Pos(int r, int c, int move, int k) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w][k+1];
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = bfs(0,0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}
	
	public static int bfs(int r, int c) {
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(0,0,0,k));
		
		int min = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			if(p.r == h-1 && p.c == w-1) {
				if(p.move < min) min = p.move;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 1) continue;
				if(visited[nr][nc][p.k]) continue;
				visited[nr][nc][p.k] = true; 
				que.offer(new Pos(nr, nc, p.move+1, p.k));
			}
			
			if(p.k > 0) {
				for(int i = 0; i < 8; i++) {
					int nr = p.r + kr[i];
					int nc = p.c + kc[i];
					if(nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 1) continue;
					if(visited[nr][nc][p.k-1]) continue;
					visited[nr][nc][p.k-1] = true;
					que.offer(new Pos(nr, nc, p.move+1, p.k-1));
				}
			}
		}
		
		return min;
	}
	
}
