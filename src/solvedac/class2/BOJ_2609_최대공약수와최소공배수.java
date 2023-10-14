package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int gcd = 0;
		
		for(int i = min; i >= 1; i--) {
			if(max % i == 0 && min%i == 0) {
				System.out.println(i);
				gcd = i;
				break;
			}
		}
		
		System.out.println((max/gcd)*(min/gcd)*(gcd));
	}

}
