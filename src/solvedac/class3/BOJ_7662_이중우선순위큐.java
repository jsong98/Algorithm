package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중우선순위큐 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	// maxheap & minheap & map을 한번에 활용한 풀이
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if(command.equals("I")) {
					map.put(n, map.getOrDefault(n, 0)+1);
					minHeap.offer(n);
					maxHeap.offer(n);
				} else {
					if(map.size()==0) continue;
					
					PriorityQueue<Integer> pq = n == 1 ? maxHeap : minHeap;
					remove(pq, map);
				}
			}
			
			if(map.size()==0) System.out.println("EMPTY");
			else System.out.println(remove(maxHeap, map) + " " + remove(minHeap, map));
		}
	}
	
	public static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
		int n = 0;
		while(true) {
			n = pq.poll();
			int cnt = map.getOrDefault(n, 0);
			if(cnt == 0) continue;
			if(cnt == 1) {
				map.remove(n);
			} else {
				map.put(n, cnt-1);
			}
			break;
		}
		
		return n;
	}
	
	// TreeMap API 활용. map에 들어오는 원소들을 오름차순으로 자동정렬
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			int k = Integer.parseInt(br.readLine());
//			TreeMap<Integer, Integer> que = new TreeMap<>();
//			
//			for(int i = 0; i < k; i++) {
//				String[] input = br.readLine().split(" ");
//				String command = input[0];
//				int n = Integer.parseInt(input[1]);
//				if(command.equals("I")) {
//					que.put(n, que.getOrDefault(n, 0)+1);
//				} else {
//					if(que.size()==0) continue;
//					int num = n==1 ? que.lastKey() : que.firstKey();
//					if(que.put(num, que.get(num)-1) == 1) {
//						// put method의 return == put하기 이전에 해당 key가 갖고 있던 value!
//						que.remove(num);
//					}
//				}
//			}
//			
//			System.out.println(que.size()==0?"Empty" : que.lastKey() + " " + que.firstKey());
//		}
//	}
}
