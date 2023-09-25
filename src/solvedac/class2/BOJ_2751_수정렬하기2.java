package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// QuickSort
// Arrays.sort보다 Collections.sort가 더 빠름

public class BOJ_2751_수정렬하기2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			int j = Integer.parseInt(br.readLine());
			list.add(j);
		}
		Collections.sort(list);
		for(int i : list) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
	
//	public static void sort(int[] a) {
//		l_pivot_sort(a, 0, a.length-1);
//	}
//	
//	private static void l_pivot_sort(int[]a, int lo, int hi) {
//		if(lo>=hi) return;
//		
//		int pivot = partition(a, lo, hi);
//		
//		l_pivot_sort(a, lo, pivot-1);
//		l_pivot_sort(a, pivot+1, hi);
//	}
//	
//	private static int partition(int[] a, int left, int right) {
//		int lo = left;
//		int hi = right;
//		int pivot = a[left];
//		
//		while(lo < hi) {
//			while(a[hi] > pivot && lo < hi) {
//				hi--;
//			}
//			while(a[lo] <= pivot && lo < hi) {
//				lo++;
//			}
//			swap(a, lo, hi);
//		}
//		
//		swap(a, left, lo);
//		
//		return lo;
//	}
//	
//	private static void swap(int[] a, int i, int j) {
//		int temp = a[i];
//		a[i] = a[j];
//		a[j] = temp;
//	}
	
}
