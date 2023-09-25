package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		int res = 0;
		while(!que.isEmpty()) {
			if(que.size() == 1) {
				res = que.poll();
				break;
			}
			que.poll();
			if(que.size() == 1) {
				res = que.poll();
				break;
			}
			int i = que.poll();
			que.add(i);
		}
		System.out.println(res);
	}

}
