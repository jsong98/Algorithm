package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static HashMap<Integer, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] copy = new int[n];
		copy = Arrays.copyOfRange(arr, 0, n);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(copy));
		
		Arrays.sort(copy);
//		System.out.println(Arrays.toString(copy));
		map = new HashMap<>();
		int idx = 0;
		map.put(copy[0], idx++);
		for(int i = 1; i < n; i++) {
			if(copy[i-1] == copy[i]) {
				continue;
			} else {
				map.put(copy[i], idx++);
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(map.get(arr[i]) + " ");
		}
	}

}
