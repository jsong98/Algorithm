package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
5
1 2 3
1 3 4
1 4 5
1 5 6 
*/

public class BOJ_1967_트리의지름 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int res;
	static List<List<Node>> graph;
	static List<Integer> candidates;
	static boolean[] visited;
	
	public static class Node {
		int num;
		int len;
		
		public Node(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		candidates = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, len));
			graph.get(to).add(new Node(from, len));
		}
		
		res = 0;
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			dfs(i, 0);
		}
		
		System.out.println(res);
	}
	
	public static void dfs(int d, int weightSum) {
		for(Node node : graph.get(d)) {
			if(visited[node.num]) continue;
			visited[node.num] = true; 
			dfs(node.num, weightSum + node.len);
		}
		
		res = (weightSum > res) ? weightSum : res;
	}
	
}
