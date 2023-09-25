package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<Integer> dRes = new ArrayList<>();
	static List<Integer> bRes = new ArrayList<>();
	static boolean[] dVisited;
	static boolean[] bVisited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map.putIfAbsent(v1, new ArrayList<>());
			map.get(v1).add(v2);
			map.putIfAbsent(v2, new ArrayList<>());
			map.get(v2).add(v1);
		}
		for(int k : map.keySet()) {
			Collections.sort(map.get(k));
		}
		
		dRes.add(V);
		bRes.add(V);
		dfs(map, V);
		bfs(map, V);
		
		for(int i = 0; i < dRes.size(); i++) {
			sb.append(dRes.get(i) + " ");
		}
		sb.append("\n");
		for(int i = 0; i < bRes.size(); i++) {
			sb.append(bRes.get(i) + " ");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(HashMap<Integer, List<Integer>> map, int v) {
		if(map.get(v) == null) return;
		for(Integer i : map.get(v)) {
			if(map.containsKey(i) && !dRes.contains(i)) {
				dRes.add(i);
				dfs(map, i);
			}
		}
	}
	
	public static void bfs(HashMap<Integer, List<Integer>> map, int v) {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(v);
		while(!pq.isEmpty()) {
			int start = pq.poll();
			if(map.get(start)==null) continue;
			for(int i : map.get(start)) {
				if(map.containsKey(i) && !bRes.contains(i)) {
					bRes.add(i);
					pq.add(i);
				}
			}
		}
	}

}
