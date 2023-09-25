package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int res = 0;
		
		for(int i = 0; i < K; i++) {
			int m = Integer.parseInt(br.readLine());
			if(m!=0) {
				st.add(m);
			} else {
				if(!st.isEmpty()) {
					st.pop();
				}
			}
		}
		
		while(!st.isEmpty()) {
			res += st.pop();
		}
		
		System.out.println(res);
	}

}
