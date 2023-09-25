package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
//		List<Integer> deleted = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K==1) {
			System.out.print("<");
			for(int i = 1;i<=N;i++) {
				if(i==N) {
					System.out.print(i);
				} else {
					System.out.print(i + ", ");
				}
			}
			System.out.print(">");
			return ;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		int idx = 1;
		System.out.print("<");
		while(!(que.isEmpty())) {
			int temp = que.poll();
			if(idx!=0) {
				que.add(temp);
			} else if(que.isEmpty()) {
				sb.append(temp);
			} else {
				sb.append(temp + ", ");
			}
			idx = (idx+1)%K;
		}
		System.out.print(sb);
		System.out.print(">");
		
//--------------------------------------------------------
		
//		int idx = 0;
//		
//		int[] arr = new int[N];
//		for(int i = 0; i < N; i++) {
//			arr[i] = i+1; 
//		}
//		
//		for(int i = 0; i < K-1; i++) {
//			idx++;
//		}
//		deleted.add(arr[idx]);
//		
//		while(!(deleted.size()==N)) {
//			for(int i = 0; i < K; i++) {
//				int j = 1;
//				if(deleted.contains(arr[(idx+1)%N])) {
//					while(deleted.contains(arr[(idx+j)%N])) {
//						j++;
//					}
//					idx += j;
//				} else {
//					idx += 1;
//				}
//			}
//			idx = idx % N;
//			deleted.add(arr[idx]);
////			System.out.println(deleted.toString() + ", " + idx);
//		}
//		
//		System.out.print("<");
//		for(int i = 0; i < N; i++) {
//			if(i==deleted.size()-1) {
//				System.out.print(deleted.get(i));
//			} else {
//				System.out.print(deleted.get(i) + ", ");
//			}
//		}
//		System.out.print(">");
	}
}
