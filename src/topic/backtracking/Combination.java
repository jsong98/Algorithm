package topic.backtracking;

import java.util.Arrays;

public class Combination {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		boolean[] visited = new boolean[arr.length];
		
		comb1(arr, visited, 0, 3);
		System.out.println();
		comb2(arr, visited, 0, 3);
	}
	
	// backtracking
	static void comb1(int[] arr, boolean[] visited, int start, int r) {
		if(r==0) {
			System.out.println(Arrays.toString(visited));
//			print(arr, visited);	
		}
		
		for(int i = start; i < arr.length; i++) {
			visited[i] = true;
//			System.out.println(Arrays.toString(visited) + " " + start + " " + i + " " + r);
			comb1(arr, visited, i+1, r-1);
			visited[i] = false;	
		}
	}
	
	// recursion
	static void comb2(int[] arr, boolean[] visited, int depth, int r) {
		if(r == 0) {
//			print(arr, visited);
			return ;
		}
		if(depth == arr.length) {
			return;
		} else {
			visited[depth] = true;	
			comb2(arr, visited, depth + 1, r - 1);
			
			visited[depth] = false;
			comb2(arr, visited, depth + 1, r);
		}
	}
	
	// 출력
	static void print(int[] arr, boolean[] visited) {
		for(int i = 0; i < arr.length; i++) {
			if(visited[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
}
