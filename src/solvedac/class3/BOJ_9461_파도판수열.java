package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9461_파도판수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<Long> list;
	static int T;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T =  Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		list.add((long) 0);
		list.add((long) 1);
		list.add((long) 1);
		list.add((long) 1);
		list.add((long) 2);
		list.add((long) 2);
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			if(list.size() > n) {
				sb.append(list.get(n) + "\n");
			} else {
				for(int i = list.size(); i <= n; i++) {
					list.add(list.get(i-1) + list.get(i-5));
				}
				sb.append(list.get(n) + "\n");
			}
		}
//		System.out.println(list.toString());
		System.out.println(sb);
	}
}
