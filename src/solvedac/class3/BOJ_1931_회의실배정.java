package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<int[]> res;
	static List<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		res = new ArrayList<>();
		list = new ArrayList<>();
		for(int i = 0; i <n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		int[] target = list.get(0);
		res.add(target);
		int idx = 0;
		for(int i = 1; i < n; i++) {
			int[] tmp = list.get(i);
			if(tmp[0] >= res.get(idx)[1]) {
				res.add(tmp);
				idx++;
			}
		}
		
		System.out.println(res.size());
	}
	
}
