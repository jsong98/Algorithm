package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int max;
    static int[][] arr;
    static int[][] res;
    static int[] dr = {1, 1};
    static int[] dc = {0, 1};
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		res = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				res[i][j] = arr[i][j];
			}
		}
		
		for(int i = n-1; i >= 1; i--) {
			for(int j = 0; j <= i-1; j++) {
				res[i-1][j] = Math.max(res[i][j] + arr[i-1][j], res[i][j+1] + arr[i-1][j]);
//				for(int[] test : res) {
//					System.out.println(Arrays.toString(test));
//				}
//				System.out.println();
			}
		}
		
		System.out.println(res[0][0]);
	}

}
