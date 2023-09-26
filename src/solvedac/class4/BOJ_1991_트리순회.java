package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static HashMap<String, Node> tree;
	static String res;
	
	static class Node { 
		String root;
		String value;
		String left;
		String right;
		
		public Node(String value) {
			this.value = value;
		}
		
		public void setChild(String left, String right) {
			this.left = left;
			this.right = right;
		}
		
		public void setRoot(String root) {
			this.root = root;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		tree = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String value = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			tree.putIfAbsent(value, new Node(value));
			tree.putIfAbsent(left, new Node(left));
			tree.putIfAbsent(right, new Node(right));
			
			tree.get(value).setChild(left, right);
			tree.get(left).setRoot(value);
			tree.get(right).setRoot(value);
		}
		
		
		StringBuilder sb = new StringBuilder();
		preorder("A", sb);
		System.out.println(sb);
		
		sb = new StringBuilder();
		inorder("A", sb);
		System.out.println(sb);
		
		sb = new StringBuilder();
		postorder("A", sb);
		System.out.println(sb);
		
	}
	
	public static void preorder(String cur, StringBuilder sb) {
		Node node = tree.get(cur);
		
		sb.append(cur);
		
		if(node.left != null && !node.left.equals(".")) {
			preorder(node.left, sb);
		}
		
		if(node.right != null && !node.right.equals(".")) {
			preorder(node.right, sb);
		}
	}

	public static void inorder(String cur, StringBuilder sb) {
		Node node = tree.get(cur);

		if (node.left != null && !node.left.equals(".")) {
			inorder(node.left, sb);
		}
		
		sb.append(cur);

		if (node.right != null && !node.right.equals(".")) {
			inorder(node.right, sb);
		}
	}

	public static void postorder(String cur, StringBuilder sb) {
		Node node = tree.get(cur);

		if (node.left != null && !node.left.equals(".")) {
			postorder(node.left, sb);
		}

		if (node.right != null && !node.right.equals(".")) {
			postorder(node.right, sb);
		}
		
		sb.append(cur);
	}
}
