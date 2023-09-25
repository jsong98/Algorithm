package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dijkstra algo

public class BOJ_4485_젤다 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int n = 1;
		int tc = 1;
		while(n != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) {
//				System.out.println(n);
				break;
			}
			int[][] arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int minVal = Integer.MAX_VALUE;
			
//			Map<int[], Integer> map = new HashMap<int[], Integer>();
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					map.putIfAbsent(new int[] {i,j}, arr[i][j]);
//					System.out.println(arr[i][j]);
//				}
//			}
			
			int[][] dis = new int[n][n];
			for(int i = 0; i < n; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
			dis[0][0] = arr[0][0];
			
			
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {0, 0});
			
			int[] c = new int[] {1, 0, -1, 0};
			int[] r = new int[] {0, 1, 0, -1};
			
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int x = cur[0];
				int y = cur[1];
				for (int k = 0; k < c.length; k++) {
					int tempC = x + c[k];
					int tempR = y + r[k];
					if (tempC >= 0 && tempR >= 0 && tempC < n && tempR < n) {
						if (dis[x][y] + arr[tempC][tempR] < dis[tempC][tempR]) {
							dis[tempC][tempR] = dis[x][y] + arr[tempC][tempR];
//							System.out.println(tempC + ", " + tempR + ", " + dis[tempC][tempR]);
							que.offer(new int[] {tempC, tempR});
						}
					}
				}
			}
//			System.out.println("----------------");
			sb.append("Problem " + tc + ": " + dis[n-1][n-1] + "\n");
			tc++;
		}
		System.out.println(sb);
		
	}

}
