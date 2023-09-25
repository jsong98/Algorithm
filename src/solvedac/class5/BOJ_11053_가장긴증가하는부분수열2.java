package solvedac.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static int[] res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		res = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		res[0] = arr[0];
		int len = 1;
		
		for(int i = 1; i < n; i++) {
			int key = arr[i];
			
			if(res[len-1] < key) {
				len++;
				res[len-1] = key;
			} else {
				int lo = 0;
				int hi = len;
				while(lo < hi) {
					int mid = (lo + hi) >>> 1;
					
					if(res[mid] < key) {
						lo = mid +1;
					} else {
						hi = mid;
					}
				}
				res[lo] = key;
			}
		}
		System.out.println(len);
	}
	
}
