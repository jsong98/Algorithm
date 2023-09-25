package im;

import java.util.Scanner;

public class SWEA_달팽이숫자2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int cnt = 1;
			int r = 0;
			int c = 0;
			int temp = n;
			
			while(arr[r][c]==0) {
				for(int i = 0; i < temp; i++) {
					arr[r][c] = cnt;
					cnt++;
					c++;
				}
				if(cnt==n*n+1) break;
				c--;
				r++;
				for(int i = 0; i < temp-1; i++) {
					arr[r][c] = cnt;
					cnt++;
					r++;
				}
				if(cnt==n*n+1) break;
				r--;
				c--;
				for(int i = 0; i < temp-1; i++) {
					arr[r][c] = cnt;
					cnt++;
					c--;
				}
				if(cnt==n*n+1) break;
				c++;
				r--;
				for(int i = 0; i < temp-2; i++) {
					arr[r][c] = cnt;
					cnt++;
					r--;
				}
				if(cnt==n*n+1) break;
				r++;
				c++;
				temp-=2;
			}
			
			System.out.println("#" + tc);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
