package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static char[] s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		s = br.readLine().toCharArray();
		
		char[] target = new char[2*n+1];
		for(int i = 0; i < target.length; i++) {
			if(i%2 == 0) {
				target[i] = 'I';
			} else {
				target[i] = 'O';
			}
		}
		
		int res = 0;
		outer:
		for(int sIdx = 0; sIdx <= s.length-target.length; sIdx++) {
			for(int tIdx = 0; tIdx < target.length; tIdx++) {
//				System.out.println(s.charAt(sIdx+tIdx) + " " + target.charAt(tIdx));
				if(s[sIdx+tIdx] != target[tIdx]) continue outer;
				if(tIdx == target.length-1) res++;
			}
		}
		System.out.println(res);
	}

}
