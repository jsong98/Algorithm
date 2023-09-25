package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			stack.add(Integer.parseInt(br.readLine()));
		}
		int cnt = 0;
		
		while(K!=0) {
			int u = stack.pop();
			if(K/u==0) {
				continue;
			} else {
				cnt += K/u;
				K = K%u;
				if(K==0) {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
