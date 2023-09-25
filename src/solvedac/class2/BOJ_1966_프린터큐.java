package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<int[]> que = new LinkedList<int[]>();
			int count = 0;
			ArrayList<Integer> arr = new ArrayList<>();		// 중요도를 오름차순으로 저장할 list
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int imp = Integer.parseInt(st.nextToken());
				arr.add(imp);
				
				if(i == M) {
					que.add(new int[] {imp, 1});
				}
				que.add(new int[] {imp, 0});
			}
			Collections.sort(arr);
			
			while(true) {
				int[] chk = que.poll();
				if(chk[0] == arr.get(arr.size()-1)) {
					arr.remove(arr.size()-1);
					count++;
					if(chk[1] == 1) {
						break;
					}
				} else {
					que.add(chk);
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}

}
