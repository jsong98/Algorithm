package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5 7
1
5 1 1
1 2 2
1 3 3
1 3 4
2 3 4
2 4 5
3 4 6 
*/

public class BOJ_1753_최단경로 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int v, e, k;
	static List<List<Pos>> graph;
	static HashMap<Integer, List<Integer>> map;
	
	static class Pos {
		int idx;
		int weight;
		
		public Pos(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
//		map = new HashMap<>();
		for(int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int srt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(srt).add(new Pos(end, weight));
//			if(map.get(srt) == null) {
//				map.put(srt, new ArrayList<>());
//				map.get(srt).add(end);
//				graph.get(srt).add(new Pos(end, weight));
//			} else if(map.get(srt).contains(end)){
//				for(Pos p : graph.get(srt)) {
//					if(p.idx == end) {
//						if(p.weight > weight) {
//							p.weight = weight;
//						}
//					}
//				}
//			} else if(!map.get(srt).contains(end)) {
//				map.get(srt).add(end);
//				graph.get(srt).add(new Pos(end, weight));
//			}
		}
		
//		for(List<Pos> test1 : graph) {
//			for(Pos test2 : test1) {
//				System.out.println(test2.idx + " " + test2.weight);
//			}
//			System.out.println();
//		}
		
		int[] dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;
		
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				return p1.weight - p2.weight;
			}
		});
		pq.offer(new Pos(k, 0));
		
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			int idx = p.idx;
			
			for(Pos dest : graph.get(idx)) {
				if(dist[dest.idx] > dist[idx] + dest.weight) {
					dist[dest.idx] = dist[idx] + dest.weight;
					pq.offer(new Pos(dest.idx, dist[dest.idx]));
				}
			}
		}
		
		for(int i = 1; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}
