package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_9663_NQueen {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		
		solveNQueens(n);
		
		System.out.println(res);
	}

	public static void solveNQueens(int n) {
		int[] arr = new int[n];
		Arrays.fill(arr, -1);
		nQueens(arr, 0);
	}

	public static void nQueens(int[] arr, int idx) {
		if(idx==arr.length) {
			res++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (check(arr, idx, i)) {
				arr[idx] = i;
//				System.out.println(Arrays.toString(arr) + " " + idx + " " + i);
				nQueens(arr, idx+1);
			}
		}
	}

	// target == 들어갈 숫자 == column, idx == 들어갈 위치 == row
	public static boolean check(int[] arr, int idx, int target) {
		if(idx == 0) {
			for(int i = 1; i < arr.length; i++) {
				arr[i] = -1;
			}
			return true;
		}
		for(int i = 0; i < idx; i++) {
			if(arr[i]==target) return false;
			if(Math.abs(i-idx) == Math.abs(target-arr[i])) return false;
		}
		
		return true;
	}
}
