package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[][] max;
	static int[][] min;
	
	static class Pos {
		int r;
		int c;
		int weight;
		
		public Pos(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		max = new int[n][n];
		min = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			max[0][i] = arr[0][i];
			min[0][i] = arr[0][i];
		}
		
		
		
	}

}
