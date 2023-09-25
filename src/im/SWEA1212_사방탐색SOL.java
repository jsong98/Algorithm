package im;

import java.util.Scanner;

// 파리퇴치3

/*
2
5 2
1	3	3	6	7
8	13	9	12	8
4	16	11	12	6
2	4	1	23	2
9	13	4	7	3
6 3
29	21	26	9	5	8
21	19	8	0	21	19
9	24	2	11	4	24
19	29	1	0	21	19
10	29	6	18	4	3
29	11	15	3	3	29
 */

public class SWEA1212_사방탐색SOL {

	// 델타배열 - 4방탐색
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 대각선
	static int[] dr2 = { -1, -1, 1, 1 };
	static int[] dc2 = { -1, 1, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트 케이스 수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 행렬의 크기
			int M = sc.nextInt(); // 스프레이의 세기

			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++)
					arr[r][c] = sc.nextInt();
			}

			// 최대값 변수 선언
			int max = Integer.MIN_VALUE;

			// 2차원 행렬을 행 우선탐색을 하면서
			// (r, c)를 중심으로 상하좌우 탐색, 대각선 탐색

			// 상하좌우 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// (r, c)를 중심으로 상하좌우 탐색
					int sum = 0;
					sum += arr[r][c];
					for (int d = 0; d < 4; d++) {
						// d 방향으로 인접한 원소의 좌표
//						int nr = r + dr[d];
//						int nc = c + dc[d];		// --> (nr, nc)라는 새로운 좌표가 만들어짐.
						for (int m = 1; m < M; m++) {
							int nr = r + dr[d] * m;
							int nc = c + dc[d] * m;

							// 행렬의 경계를 벗어나지 않게 제어
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								sum += arr[nr][nc];
							}
						}
					}

					// 최대값 갱신
					if (sum > max)
						max = sum;
				}
			}

			// 대각선 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// (r, c)를 중심으로 상하좌우 탐색
					int sum = 0;
					sum += arr[r][c];
					for (int d = 0; d < 4; d++) {
						// d 방향으로 인접한 원소의 좌표
						for (int m = 1; m < M; m++) {
							int nr = r + dr2[d] * m;
							int nc = c + dc2[d] * m;

							// 행렬의 경계를 벗어나지 않게 제어
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								sum += arr[nr][nc];
							}
						}
					}

					// 최대값 갱신
					if (sum > max)
						max = sum;
				}
			}

			System.out.println("#" + tc + " " +max);
		}
	}

}
