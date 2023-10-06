package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
8 8
0 0 0 1 1 1 1 0
0 1 1 1 1 0 1 0
0 1 0 1 1 1 0 0
0 1 0 0 0 1 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 1 0 0
0 1 1 1 0 0 0 0
0 1 0 0 0 1 0 0
*/

public class BOJ_17472_다리만들기2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Pos> islands;
	static PriorityQueue<Bridge> pq;
	static int res;
	
	static class Pos {
		int r;
		int c;
		List<Bridge> bridges;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
			bridges = new ArrayList<>();
		}
	}
	
	static class Bridge {
		Pos srt;
		Pos end;
		int dis;
		
		public Bridge(Pos srt, Pos end, int dis) {
			this.srt = srt;
			this.end = end;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		islands = new ArrayList<>();
		res = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 임의의 한 섬을 찾음
		outer:
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					conquer(new Pos(i, j));
					break outer;
				}
			}
		}
		pq = new PriorityQueue<>(new Comparator<Bridge>() {
			@Override
			public int compare(Bridge b1, Bridge b2) {
				return b1.dis - b2.dis;
			}
		});
		while(true) {
			// islands에 저장된 각 좌표들에서 가능한 다리, edges 찾기
			for(Pos p : islands) {
				findEdges(p);
			}
			
			// 아직 연결 안된 섬들 중에서 가장 짧은 다리로 연결 가능한 경우 찾기
			while(!pq.isEmpty() && visited[pq.peek().end.r][pq.peek().end.c]) {
				pq.poll();
			}
			
			if(pq.isEmpty()) {
				// 연결되지 않은 섬이 있는데 pq가 비어있다 == 모든 섬을 연결할 수 없음.
				if(chk())  {
					System.out.println(-1);
					return;
				}
				break;
			} else {
				Bridge b = pq.poll();
				res += b.dis;
				conquer(new Pos(b.end.r, b.end.c));
			}
		}
		System.out.println(res);
	}
	
	// 연결되지 않는 섬이 있는지 check.
	public static boolean chk() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void findEdges(Pos p) {
		// 이전에 찾아놓은 간선이 있으면 그 간선들을 heap에 넣어줌
		if(!p.bridges.isEmpty()) {
			return ;
		}
		
		outer:
		for(int i = 0; i < 4; i++) {
			int nr = p.r + dr[i];
			int nc = p.c + dc[i];
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			if(visited[nr][nc] || map[nr][nc] == 1) continue;
//			Pos srt = new Pos(p.r, p.c);
			int dis = 0;
			while(true) {
				nr += dr[i];
				nc += dc[i];
				dis += 1;
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue outer;
				if(map[nr][nc] == 1) {
					// 길이가 1인 다리는 설치 불가
					if(dis == 1) continue outer;
					
					Pos srt = new Pos(p.r, p.c);
					Pos end = new Pos(nr, nc);
					Bridge b = new Bridge(srt, end, dis);
					p.bridges.add(b);
					pq.add(b);
					continue outer;
				}
				
			}
		}
	}
	
	// 임의의 한 섬에 속한 좌표들을 방문 처리 및 islands 리스트에 저장.
	public static void conquer(Pos p) {
		islands.add(new Pos(p.r, p.c));
		visited[p.r][p.c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = p.r + dr[i];
			int nc = p.c + dc[i];
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			if(visited[nr][nc] || map[nr][nc] == 0) continue;
			visited[nr][nc] = true;
			Pos np = new Pos(nr, nc);
			islands.add(np);
			conquer(np);
		}
	}
}
