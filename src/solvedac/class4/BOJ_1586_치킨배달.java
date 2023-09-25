package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1586_치킨배달 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] arr;
	static List<int[]> homeList;
	static HashMap<Integer, int[]> map;
	static List<int[]> chickenCase;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		homeList = new ArrayList<int[]>();
		map = new HashMap<>();
		chickenCase = new ArrayList<>();
		
		int no = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					homeList.add(new int[] {i, j});
				}
				if (arr[i][j]==2) {
					map.put(++no, new int[] {i, j});
				}
			}
		}
		
		int[] chickenArr = new int[no];
		for(int i = 1; i <= no; i++) chickenArr[i-1] = i;
		boolean[] visited = new boolean[no];
		
		comb(chickenArr, visited, 0, m);
		
//		for(int[] test : chickenCase) {
//			System.out.println(Arrays.toString(test));
//		}
		
		int sum = 0;
		int d = 0;
		int min1 = Integer.MAX_VALUE;
		for(int[] chicken : chickenCase) {
			sum = 0;
			for(int i = 0; i < homeList.size(); i++) {
				int min2 = Integer.MAX_VALUE;
				for(int j = 0; j < chicken.length; j++) {
					d = getDis(homeList.get(i), map.get(chicken[j]));
//					System.out.println(i + " " + j + " " + d);
					if(d < min2) min2 = d;
				}
				sum += min2;
			}
			if(sum<min1) min1 = sum;
		}
		
		System.out.println(min1);
	}
	
	static void comb(int[] arr, boolean[] visited, int start, int r) {
		if(r==0) {
			int[] temp = new int[m];
			int cnt = 0;
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					temp[cnt++] = i+1;
				}
			}
			chickenCase.add(temp);
		}
		
		for(int i = start; i < arr.length; i++) {
			visited[i] = true;
			comb(arr, visited, i+1, r-1);
			visited[i] = false;	
		}
	}
	
	public static int getDis(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0]-pos2[0]) + Math.abs(pos1[1]-pos2[1]);
	}
}
