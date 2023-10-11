package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2 1 3
0 0
0 0
1 1
1 2 1 2
*/

public class BOJ_19238_스타트택시 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, ff;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static HashMap<String, String> ctm;
	
	static class Taxi {
		int r;
		int c;
		int f;
		int move;
		boolean full;
		String srt;
		int endR;
		int endC;
		int cMove;
		
		public Taxi(int r, int c, int f, int move) {
			this.r = r;
			this.c = c;
			this.f = f;
			this.move = move;
		}
	}
	
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
		m = Integer.parseInt(st.nextToken());
		ff = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		ctm = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		Taxi t = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), ff, 0);
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken() + " " + st.nextToken();
			String s2 = st.nextToken() + " " + st.nextToken();
			
			ctm.put(s1, s2);
		}
		
		int res = bfs(t);
		System.out.println(res);
	}
	
	public static int bfs(Taxi t) {
		String fs = t.r + " " + t.c;
		if(ctm.containsKey(fs)) {
			String[] d = ctm.get(fs).split(" ");
			visited[t.r][t.c]= true;
			t.full = true;
			t.srt = fs;
			t.endR = Integer.parseInt(d[0]);
			t.endC = Integer.parseInt(d[1]);
			t.cMove = 0;
		}
		
		Queue<Taxi> que = new LinkedList<>();
		que.offer(t);
		outer:
		while(!que.isEmpty()) {
			Taxi p = que.poll();
			
			if(p.full) {
				if(p.r == p.endR && p.c == p.endC) {
//					System.out.println(p.srt + " " + p.r + " " + p.c + " " + p.f + " " + p.cMove);
					p.f += p.cMove*2;
//					System.out.println(p.f);
					p.move = 0;
					p.full = false;
					ctm.remove(p.srt);
					visited = new boolean[n+1][n+1];
					que.clear();
					String tmp = p.r + " " + p.c;
					if(ctm.containsKey(tmp) && !ctm.get(tmp).equals(tmp)) {
//						System.out.println("chk" + " " + p.r + " " + p.c);
						String[] d = ctm.get(p.r + " " + p.c).split(" ");
						visited = new boolean[n+1][n+1];
						visited[p.r][p.c] = true;
						p.full = true;
						p.srt = p.r + " " + p.c;
						p.endR = Integer.parseInt(d[0]);
						p.endC = Integer.parseInt(d[1]);
						p.cMove = 0;
					}
					if(ctm.isEmpty()) {
						return p.f;
					}
				}
			}
			
			if(p.f == 0) {
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 1 || nr > n || nc < 1 || nc > n) continue;
				if(visited[nr][nc] || map[nr][nc] == 1) continue;
				String s = nr + " " + nc;
				if(!p.full && ctm.containsKey(s)) {
					String[] d = ctm.get(s).split(" ");
					visited = new boolean[n+1][n+1];
					que.clear();
					visited[nr][nc] = true;
					Taxi np = new Taxi(nr, nc, p.f-1, p.move+1);
					np.full = true;
					np.srt = s;
					np.endR = Integer.parseInt(d[0]);
					np.endC = Integer.parseInt(d[1]);
					np.cMove = 0;
					que.offer(np);
					continue outer;
				} else {
					visited[nr][nc] = true;
					Taxi np = new Taxi(nr, nc, p.f-1, p.move+1);
					np.full = p.full;
					np.srt = p.srt;
					np.endR = p.endR;
					np.endC = p.endC;
					np.cMove = p.cMove+1;
					que.offer(np);
				} 
			}
//			for(boolean[] test : visited) {
//				System.out.println(Arrays.toString(test));
//			}
//			System.out.println();
		}
		return -1;
	}

}
