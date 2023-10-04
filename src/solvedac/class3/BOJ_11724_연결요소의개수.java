package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
6 5
1 2
2 5
5 1
3 4
4 6

1 2 5
3 4 6
*/

public class BOJ_11724_연결요소의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static List<List<Integer>> graph;
	static int cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		graph = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		cnt = 0;
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int srt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(srt).add(end);
			graph.get(end).add(srt);
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int i) {
		for(int dest : graph.get(i)) {
			if(!visited[dest]) {
				visited[dest] = true;
				dfs(dest);
			}
		}
	}
}
