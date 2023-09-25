package topic.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightProbabilityInChessboard {

	public static void main(String[] args) {
//		int n = 3;
//		int k = 2;
//		int row = 0;
//		int column = 0;
		
		int n = 8;
		int k = 30;
		int row = 6;
		int column = 4;
		
		System.out.println(knightProbability(n, k, row, column));
	}
	
	static double[][][] dp;
	static int[] xmove = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] ymove = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static double knightProbability(int n, int k, int row, int col) {
        dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1.0);
            }
        }
        double favourableOutcome = solve(row, col, n, k);
        for(double[][] arr : dp) {
        	for(double[] arr2 : arr) {
        		System.out.println(Arrays.toString(arr2));
        	}
        }
        double totalOutcome = Math.pow(8, k);
        return favourableOutcome / totalOutcome;
    }

    private static double solve(int row, int col, int n, int k) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0;
        if (k == 0) return 1;
        if (dp[row][col][k] != -1.0) return dp[row][col][k];

        double ans = 0;

        for (int i = 0; i < 8; i++) {
            ans += solve(row + xmove[i], col + ymove[i], n, k - 1);
        }

        return dp[row][col][k] = ans;
    }
}
