package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static HashMap<String, Integer> map;
	static String[] arr;
	static String[] output;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			arr = new String[n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String categ = st.nextToken();
				
				if(map.containsKey(categ)) {
					map.put(categ, map.get(categ)+1);
				} else {
					map.put(categ, 1);
				}
				
			}
			int result = 1;
			
			for(int val : map.values()) {
				result *= (val + 1);
			}
			
			sb.append(result-1 + "\n");
		}
		System.out.println(sb);
	}
}
