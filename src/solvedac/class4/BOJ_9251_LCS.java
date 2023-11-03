package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
ACAYKP
CAPCAK

ACAK - 4
 
  A C A Y K P
C 0 1 1 1 1 1
A 1 1 2 2 2 2
P 1 1 2 2 2 3
C 1 2 2 2 2 3
A 1 2 3 3 3 3
K 1 2 3 3 4 4

*/

public class BOJ_9251_LCS {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] dp;
	static char[] s1;
	static char[] s2;
	
	public static void main(String[] args) throws IOException {
		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();
		
		dp = new int[s1.length+1][s2.length+1];
		
		for(int i = 1; i <= s1.length; i++) {
			for(int j = 1; j <= s2.length; j++) {
				if(s1[i - 1] == s2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;	
				}	else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[s1.length][s2.length]);
	}

}
