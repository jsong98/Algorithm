package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N과M8 {
	
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
		backtrack(0, output, 0);
	}
	
	public static void backtrack(int idx, int[] output, int depth) {
		if(depth==m) {
			for(int val : output) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i < n; i++) {
			output[depth] = arr[i];
			backtrack(i, output, depth+1);
		}
	}
}
