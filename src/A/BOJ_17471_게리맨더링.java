package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] popul;
	static int[] combArr;
	static int[] output;
	static boolean[] visited;
	static List<List<Integer>> graph;
	static int min, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		popul = new int[n];
		combArr = new int[n];
		graph = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 1;
		for(int i = 0; i < n; i++) {
			combArr[i] = idx++;
		}
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int end = Integer.parseInt(st.nextToken());
				graph.get(i).add(end);
			}
		}
		
		res = -1;
		min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n/2; i++) {
			output = new int[i];
			comb(0,0);
		}
		
		if(res == -1) {
			System.out.println(res);
		} else {
			System.out.println(min);
		}
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == output.length) {
			visited = new boolean[n+1];
			for(int i = 0; i < output.length; i++) {
				visited[output[i]] = true;
			}
			int[] rev = new int[n-output.length];
			int revIdx = 0;
			for(int i = 1; i < visited.length; i++) {
				if(!visited[i]) {
					rev[revIdx++] = i;
				}
			}
//			System.out.println(Arrays.toString(output));
//			System.out.println(Arrays.toString(rev));
//			System.out.println();
			
			if(isConnected(output) && isConnected(rev)) {
//				System.out.println(Arrays.toString(output));
//				System.out.println(Arrays.toString(rev));
				res = Math.abs(getSum(output) - getSum(rev));
//				System.out.println(res);
				if(res < min) {
					min = res;
				}
			}
			
			return;
		}
		
		if(idx == combArr.length) return ;
		
		output[sidx] = combArr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
	
	public static boolean isConnected(int[] tmp) {
		if(tmp.length==1) return true;
		
		boolean[] check = new boolean[n+1];
		List<Integer> tmpList = new ArrayList<>();
		for(int i = 0; i < tmp.length; i++) {
			tmpList.add(tmp[i]);
		}
		check[tmp[0]] = true;
		bfs(check, tmp[0], tmpList);
		
		for(int i = 0; i < tmp.length; i++) {
			if(!check[tmp[i]]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void bfs(boolean[] check, int k, List<Integer> tmpList) {
		for(int i : graph.get(k)) {
			if(!tmpList.contains(i)) continue;
			if(!check[i]) {
				check[i] = true;
				bfs(check, i, tmpList);
			}
		}
	}

	public static boolean isConnected(int[] tmp1, int[] tmp2) {
		
		
		return true;
	}

	public static int getSum(int[] tmp) {
		int sum = 0;
		
		for(int i = 0; i < tmp.length; i++) {
			sum += popul[tmp[i]-1];
		}
		
		return sum;
	}
}
