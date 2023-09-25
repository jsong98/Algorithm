package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class BOJ_1874_스택수열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 1; i <= num; i++) {
			que.offer(i);
		}
		boolean isPos = true;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());
			if(stack.isEmpty()) {
				while(que.peek() <= n) {
					stack.push(que.poll());
					sb.append("+\n");
					if(que.peek() == null) {
						break;
					}
				}
				stack.pop();
				sb.append("-\n");
				continue;
			} else if(n < stack.peek()){
				if(n != stack.peek()) {
					isPos = false;
					break;
				} else {
					stack.pop();
					sb.append("-\n");
					continue;
				}
			} else if(n > stack.peek()){
				while(que.peek() <= n) {
					stack.push(que.poll());
					sb.append("+\n");
					if(que.peek() == null) {
						break;
					}
				}
				stack.pop();
				sb.append("-\n");
				continue;
			} else if(n == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				continue;
			}
		}
		if(!isPos) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}

}
