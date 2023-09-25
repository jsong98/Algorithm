package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dr = {0,1,1,1,0,-1,-1,-1};
	static int[] dc = {1,1,0,-1,-1,-1,0,1};
	static boolean[][] visited = new boolean[19][19];
	
	public static void main(String[] args) throws IOException {
		int[][] arr = new int[19][19];
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isEnd = false;
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				int cnt = 0;
				if(arr[i][j]!=0 && visited[i][j]==false) {
					int target = arr[i][j];
					int r = i;
					int c = j;
//					System.out.println(r + ", " + c + ", " + target);
					visited[r][c] = true;
					cnt++;
					for(int s = 0; s < 8; s++) {
						if(r+dr[s]>=0&&r+dr[s]<19&&c+dc[s]>=0&&c+dc[s]<19&&visited[r+dr[s]][c+dc[s]]==false) {
							if(arr[r+dr[s]][c+dc[s]] == target) {
//								System.out.println(i + ", " + j + ", " + target + ", " + dr[s] + ", " + dc[s]);
								while(r+dr[s]>=0&&r+dr[s]<19&&c+dc[s]>=0&&c+dc[s]<19 && arr[r+dr[s]][c+dc[s]] == target) {
									visited[r+dr[s]][c+dc[s]] = true;
									cnt++;
									r += dr[s];
									c += dc[s];
								}
								if(cnt==5) {
									isEnd = true;
									System.out.println(arr[i][j] + "\n" + (i+1) + " " + (j+1));
								}
							}
						}
					}
				}
			}
		}
		if(!isEnd) System.out.println(0);
	}

}
