package im;

import java.util.Scanner;

// 파리 퇴치3

/*
2
5 2
1	3	3	6	7
8	13	9	12	8
4	16	11	12	6
2	4	1	23	2
9	13	4	7	3
6 3
29	21	26	9	5	8
21	19	8	0	21	19
9	24	2	11	4	24
19	29	1	0	21	19
10	29	6	18	4	3
29	11	15	3	3	29
 */

public class SWEA12712 {

	public static void main(String[] args) {
		//입력
		int T = 0, n = 0, m= 0;
		int cntP = 0;
		int cntM = 0;
		int max = Integer.MIN_VALUE;
		int[][] arr = null;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n][n];
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			//+로 분사한 경우
			for(int l = 0; l < n; l++) {
				for(int j = 0; j < n; j++) {
					cntP = 0;
					cntP += arr[l][j];
					for(int k = 1; k < m; k++) {
						if(j-k >= 0) {
							cntP += arr[l][j-k];
						}
						if(l-k >= 0) {
							cntP += arr[l-k][j];
						}
						if(j+k < n) {
							cntP += arr[l][j+k];
						}
						if(l+k < n) {
							cntP += arr[l+k][j];
						}
					}
					if(cntP > max) {
						max = cntP;
					}
				}
			}
			
			//x로 분사한 경우
			for(int l = 0; l < n; l++) {
				for(int j = 0; j < n; j++) {
					cntP = 0;
					cntP += arr[l][j];
					for(int k = 1; k < m; k++) {
						if(j-k >= 0 && l-k >= 0) {
							cntP += arr[l-k][j-k];
						}
						if(l+k < n && j+k < n) {
							cntP += arr[l+k][j+k];
						}
						if(l-k >= 0 && j+k < n) {
							cntP += arr[l-k][j+k];
						}
						if(l+k < n && j-k >=0) {
							cntP += arr[l+k][j-k];
						}
					}
					if(cntP > max) {
						max = cntP;
					}
				}
			}
			
			System.out.printf("#%d " + max + "\n", i+1);
			
		}
	}
}
