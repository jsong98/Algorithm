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
	static int[] dp;
	static String s1;
	static String s2;
	
	public static void main(String[] args) throws IOException {
		s1 = br.readLine();
		s2 = br.readLine();
		
		String max = "";
		String min = "";
		
		if(s1.length() >= s2.length()) {
			max = s1;
			min = s2;
		} else {
			max = s2;
			min = s1;
		}
		
		dp = new int[max.length()];
		
		int idx = 0;
		int srt = 0;
		for(int i = 0; i < min.length(); i++) {
			if(max.charAt(0) == min.charAt(i)) {
				dp[0] = 1;
				srt = i+1;
				break;
			} else {
				dp[0] = 0;
			}
		}
		
		for(int i = 1; i < dp.length; i++) {
			idx = srt;
			while(idx < min.length()) {
				if(max.charAt(i) == min.charAt(idx)) {
					dp[i] = dp[i-1] + 1;
					srt = idx+1;
					break;
				} else {
					idx++;
				}
				
			}
			if(dp[i] == 0) {
				dp[i] = dp[i-1];
			}
		}
		
		System.out.println(dp[dp.length-1]);
	}

}
