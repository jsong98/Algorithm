package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

// 순서가 상관없는 경우, list보다 set이 훨씬 빠름 !

public class BOJ_1764_듣보잡 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> std = new HashSet<>();
		PriorityQueue<String> pq = new PriorityQueue<String>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			std.add(str);
		}
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(std.contains(str)) {
				pq.add(str);
			}
		}
		sb.append(pq.size() + "\n");
		int size = pq.size();
		for(int i = 0; i < size; i++) {
			sb.append(pq.poll() + "\n");
		}
		System.out.println(sb);
	}
}
