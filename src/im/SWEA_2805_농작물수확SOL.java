package im;

import java.util.Scanner;

public class SWEA_2805_농작물수확SOL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for(int tc=1; tc<= T; tc++) { 
			int N = sc.nextInt(); 
			
			int[][] arr = new int[N][N];
			
			
			for(int r=0; r<N; r++) { 
				String str = sc.next(); 
				
				char[] charArr = str.toCharArray();
				for(int c=0; c<N; c++) {
					arr[r][c] = charArr[c] - '0';
				}
			}
			
			int sum = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int mid = N / 2; 
					int d = Math.abs(r - mid);
					int start = 0 + d; 
					int end = (N-1) - d;
					if(start <= c && c <= end) {
						sum += arr[r][c];
					}
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
		
	}
}
