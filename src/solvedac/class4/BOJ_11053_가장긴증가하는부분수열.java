package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static int[] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dpArr = new int[n];
		Arrays.fill(dpArr, 1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력
		
		int max = -1;
		
		for(int i = 1; i < n; i++) {
			dp(i);
		}
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dpArr[i]);
		}
		
		System.out.println(max);
	}
	
	public static void dp(int c) {
		for(int i = c-1; i >= 0; i--) {
			if(arr[i] < arr[c]) {
				dpArr[c] = Math.max(dpArr[c], dpArr[i]+1);
			}
		}
	}

}
