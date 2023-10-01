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
		int[] maxDp = new int[3];
		int[] minDp = new int[3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			int i3 = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				maxDp[0] = minDp[0] = i1;
				maxDp[1] = minDp[1] = i2;
				maxDp[2] = minDp[2] = i3;
			} else  {
				int temp1 = maxDp[0];
				int temp2 = maxDp[2];
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + i1;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + i3;
				maxDp[1] = Math.max(Math.max(temp1, maxDp[1]), temp2) + i2;
				
				temp1 = minDp[0];
				temp2 = minDp[2];
				minDp[0] = Math.min(minDp[0], minDp[1]) + i1;
				minDp[2] = Math.min(minDp[1], minDp[2]) + i3;
				minDp[1] = Math.min(Math.min(temp1, minDp[1]), temp2) + i2;
			}
		}
//		System.out.println(Arrays.toString(maxDp));
//				System.out.println(Arrays.toString(minDp));
		System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " " + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]));
	}

}
