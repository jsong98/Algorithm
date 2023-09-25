package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절대값힙 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> {
			int abs1 = Math.abs(a);
			int abs2 = Math.abs(b);
			
			if(abs1 == abs2) return a > b ? 1: -1;
			return abs1 - abs2;

		});
		
//		PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				int abs1 = Math.abs(o1);
//				int abs2 = Math.abs(o2);
//				
//				if(abs1 == abs2) return o1 > o2 ? 1: -1;
//				return abs1 - abs2;
//			}
//		});
		
		
		for(int cal = 0; cal < n; cal++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(que.isEmpty()) {
					sb.append("0" + "\n");
				} else {
					sb.append(que.poll() + "\n");
				}
			} else {
				que.offer(x);
			}
		}
		
		System.out.println(sb);
	}

}
