package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4
*/

public class BOJ_16236_아기상어 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int n;
	static int t;
	static int size;
	static int eat;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean flag;
	
    static class Pos{
    	int r;
    	int c;
    	int t;
    	
    	public Pos(int r, int c, int t) {
    		this.r = r;
    		this.c = c;
    		this.t = t;
		}
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		size = 2;
		flag = true;
		
		Pos cur = null;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					cur = new Pos(i, j, 0);
					visited[i][j] = true;
					map[i][j] = 0;
				}
			}
		}
		while(check() && flag) bfs(cur);
		System.out.println(cur.t);
//		for(int[] test : map) {
//			System.out.println(Arrays.toString(test));
//		}
	}
	
	public static void bfs(Pos cur) {
		int[][] temp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {

			@Override
			public int compare(Pos p1, Pos p2) {
				if(p1.t!=p2.t) return p1.t-p2.t;
				else {
					if(p1.r!=p2.r) return p1.r-p2.r;
					else return p1.c-p2.c;
				}
			}
		});
		visited = new boolean[n][n];
		Queue<Pos> que = new LinkedList<>();
		
		que.offer(cur);
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int nt = p.t + 1;
				if( nr<0 || nr>= n || nc<0 || nc>= n || (map[nr][nc]>size) || visited[nr][nc]) continue;
				if(map[nr][nc]<size && map[nr][nc]!=0) pq.add(new Pos(nr, nc, nt));
				temp[nr][nc] = 0;
				que.add(new Pos(nr, nc, nt));
				visited[nr][nc] = true;
			}
		}
		
		if(pq.isEmpty()) {
			flag = false;
			return;
		}
		else {
			Pos p = pq.poll();
			cur.r = p.r;
			cur.c = p.c;
			cur.t = p.t;
		}
		
		map[cur.r][cur.c] = 0;
		pq.clear();
		eat++;
		if(eat==size) {
			size++;
			eat = 0;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public static boolean check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j]!= 0 && map[i][j]<size) return true;
			}
		}
		
		 return false;
	}
}
