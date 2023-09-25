package topic.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = new ArrayList<>();
		int[] indegree = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(v2);
			indegree[v2]++;
		}
		
		topologicalSor(list, indegree);
		
	}
	
	public static void topologicalSor(List<List<Integer>> list, int[] indegree) {
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> res = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()) {
			int node = que.poll();
			res.offer(node);
			
			for(int linked : list.get(node)) {
				indegree[linked]--;
				
				if(indegree[linked]==0) {
					que.offer(linked);
				}
			}
		}
		
		while(!res.isEmpty()) {
			System.out.print(res.poll() + " ");
		}
	}

}
