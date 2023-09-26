package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
9 9
010001000
010101010
010101010
010101010
010101010
010101010
010101010
010101011
000100010

13 13
0100011011000
0001001010000
0000100001000
1100010101011
1111101111000
1011010001001
0100001001001
0100111010001
0101010000100
0001110100000
0000001000100
1010001000111
1001000100000

6 4
0000
1110
1000
0000
0111
0000
*/

public class BOJ_2206_벽부수고이동하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static String[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int res;

	static class Pos {
		int r; 
		int c;
		int dis;
		boolean bw;
		
		public Pos(int r, int c, int dis, boolean bw) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.bw = bw;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][m];
		visited = new boolean[n][m][2];
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < s.length; j++) {
				map[i][j] = s[j];
			}
		}
		
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(0,0,1,false));
		res = 0;
		int min = 987654321;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
		
			if(p.r == n-1 && p.c == m-1) {
				if(p.dis < min) {
					min = p.dis;
					res = min;
					break;
				}
			}
			
//			System.out.println(p.r + " " + p.c + " " + p.dis);
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if(map[nr][nc].equals("0")) {
					if(!p.bw && !visited[nr][nc][0]) {
						visited[nr][nc][0] = true;
						que.offer(new Pos(nr, nc, p.dis+1, false));
					} else if(p.bw && !visited[nr][nc][1]){
						visited[nr][nc][1] = true;
						que.offer(new Pos(nr, nc, p.dis+1, true));
					}
				} else {
					if(!p.bw) {
						visited[nr][nc][1] = true;
						que.offer(new Pos(nr, nc, p.dis+1, true));
					}
				}
			}
		}
		
//		for(boolean[][] test : visited) {
//			for(boolean[] test1 : test) {
//				System.out.println(Arrays.toString(test1));
//			}
//			System.out.println();
//		}
		
		if(res == 0) res = -1;
		
		System.out.println(res);
	}

	
}
