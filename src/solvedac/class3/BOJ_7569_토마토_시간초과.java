package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7569_토마토_시간초과 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int h;
	static int n;
	static int m;
	static int[] dh = {1,-1};
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[h][n][m];
		for(int i = 0; i < h; i++) {			// 상자 개수
			for(int j = 0; j < n; j++) {		// 상자의 row
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {	// 상자의 column
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int cnt = 0;
		while(remain(arr)) {
			List<int[]> change = new ArrayList<int[]>(); //다음 날 변화할 토마토들의 좌표 저장
			// 다음 날 바뀔 토마토들의 좌표를 찾아서 change에 저장
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < n; j++) {
					for(int k = 0; k < m; k++) {
						if(arr[i][j][k]==0) {
							for(int d = 0; d < 4; d++) {
								int row = j+dr[d];
								int col = k+dc[d];
								if(row >= 0 && row < n && col >= 0 && col < m && arr[i][row][col] == 1) {
									change.add(new int[] {i, j, k});
								}
							}
							for(int t = 0; t < 2; t++) {
								int hei = i+dh[t];
								if(hei >= 0 && hei < h && arr[hei][j][k] == 1) {
									change.add(new int[] {i, j, k});
								}
							}
						}
					}
				}
			}
			if(change.isEmpty()) {
				cnt = -1;
				break;
			}
			for(int[] c : change) {		// 토마토 바꾸기
				arr[c[0]][c[1]][c[2]] = 1;
			}

			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean remain(int[][][] arr) {
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(arr[i][j][k]==0) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
