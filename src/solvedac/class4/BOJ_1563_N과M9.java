package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1563_N과M9 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static List<int[]> res;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = new ArrayList<>();
		arr = new int[n];
		set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[n];
		int[] output = new int[m];
		Arrays.sort(arr);
		
		per(arr, output, visited, 0);
		for(int[] test : res) {
			for(int i = 0; i < test.length; i++) {
				System.out.print(test[i] + " ");
			}
			System.out.println();
		}
	}
	
	static void per(int[] arr, int[] output, boolean[] visited, int depth) {
		
		if(depth == m) {
			int[] temp = new int[m];
			String dup = "";
			for(int i = 0; i < m; i++) {
				temp[i] = output[i];
				dup += (output[i] + "/");
			}
			if(!set.contains(dup)) {
				set.add(dup);
				res.add(temp);
			}
			return ;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
//				if(!map.containsKey(arr[i])) {
//					map.putIfAbsent(arr[i], new ArrayList<>());
//					map.get(arr[i]).add(depth);
//				} else {
//					if(map.get(arr[i]).contains(depth)) continue;
//				}
				output[depth] = arr[i];
				per(arr, output, visited, depth+1);
				visited[i] = false;
			}
		}
	}
}
