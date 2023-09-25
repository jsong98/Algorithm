package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int truthNum;
	static Set<Integer> truthSet;
	static List<int[]> party;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		boolean[] truthArr = new boolean[n+1];
		party = new ArrayList<int[]>();
		truthSet = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		truthNum = Integer.parseInt(st.nextToken());
		if(truthNum != 0) {
			for(int i = 0; i < truthNum; i++) {
				truthSet.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < m; i++) {
			boolean chk = false;
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] temp = new int[num];
			for(int j = 0; j < num; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			party.add(temp);
		}
		
		boolean chk = true;
		while(chk) {
			chk = false;
			for(int[] arr : party) {
				for(int i = 0; i < arr.length; i++) {
					if(truthSet.contains(arr[i])) {
						for(int j = 0; j < arr.length; j++) {
							if(!truthSet.contains(arr[j])) {
								chk = true;
								truthSet.add(arr[j]);
							}
						}
					}
				}
			}
		}
		
		int res = 0;
		outer:
		for(int[] arr : party ) {
			for(int i = 0; i < arr.length; i++) {
				if(truthSet.contains(arr[i])) continue outer;
			}
			
			res += 1;
		}
		
//		System.out.println(truthSet.toString());
		
		System.out.println(res);
	}

}
