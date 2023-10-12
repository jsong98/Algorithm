package A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16235_나무재테크 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	
	public static void main(String[] args) {
		arr = new int[5];
		visited = new boolean[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		output = new int[5];
		
		perm(0);
	}
	
	public static void perm(int depth) {
		if(depth == output.length) {
			System.out.println(Arrays.toString(output));
			
			return ;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(depth+1);
				visited[i] = false;
			}
		}
	}
}
