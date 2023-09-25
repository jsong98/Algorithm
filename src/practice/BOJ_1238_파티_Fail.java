package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// dfs & dijkstra algo

public class BOJ_1238_파티_Fail {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int startFix;
	static int endFix;
	static boolean[] visited;
	static int move;
	static int depth;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		int[][] road = new int[m][3];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dis = new int[n+1][n+1];
		for(int[] arr : dis) Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i = 0; i < n+1; i++) dis[i][i] = 0;
		HashMap<Integer, List<int[]>> graph = new HashMap<>();
		for(int[] arr : road) {
			graph.putIfAbsent(arr[0], new ArrayList<int[]>());
			graph.get(arr[0]).add(new int[] {arr[1], arr[2]});
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {1, 1});
		int[] c = new int[] {1, 0, -1, 0};
		int[] r = new int[] {0, 1, 0, -1};
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			for (int k = 0; k < c.length; k++) {
				int tempC = x + c[k];
				int tempR = y + r[k];
				if(tempC == tempR) continue;
				move = 0;
				visited = new boolean[n+1];
				ArrayList<Integer> list = new ArrayList<>();
				Stack<Integer> stack = new Stack<>();
				if (tempC >= 1 && tempR >= 1 && tempC < n+1 && tempR < n+1) {
					startFix = tempC;
					endFix = tempR;
					System.out.println("index : " + tempC + ", " + tempR);
					minMove(tempC, graph, list);
					Collections.sort(list);
					System.out.print("list: ");
					for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", ");
					System.out.println();
					if(dis[tempC][tempR] > list.get(0)) {
						dis[tempC][tempR] = list.get(0);
						que.offer(new int[] {tempC, tempR});
					}
					System.out.println("dis: "+ list.get(0));
					for(int[] arr : dis) System.out.println(Arrays.toString(arr));
				}
			}
		}
		
		int[] res = new int[n+1];
		for(int i = 1; i <= n; i++) {
			res[i] = dis[i][dest] + dis[dest][i];
		}
		Arrays.sort(res);
		System.out.println(res[res.length-1]);
		
	}
	
	public static void minMove(int start, HashMap<Integer, List<int[]>> graph, ArrayList<Integer> list) {
		
		for(int[] arr : graph.get(start)) {
			if(visited[arr[0]]) continue;
			System.out.println(Arrays.toString(arr));
			if(arr[0] == endFix) {
				System.out.println("move = " + move);
				System.out.println("arr[1] = " + arr[1]);
				move += arr[1];
				System.out.println("이동거리 : " + move);
				list.add(move);
				move = 0;
				for(int i = 0; i < visited.length; i++) visited[i] = false;
				continue;
			} else if(arr[0] == startFix) {
				continue;
			} else {
				System.out.println("move : arr[1] = " + move + " : " + arr[1]);
				move = move + arr[1];
				visited[arr[0]] = true;
				minMove(arr[0], graph, list);
			}
		}
		
	}

}
