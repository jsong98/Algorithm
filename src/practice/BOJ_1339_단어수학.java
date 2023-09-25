package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1339_단어수학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<String> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		int[] arr = new int[26];
		
		int max = 0;
//		System.out.println('A' - '0');
//		System.out.println('Z' - '0');
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			int len = s.length();
			if(len > max) {
				max = len;
			}
			for(int j = 0; j < s.length(); j++) {
				arr[(s.charAt(j)-'0')-17] += Math.pow(10, len-1);
				len--;
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				pq.offer(arr[i]);
			}
		}
		
		int num = 9;
		int sum = 0;
		while(!pq.isEmpty()) {
			int i = pq.poll();
			sum += num * i;
			num--;
		}
		
		System.out.println(sum);
	}
	
}
