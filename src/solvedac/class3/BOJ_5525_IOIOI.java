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

		int res = 0;
		int cnt = 0;

		for(int i = 1; i < m - 1; i++) {
			if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
				cnt++;

				if (cnt == n) {
					cnt--;
					res++;
				}
				i++;
			} else {
				cnt = 0;
			}
		}

		System.out.println(res);
	}

}
