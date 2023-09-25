package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static boolean[] res;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		
		res = new boolean[right+1];
		Arrays.fill(res, true);
		isPrime();
		
		for(int i = left; i <= right; i++) {
			if(res[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void isPrime() {
		
		res[0] = res[1] = false;
		
		for(int i = 2; i*i <res.length; i++) {
			if(res[i]) {
				for(int j = i*i; j < res.length; j += i) {
					res[j] = false;
				}
			}
		}

	}

}
