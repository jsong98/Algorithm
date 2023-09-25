package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int res;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList<List<Integer>>();
		visited = new boolean[n+1];
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		res = 0;
		bfs();
		
		System.out.println(res);
	}
	
	public static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(1);
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int p = que.poll();
			
			for(int i = 0; i < graph.get(p).size(); i++) {
				int k = graph.get(p).get(i);
				if(!visited[k]) {
					res++;
					visited[k] = true;
					que.offer(k);
				}
			}
		}
	}

}
