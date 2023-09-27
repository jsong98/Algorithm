package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_1로만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		arr[1] = 0;
		for (int i = 2; i <= n; i++) {
			int target = i;
			if(target % 6 == 0) {
				arr[i] = Math.min(Math.min(arr[target / 3], arr[target / 2]), arr[target - 1]) + 1;
			} else if (target % 3 == 0) {
				arr[i] = Math.min(arr[target / 3], arr[target - 1]) + 1;
			} else if (target % 2 == 0) {
				arr[i] = Math.min(arr[target / 2], arr[target - 1]) + 1;
			} else {
				arr[i] = arr[target - 1] + 1;
			}
		}

//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(i + " " + arr[i]);
//		}
		
		System.out.println(arr[n]);
	}

}
