package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {
	
	private static final int depth = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
    static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		perm(arr, visited, 0, m);
	}
	
	public static void perm(int[] arr, boolean[] visited, int start, int depth) {
		if(depth == 0) {
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) System.out.print((i+1) + " ");
			}
			System.out.println();
		}
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			perm(arr, visited, i+1, depth-1);
			visited[i] = false;
		}
	}
			
}
