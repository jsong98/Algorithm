package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
			} else if (cmd.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
			} else if (cmd.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (cmd.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (cmd.equals("top")) {
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
