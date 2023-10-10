package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

4 3 3 2 / 2 1 1 0

5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28

*/

public class BOJ_16926_배열돌리기1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, num;
	static int[][] arr;
	static int[][] temp;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < num; i++) {
			rotate();
		}
		
		for (int[] test : arr) {
			for(int i : test) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void rotate() {
		temp = new int[n][m];
		
		// 각 변마다 움직이는 횟수
		int move = 0;
		// 기준점 좌표
		int stdR = 0;
		int stdC = m - 1;
		// 움직이는 좌표
		int r = 0;
		int c = m - 1;
		// 각 변의 끝
		int topEdge = 0;
		int bottomEdge = n - 1;
		int leftEdge = 0;
		int rightEdge = m - 1;

		while (true) {
			
			move = rightEdge - leftEdge + 1;
			for (int i = 0; i < move; i++) { // 위
				if (c != leftEdge) {
					temp[r][c - 1] = arr[r][c];
					c--;
				} else {
					temp[r + 1][c] = arr[r][c];
					r++;
				}
			}

			move = bottomEdge - topEdge;

			for (int i = 0; i < move; i++) { // 왼쪽
				if (r != bottomEdge) {
					temp[r + 1][c] = arr[r][c];
					r++;
				} else {
					temp[r][c + 1] = arr[r][c];
					c++;
				}
			}

			move = rightEdge - leftEdge;

			for (int i = 0; i < move; i++) { // 아래
				if (c != rightEdge) {
					temp[r][c + 1] = arr[r][c];
					c++;
				} else {
					temp[r - 1][c] = arr[r][c];
					r--;
				}
			}

			move = bottomEdge - topEdge - 1;

			for (int i = 0; i < move; i++) { // 오른쪽
				if (r != stdR + 1) {
					temp[r - 1][c] = arr[r][c];
					r--;
				} else {
					temp[r - 1][c] = arr[r][c];
					c--;
				}
			}
			if (leftEdge + 1 == rightEdge || topEdge + 1 == bottomEdge) {
				break;
			}
			topEdge++;
			leftEdge++;
			bottomEdge--;
			rightEdge--;
			stdR++;
			stdC--;
			r = stdR;
			c = stdC;

		}
		
		arr = temp;
	}

}
