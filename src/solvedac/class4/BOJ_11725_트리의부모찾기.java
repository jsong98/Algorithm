package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
1 6
6 3
3 5
4 1
2 4
4 7
*/

public class BOJ_11725_트리의부모찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<List<Integer>> tree;
	static boolean[] visited;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int srt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			tree.get(srt).add(end);
			tree.get(end).add(srt);
		}
		parents = new int[n + 1];

		Queue<Integer> que = new LinkedList<>();
		visited[1] = true;
		que.offer(1);
		while (!que.isEmpty()) {
			int p = que.poll();
			for (int c : tree.get(p)) {
				if (visited[c])
					continue;
				parents[c] = p;
				visited[c] = true;
				que.offer(c);
			}
		}
		for(int i = 2; i <= n; i++) {
			sb.append(parents[i] + "\n");
		}
		System.out.println(sb);
	}
}
