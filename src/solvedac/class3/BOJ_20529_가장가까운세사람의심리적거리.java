package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
3
3
ENTJ INTP ESFJ
4
ESFP ESFP ESFP ESFP
5
INFP INFP ESTP ESTJ ISTJ 
*/

public class BOJ_20529_가장가까운세사람의심리적거리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, n;
	static String[] mbtis, output;
	static List<Integer> res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			mbtis = new String[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(n > 32) {
				sb.append(0 + "\n");
				continue;
			}
			for (int i = 0; i < n; i++) {
				mbtis[i] = st.nextToken();
			}
			output = new String[3];
			res = new ArrayList<>();
			comb(0, 0);
			Collections.sort(res);
			sb.append(res.get(0) + "\n");
		}

		System.out.println(sb);
	}

	public static void comb(int idx, int sidx) {
		if (sidx == output.length) {
//			System.out.println(Arrays.toString(output));
			int total = 0;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				if(output[0].charAt(i) != output[1].charAt(i)) {
					cnt++;
				}
			}
			total += cnt;
			
			cnt = 0;
			for (int i = 0; i < 4; i++) {
				if(output[1].charAt(i) != output[2].charAt(i)) {
					cnt++;
				}
			}
			total += cnt;
			
			cnt = 0;
			for (int i = 0; i < 4; i++) {
				if(output[0].charAt(i) != output[2].charAt(i)) {
					cnt++;
				}
			}
			total += cnt;
			
			res.add(total);
			return;
		}
		if (idx == mbtis.length)
			return;

		output[sidx] = mbtis[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}
