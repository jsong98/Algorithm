package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11403_경로찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < s.length; j++) {
				if(s[j].equals("1")) {
					graph.get(i).add(j);
				}
			}
		}
			
		for(int i = 0; i < graph.size(); i++) {
			visited = new boolean[n];
			bfs(i);
			for(int j = 0; j < n; j++) {
				if(visited[j]) {
					sb.append("1" + " ");
				} else {
					sb.append("0" + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int k) {
		Queue<Integer> que = new LinkedList<>();
		que.add(k);
		while(!que.isEmpty()) {
			int p = que.poll();
			
			for(int d : graph.get(p)) {
				if(visited[d]) continue;
				visited[d] = true;
				que.add(d);
			}
		}
		
	}
}
