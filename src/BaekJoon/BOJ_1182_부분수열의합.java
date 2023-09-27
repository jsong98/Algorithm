package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 0
-7 -3 -2 5 8
 * */

public class BOJ_1182_부분수열의합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, s;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
//			System.out.println("chk");
			output = new int[i];
			visited = new boolean[n];
			combination(0, 0);
		}
		
		System.out.println(cnt);
	}
	
	public static void combination(int idx, int sidx) {
		if(sidx == output.length) {
//			System.out.println(Arrays.toString(output));
			if(getSum(output) == s) {
				cnt++;
			}
			
			return ;
		}
		if(idx == n) return ;
		
		for(int i = idx; i < n; i++) {
			output[sidx] = arr[i];
			combination(i+1, sidx+1);
		}
	}
	
	public static void permutation(int depth) {
		if(depth == output.length) {
			return ;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int getSum(int[] input) {
		int sum = 0;
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		
		return sum;
	}
	
}
