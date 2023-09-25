package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2108_통계학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		int[] arr = new int[N];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[] freq = new int[8001];	// freq[0] = -4000
		
		for(int i = 0; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			arr[i] = k;
			if(k < min) {
				min = k;
			}
			if(k > max) {
				max = k;
			}
			sum += k;
			
			freq[k+4000]++;
		}
		Arrays.sort(arr);
		
		int max2 = Integer.MIN_VALUE;
		for(int i = 0; i < freq.length; i++) {
			if(freq[i]>max2) {
				max2 = freq[i];
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < freq.length; i++) {
			if(freq[i] == max2) {
				list.add(i);
			}
		}
		
		// 평균
		if(sum>0) {
			float avg = (float)sum/arr.length;
			avg = (int)(avg + 0.5);
			System.out.println((int)avg);
		} else if(sum < 0) {
			float avg = (float)(-1)*sum/arr.length;
			avg = (int)(avg+0.5);
			System.out.println((-1)*(int)avg);
		} else {
			System.out.println(0);
		}
		// 중앙값
		System.out.println(arr[arr.length/2]);
		// 최빈값
		if(list.size() == 1) {
			System.out.println(list.get(0)-4000);
		} else {
			System.out.println(list.get(1)-4000);
		}
		// 범위
		System.out.println(max-min);
	}

}
