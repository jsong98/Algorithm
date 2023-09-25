package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		if(N%5 == 0) {
			System.out.println(N/5);
		} else if(N%3 == 0) {
			int cnt = 0;
			int temp = N;
			while(!(temp%5==0)) {
				temp -= 3;
				cnt++;
				if(temp<3) {
					System.out.println(N/3);
					System.exit(0);
				}
			}
			if(temp%5==0) {
				cnt += temp/5;
			}
			System.out.println(cnt);
		} else {
			int cnt = 0;
			while(!(N%5==0)) {
				N -= 3;
				cnt++;
				if(N<5) {
					System.out.println(-1);
					System.exit(0);
				}
			}
			if(N%5==0) {
				cnt += N/5;
			}
			System.out.println(cnt);
		}
	}

}
