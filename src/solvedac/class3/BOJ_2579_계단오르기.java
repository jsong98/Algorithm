package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_계단오르기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N];
		for(int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(stairs[0]);
			return;
		}
		if(N==2) {
			System.out.println(stairs[0]+stairs[1]);
			return;
		}
		if(N==3) {
			System.out.println(Math.max(stairs[0], stairs[1])+stairs[2]);
			return;
		}
		if(N==4) {
			System.out.println(Math.max(stairs[0]+stairs[1], stairs[0]+stairs[2])+stairs[3]);
			return;
		}
		
		res = new int[N];
		makeRes(stairs);
		System.out.println(res[res.length-1]);
		
	}
	
	public static void makeRes(int[] stairs) {
		res[0] = stairs[0];
		res[1] = stairs[0]+stairs[1];
		res[2] = Math.max(stairs[0], stairs[1])+stairs[2];
		res[3] = Math.max(stairs[0]+stairs[1], stairs[0]+stairs[2])+stairs[3];
		int i = 4;
		while(res[res.length-1]==0) {
			res[i] = Math.max(res[i-2], res[i-3]+stairs[i-1]) + stairs[i];
			i++;
		}
	}
	
	// 재귀, 시간 초과 뜸
//	public static int getMax(int[] stairs, int i) {
//		if(i==0) return stairs[0];
//		if(i==1) return stairs[1]+stairs[0];
//		if(i==2) return Math.max(stairs[0], stairs[1])+stairs[2];
//		if(i==3) return Math.max(stairs[0]+stairs[1], stairs[0]+stairs[2])+stairs[3];
//		
//		res[i] = Math.max(getMax(stairs, i-2), getMax(stairs, i-3)+stairs[i-1]) + stairs[i];
//		
//		return res[i];
//	}

}
