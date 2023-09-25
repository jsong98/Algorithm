package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Parametric Search

public class BOJ_1654_랜선자르기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] len = new int[K];
		long max = 0;
		for(int i = 0; i < K; i++) {
			len[i] = Integer.parseInt(br.readLine());
			if(len[i] > max) {
				max = len[i];
			}
		}
		max++;
		
		long min = 0;
		long mid = 0;
		
		while(min<max) {
			mid = min + (max-min)/2;
			
			long count = 0;
			
			for(int i = 0; i < len.length; i++) {
				count += (len[i]/mid);
			}
			
			if(count < N) {
				max = mid;
			} else {
				min = mid +1;
			}
		}
		
		System.out.println(min-1);
	}

}
