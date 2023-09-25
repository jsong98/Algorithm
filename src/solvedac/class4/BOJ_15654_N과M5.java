package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
    
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int[] output = new int[m];
		boolean[] visited = new boolean[n];
		backrack(output, visited, 0);
		
	}
	
	public static void backrack(int[] output, boolean[] visited, int depth) {
		if(depth == m) {
			for(int val : output) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				backrack(output, visited, depth+1);
				visited[i] = false;
			}
		}
		
	}
}
