package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] popul;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static List<List<Integer>> graph;
	static List<int[]> combRes;
	static int min, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		popul = new int[n];
		arr = new int[n];
		graph = new ArrayList<>();
		combRes = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
			arr[i] = i;
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			for(int j = 0; j < g; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
//		for(List<Integer> list : graph) {
//			for(int t : list) {
//				System.out.print(t + " ");
//			}
//			System.out.println();
//		}
		
		min = Integer.MAX_VALUE;
		res = -1;
		for(int i = 1; i <= n/2; i++) {
			output = new int[i];
			comb(0,0);
		}
		
		if(res == -1) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == output.length) {
			visited = new boolean[n];
			for(int i : output) {
				visited[i] = true;
			}
			
			int[] rev = new int[arr.length - output.length];
			int revIdx = 0;
			for(int i = 0; i < arr.length; i++) {
				if(!visited[i]) {
					rev[revIdx++] = i;
				}
			}
			
//			for(int i : output) {
//				System.out.print(i + " ");
//			}
//			System.out.print("+");
//			for(int i : rev) {
//				System.out.print(i + " ");
//			}
//			System.out.println();

			if (isConnected(output) && isConnected(rev)) {
//				for (int i : output) {
//					System.out.print(i + " ");
//				}
//				System.out.print(getSum(output));
//				System.out.print("+ ");
//				for (int i : rev) {
//					System.out.print(i + " ");
//				}
//				System.out.print(getSum(rev));
//				System.out.println();
				
				res = Math.abs(getSum(output) - getSum(rev));
//				System.out.println(res + " " + min);
				if(res < min) {
					min = res;
				}
			}
			
			return ;
		}
		if(idx == arr.length) return ;
		
		output[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
	
	public static boolean isConnected(int[] tmp) {
		if(tmp.length == 1) return true;
		
		boolean[] check = new boolean[n];
		for(int i = 0; i < tmp.length; i++) {
			for(int e : graph.get(tmp[i])) {
				check[e-1] = true;
			}
		}
		for(int i = 0; i < tmp.length; i++) {
			if(!check[tmp[i]]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int getSum(int[] tmp) {
		int sum = 0;
		
		for(int i = 0; i < tmp.length; i++) {
			sum += popul[tmp[i]];
		}
		
		return sum;
	}
}
