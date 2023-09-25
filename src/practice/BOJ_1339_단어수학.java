package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339_단어수학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static String[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		
	}

}
