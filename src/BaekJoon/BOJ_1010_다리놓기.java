package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			long temp1 = 1;
			long temp2 = 1;
			
			if(n > m/2) n = m-n;
			
			for(int i = 0; i < n; i++) {
				temp1 *= m;
				m--;
			}
			int tempN = n;
			for(int i = 0; i < tempN; i++) {
				temp2 *= n;
				n--;
			}
			System.out.println(temp1/temp2);
		}
	}
	
	// 재귀
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			n = Integer.parseInt(st.nextToken());
//			m = Integer.parseInt(st.nextToken());
//			
//			System.out.println(comb(m, n));
//		}
//	}
//	
//	public static int comb(int a, int b) {
//		if(a==b)  return 1;
//		if(a == 1 || b == 0) return 1;
//		
//		return comb(a-1, b) + comb(a-1, b-1); 
//	}
//	
}
