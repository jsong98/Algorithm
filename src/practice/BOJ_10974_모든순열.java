package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		output = new int[n];
		visited = new boolean[n];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		permutation(0);
	}
	
	public static void permutation(int depth) {
		if(depth == n) {
			for(int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
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

}
