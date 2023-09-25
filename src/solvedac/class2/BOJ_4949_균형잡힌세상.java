package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		Stack<Character> st = new Stack<>();
		String str = br.readLine();
		while(true) {
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i)=='('||str.charAt(i)=='[') {
					st.add(str.charAt(i));
				}
				if(str.charAt(i)==')') {
					if(st.isEmpty()) {
						System.out.println("no");
						break;
					}
					if(st.pop()!='(') {
						System.out.println("no");
						break;
					}
				}
				if (str.charAt(i) == ']') {
					if(st.isEmpty()) {
						System.out.println("no");
						break;
					}
					if(st.pop()!='[') {
						System.out.println("no");
						break;
					}
				}
				if(str.charAt(i)=='.'&& st.isEmpty()) System.out.println("yes");
				else if(str.charAt(i)=='.'&&!st.isEmpty()) System.out.println("no");
			}
			st.clear();
			str = br.readLine();
			if(str.equals(".")) break;
		}
	}

}
