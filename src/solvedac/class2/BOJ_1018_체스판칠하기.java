package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판칠하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for(int r = 0; r < N; r++) {
			arr[r] = br.readLine().toCharArray();
		}
		int min = Integer.MAX_VALUE;
		for(int r = 0; r <= N-8; r++) {
			for(int c = 0; c <= M-8; c++) {
				int i = 0;
				int j = 0;
				if(arr[r][c] == 'W') {
					i = shift(arr, r, c, 'W');
					arr[r][c] = 'B';
					j = shift(arr, r, c, 'B')+1;
					
					arr[r][c] = 'W';
					i = Math.min(i, j);
				} else {
					i = shift(arr, r, c, 'B');
					arr[r][c] = 'W';
					j = shift(arr, r, c, 'W')+1;
					
					arr[r][c] = 'B';
					i = Math.min(i, j);
				}
				if(i < min) {
					min = i;
				}
			}
		}
		System.out.println(min);
	}
	
	public static int shift(char[][] arr, int r, int c, char std) {
		int cnt = 0;
		int same = (r+c)%2;
		int tempC = c;
		
		for(int i = 0; i < 8; i++) {
			c = tempC;
			for(int j = 0; j < 8; j++) {
				if((r+c)%2 == same) {
					if(!(arr[r][c] == std)) {
						cnt++;
					}
				} else {
					if(arr[r][c] == std) {
						cnt++;
					}
				}
				
				c++;
			}
			r++;
		}
		
		return cnt;
	}
}
