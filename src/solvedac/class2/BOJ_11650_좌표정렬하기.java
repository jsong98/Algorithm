package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11650_좌표정렬하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] temp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			list.add(temp);
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) {
					return o1[0]-o2[0];
				} else {
					return o1[1]-o2[1];
				}
			}
		});
		
		for(int[] arr : list) {
			sb.append(arr[0] + " " + arr[1] + "\n");
		}
		System.out.println(sb);
	}

}
