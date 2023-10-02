package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	
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
		arr[0] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int srt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(srt == 1) {
				sb.append(arr[end-1] + "\n");
			} else {
				sb.append(arr[end-1]-arr[srt-2] + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
