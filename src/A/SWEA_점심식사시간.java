package A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SWEA_점심식사시간 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] spc = new int[N][N];
			for(int c = 0; c < N; c++) {
				for(int r = 0; r < N; r++) {
					spc[c][r] = sc.nextInt();
				}
			}
			
			ArrayList<Integer> s1 = new ArrayList<>();
			ArrayList<Integer> s2 = new ArrayList<>();
			
			
		}
		
		// 2**N만큼의 비트연산자 산출
//		int[] arr = new int[N];
//		for(int i = 0; i < 1 << N; i++) {
//			int[] abc = new int[N];
//			int bit = i;
//			for(int j = 0; bit != 0; j++, bit >>= 1) {
//				if((1 & bit) == 0) {
//					continue;
//				}
//				abc[j] = 1;
//			}
//			
//			for(int k = 0; k < N; k++) {
//				System.out.print(abc[k] + " ");
//			}
//		}
		
		
	}

}
