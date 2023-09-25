package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] via;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.putIfAbsent(v1, new ArrayList<>());
			graph.get(v1).add(v2);
			graph.putIfAbsent(v2, new ArrayList<>());
			graph.get(v2).add(v1);
		}
		
		int minkb = Integer.MAX_VALUE;
		int min = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			via = new int[n+1];
			int cnt = 0;
			visited[i] = true;
			que.add(i);
			while(!que.isEmpty()) {
				int p = que.poll();
				List<Integer> temp = graph.get(p);
				for(int j = 0; j < temp.size(); j++) {
					if(!visited[temp.get(j)]) {
						via[temp.get(j)] = via[p];
						via[temp.get(j)]++;
						cnt += via[p];
						cnt++;
						visited[temp.get(j)] = true;
						que.offer(temp.get(j));
					}
				}
			}
			if(cnt<minkb) {
				minkb = cnt;
				min = i;
			}
		}
		
		System.out.println(min);
	}
}
