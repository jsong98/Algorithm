package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2667_단지번호붙이기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int part;
	
	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j])
;			}
		}
		
		part = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					part += 1;
					map[i][j] = part;
					bfs(new Pos(i, j));
				}
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(part);
		if(part == 0) {
			return ;
		}
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		for(int i = 1; i <= part; i++) {
			hashmap.put(i, 0);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					hashmap.replace(map[i][j], hashmap.get(map[i][j])+1);
				}
			}
		}
		
		int[] res = new int[hashmap.size()];
		int idx = 0;
		for(int i = 1; i <= part; i++) {
			res[idx++] = hashmap.get(i);
		}
		
		Arrays.sort(res);
		
		for(Integer i : res) {
			System.out.println(i);
		}
	}
	
	public static void bfs(Pos srt) {
		Queue<Pos> que = new LinkedList<>();
		que.add(srt);
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nr >= n || nc < 0 || nc >= n) continue;
				if(visited[nr][nc] || map[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				map[nr][nc] = part;
				que.offer(new Pos(nr, nc));
			}
		}
		
	}
}
