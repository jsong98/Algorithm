package im;

import java.util.Scanner;

public class SWEA_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int input = 1;
			int pt1 = 0;
			int pt2 = 0;
			int curve1 = n;
			int curve2 = 0;
			
			while(arr[pt1][pt2] == 0) {
				// 오른쪽 이동
				while(pt2 < curve1) {
					arr[pt1][pt2++] = input++;
				}
				pt2--;
				pt1++;
				if(n == 1) {
					break;
				}
				if(arr[pt1][pt2] != 0) {
					break;
				}
				
				// 아래로 이동
				while(pt1 < curve1) {
					arr[pt1++][pt2] = input++;
				}
				pt1--;
				pt2--;
				if(arr[pt1][pt2] != 0) {
					break;
				}
				
				// 왼쪽 이동
				while(pt2>=curve2) {
					arr[pt1][pt2--] = input++;
				}
				pt2++;
				pt1--;
				if(arr[pt1][pt2] != 0) {
					break;
				}
				
				// 위로 이동
				while(arr[pt1][pt2] == 0) {
					arr[pt1--][pt2] = input++;
				}
				pt1++;
				pt2++;
				curve1--;
				curve2++;
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
