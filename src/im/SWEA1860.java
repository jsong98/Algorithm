package im;

import java.util.Arrays;
import java.util.Scanner;

//진기의 최고급 붕어빵
public class SWEA1860 {
	
	public static void main(String[] args) {
		int T;
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] person = new int[n];
			int t = 0;					// 시간
			int prep = 0;				// 만들어진 붕어빵 개수
			int customer = 0;			// 가게에 온 손님 수
			boolean check = true;
			String result1 = "Possible";
			String result2 = "Impossible";
			
			for(int j = 0; j < n; j++) {	// 손님이 오는 시간을 1차원 배열에 저장
				person[j] = sc.nextInt();
			}
			
			Arrays.sort(person);	// person 배열 정렬
			
			while(t != person[n-1]+1) {	// 시간 t를 1초씩 증가, 마지막 손님이 오는 시간까지
				if((t != 0) && (t % m == 0)) {		
					prep += k;
				}
				
				for(int l = 0; l < person.length; l++) {
					if(person[l] == t) {
						customer++;
					}
				}
				
				if((prep - customer) < 0) {
					check = false;
					break;
				}
				
				t++;
			}
			
			if(check) {
				System.out.printf("#%d %s\n", i+1, result1);
			} else {
				System.out.printf("#%d %s\n", i+1, result2);
			}
			
		}
	}

}
