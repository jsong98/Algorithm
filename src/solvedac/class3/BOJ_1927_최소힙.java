package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
			} else {
				pq.add(input);
			}
		}
	}

}
