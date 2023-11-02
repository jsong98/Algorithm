package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1 

1 - 3
2 - 4
3 - 1, 4
4 - 2 - 3 - 5
5 - 4
*/

public class BOJ_1167_트리의지름 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<List<Edge>> tree;
	static boolean[] visited;
	static int max;
	static int std;
	
	static class Edge {
		int end;
		int dist;
		
		public Edge(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
	}
	
	static class Pos {
		int srt;
		int move;
		
		public Pos(int srt, int move) {
			this.srt = srt;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int srt = Integer.parseInt(st.nextToken());
			int end = 0;
			int dist = 0;
			while(true) {
				end = Integer.parseInt(st.nextToken());
				if(end == -1) break;
				dist = Integer.parseInt(st.nextToken());
				tree.get(srt).add(new Edge(end, dist));
			}
			
		} // input
		
//		for(List<Edge> list : tree) {
//			for(Edge e : list) {
//				System.out.print(e.end + " " + e.dist + " ");
//			}
//			System.out.println();
//		}
		
		max = -1;
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(new Pos(1, 0));
		// 임의의 한 점에서 가장 먼 정점 == 지름의 양 끝 중 하나
		visited = new boolean[n+1];
		visited[std] = true;
		dfs(new Pos(std, 0));
		
		System.out.println(max);
	}
	
	public static void dfs(Pos p) {
		if(p.move > max) {
			max = p.move;
			std = p.srt;
		}
		
		for(Edge e : tree.get(p.srt)) {
			if(visited[e.end]) continue;
			visited[e.end] = true;
			dfs(new Pos(e.end, p.move + e.dist));
		}
	}
}
