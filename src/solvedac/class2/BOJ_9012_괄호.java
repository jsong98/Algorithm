package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack<String> st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		outer:
		for(int tc = 1; tc <= T; tc++) {
			st = new Stack<>();
			String[] s = br.readLine().split("");
			for(int i = 0; i < s.length; i++) {
				if(s[i].equals("(")) {
					st.add(s[i]);
				} else {
					if(st.isEmpty()) {
						sb.append("NO" + "\n");
						continue outer;
					}
					st.pop();
				}
			}
			if(st.isEmpty()) {
				sb.append("YES" + "\n");
			} else {
				sb.append("NO" + "\n");
			}
		}
		System.out.println(sb);
	}

}
