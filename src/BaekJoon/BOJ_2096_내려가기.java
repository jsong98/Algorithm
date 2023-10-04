package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[][] max;
	static int[][] min;
	static int[] dc = {-1,0,1};
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		max = new int[n][n];
		min = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max[i][j] = arr[i][j];
				min[i][j] = arr[i][j];
			}
		}
		
		for(int r = 0; r < n-1; r++) {
			for(int c = 0; c < n; c++) {
				for(int k = 0; k < 3; k++) {
					int nr = r + 1;
					int nc = c + dc[k];
					if(nc < 0 || nc >= n) continue;
					int tempMax = max[r][c] + max[nr][nc];
					int tempMin = min[r][c] + min[nr][nc];
					if(tempMax > max[nr][nc]) {
						max[nr][nc] = tempMax;
						for(int[] test : max) {
							System.out.println(Arrays.toString(test));
						}
						System.out.println();
					}
					if(tempMin < min[nr][nc]) {
						min[nr][nc] = tempMax;
					}
				}
			}
		}
		
//		for(int[] test : arr) {
//			System.out.println(Arrays.toString(test));
//		}
//		System.out.println();
//		for(int[] test : max) {
//			System.out.println(Arrays.toString(test));
//		}
//		System.out.println();
//		for(int[] test : min) {
//			System.out.println(Arrays.toString(test));
//		}
	}

}
