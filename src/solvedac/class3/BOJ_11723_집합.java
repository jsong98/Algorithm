package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int m;
	static Set<Integer> set;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		m = Integer.parseInt(br.readLine());
		set = new HashSet<>();
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int k = 0;
			if(st.hasMoreTokens()) {
				k = Integer.parseInt(st.nextToken());
			}
			
			if(s.equals("add")) {
				set.add(k);
			} else if(s.equals("remove")) {
				if(set.contains(k)) {
					set.remove(k);
				}
			} else if(s.equals("check")) {
				if(set.contains(k)) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if(s.equals("toggle")) {
				if(set.contains(k)) {
					set.remove(k);
				} else {
					set.add(k);
				}
			} else if(s.equals("all")) {
				set.clear();
				for(int j = 1; j <= 20; j++) {
					set.add(j);
				}
			} else {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}
