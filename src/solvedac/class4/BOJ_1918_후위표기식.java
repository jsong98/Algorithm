package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BOJ_1918_후위표기식 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static HashMap<Character, Integer> isp = new HashMap<>();
	static Stack<Character> st = new Stack<>();
	static Stack<Integer> stInt = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			init();
			String str = "(" + br.readLine() + ")";
			List<Character> post = makePost(str);
			String res = "";
			
			for(int i = 0; i < post.size(); i++) {
				res += post.get(i);
			}
			System.out.println(res);
	}
	
	public static void init() {
		isp.put('(', 0);
		isp.put('+', 1);
		isp.put('-', 1);
		isp.put('*', 2);
		isp.put('/', 2);
	}
	
	public static List<Character> makePost(String str) {
		List<Character> res = new ArrayList<Character>();
		char top = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)<=90 && str.charAt(i)>=65) {
				res.add(str.charAt(i));
				continue;
			}
			
			if(st.isEmpty()) {
				st.add(str.charAt(i));
				top = st.peek();
			}
			
			if(str.charAt(i) == '(') {
				st.add(str.charAt(i));
				top = st.peek();
			} else if(str.charAt(i) == ')') {
				while(!(st.peek()=='(')) {
					res.add(st.pop());
				}
				st.pop();
				if(!(st.isEmpty())) {
					top = st.peek();
				}
				
			} else {
				if(isp.get(top) < isp.get(str.charAt(i))) {
					st.add(str.charAt(i));
					top = st.peek();
				} else if(isp.get(top) >= isp.get(str.charAt(i))) {
					while(isp.get(top) >= isp.get(str.charAt(i))) {
						res.add(st.pop());
						if(!(st.isEmpty())) {
							top = st.peek();
						}
					}
					st.add(str.charAt(i));
					top = st.peek();
				}
			}
			
		}
		
		return res;
	}
}
