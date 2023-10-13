package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, k;
	static int res, min;
	static boolean[] visited;
	
	static class Pos {
		int num;
		int time;
		
		public Pos(int num, int time) {
			this.num = num;
			this.time = time;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int t = 0;
		min = Integer.MAX_VALUE;
		visited = new boolean[300000];
		min = Integer.MAX_VALUE;
		bfs(n);
		System.out.println(min);
	}

	public static void bfs(int s) {
		Queue<Pos> que = new LinkedList<>();
		Pos srt = new Pos(s, 0);
		que.add(srt);
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			
			if(p.num == k) {
				if(p.time < min) {
					min = p.time;
				}
				break;
			}
			
			if(p.num < k) {
				if(!visited[p.num+1]) {
					visited[p.num+1] = true;
					que.add(new Pos(p.num+1, p.time+1));
				}
				if(!visited[p.num*2]) {
					visited[p.num*2] = true;
					que.add(new Pos(p.num*2, p.time+1));
				}
				if(p.num > 1 && !visited[p.num-1]) {
					visited[p.num-1] = true;
					que.add(new Pos(p.num-1, p.time+1));
				}
			}else {
				if(!visited[p.num-1]) {
					visited[p.num-1] = true;
					que.add(new Pos(p.num-1, p.time+1));
				}
			}
		}
		
	}

}
