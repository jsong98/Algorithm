package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;
	static int[][] via;
	static int[] dr = {0,1,-1,0};
	static int[] dc = {1,0,0,-1};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		visited = new boolean[n][m];
		via = new int[n][m];
		for(int[] a : via) Arrays.fill(a, 1);
		
		for(int r = 0; r < n; r++) {
			char[] charArr = br.readLine().toCharArray();
			for(int c = 0; c < m; c++) {
				arr[r][c] = charArr[c]-'0';
			}
		}
		
		int rpt = 0;
		int cpt = 0;
		int cnt = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {rpt, cpt});
		visited[0][0] = true;
		outer :
		while(!que.isEmpty()) {
			int[] p = que.poll();
//			System.out.println(p[0] + ", " + p[1]);
			
			for (int i = 0; i < 4; i++) {
				int nr = p[0] + dr[i];
				int nc = p[1] + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m
						&& arr[nr][nc] == 1 && !visited[nr][nc]) {
					via[nr][nc] += via[p[0]][p[1]];
					visited[nr][nc] = true;
					if(nr == (n-1) && nc == (m-1)) break outer;
//					System.out.println(nr + ", " + nc);
					que.add(new int[] { nr, nc });
				} 
			}
		}
		
		System.out.println(via[n-1][m-1]);
	}

}
