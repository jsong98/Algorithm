package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int n, m;
    static int[] arr;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		backtrack(1,0);
		
	}
	
	public static void backtrack(int idx, int depth) {
		if(depth==m) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i <= n; i++) {
			arr[depth] = i;
			backtrack(i, depth+1);
		}
	}

}
