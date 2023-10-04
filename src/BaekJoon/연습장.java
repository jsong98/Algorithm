package BaekJoon;

import java.util.Arrays;

public class 연습장 {
	
	static int[] arr;
	static int[] output;
	
	public static void main(String[] args) {
		arr = new int[] {1, 2, 3, 4};
		output = new int[3];
		
		comb(0,0);
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == output.length) {
			System.out.println(Arrays.toString(output));
			return ;
		}
		if(idx == arr.length) return ;
		
		output[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
		
	}
}
