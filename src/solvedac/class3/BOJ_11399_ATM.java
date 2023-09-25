package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			pq.add(input);
		}
		int res = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
			sum = sum+pq.poll();
			res += sum;
		}
		System.out.println(res);
	}

}
