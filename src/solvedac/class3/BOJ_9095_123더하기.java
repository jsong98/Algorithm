package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int a = n/3;	// 3의 개수를 저장
			int b = 0;		// 2의 개수를 저장
			int c = 0;		// 1의 개수를 저장
			int size = 0;	// 전체 숫자의 개수
			int cnt = 0;
			while(true) {
				b = (n-3*a)/2;	
				while(b!=0) {
					c = (n-(3*a)-(2*b));	
					size = a+b+c;
					cnt += fac(size)/fac(a)/fac(b)/fac(c);
					b--;
				}
				c = (n-(3*a)-(2*b));	// 1의 개수를 저장
				size = a+b+c;
				cnt += fac(size)/fac(a)/fac(b)/fac(c);
				a--;
				if(a<0) break;
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	public static int fac(int a) {
		if(a==0) return 1;
		int res = a;
		for(int i = a-1; i >= 1; i--) {
			res = res * i;
		}
		return res;
	}
	

}
