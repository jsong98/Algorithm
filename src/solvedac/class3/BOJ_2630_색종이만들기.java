package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int white;
	static int black;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0;
		black = 0;
		
		if(check(arr, N)) {
			if(arr[0][0]==0) System.out.println(1 + "\n" + 0);
			if(arr[0][0]==1) System.out.println(0 + "\n" + 1);
			return ;
		} else {
			divide(arr, 0, 0, N);
		}
		System.out.println(white + "\n" + black);
	}
	
	static void divide(int[][] arr, int r, int c, int size) {
		if(size==1) {
			if(arr[r][c]==0) white++;
			if(arr[r][c]==1) black++;
			return ;
		}
		
		int divSize = size/2;
		int[][] arr1 = new int[divSize][divSize];
		int[][] arr2 = new int[divSize][divSize];
		int[][] arr3 = new int[divSize][divSize];
		int[][] arr4 = new int[divSize][divSize];
		for(int i = 0; i < divSize; i++) {
			for(int j = 0; j < divSize; j++) {
				arr1[i][j] = arr[r+i][c+j];
				arr2[i][j] = arr[r+divSize+i][c+j];
				arr3[i][j] = arr[r+i][c+divSize+j];
				arr4[i][j] = arr[r+divSize+i][c+divSize+j];
			}
		}
		
		if(!check(arr1, divSize)) {
			divide(arr, r, c, divSize);
		} else {
			if(arr[r][c]==0) white++;
			if(arr[r][c]==1) black++;
		}
		if(!check(arr2, divSize)) {
			divide(arr, r+divSize, c, divSize);
		} else {
			if(arr[r+divSize][c]==0) white++;
			if(arr[r+divSize][c]==1) black++;
		}
		if(!check(arr3, divSize)) {
			divide(arr, r, c+divSize, divSize);
		} else {
			if(arr[r][c+divSize]==0) white++;
			if(arr[r][c+divSize]==1) black++;
		}
		if(!check(arr4, divSize)) {
			divide(arr, r+divSize, c+divSize, divSize);
		} else {
			if(arr[r+divSize][c+divSize]==0) white++;
			if(arr[r+divSize][c+divSize]==1) black++;
		}
	}
	
	static boolean check(int[][] arr, int size) {
		int std = arr[0][0];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(arr[i][j] != std) {
					return false;
				}
			}
		}
		return true;
	}

}
