package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620_포켓몬마스터 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, String> map;
	static int n, m; 
	
	public static void main(String[] args) throws IOException {
		map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int idx = 1;
		for(int i = 0; i < n; i++) {
			String s1 = br.readLine();
			String s2 = Integer.toString(idx++);
			map.put(s1, s2);
			map.put(s2, s1);
		}
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			sb.append(map.get(s) + "\n");
		}
		
		System.out.println(sb);
	}

}
