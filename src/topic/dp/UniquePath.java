package topic.dp;

import java.util.Arrays;

public class UniquePath {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		
		uniquePaths(m, n);
	}

	public static int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			arr[i][0] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			arr[0][i] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		int res = arr[m-1][n-1];
		
		return res;
	}
}
