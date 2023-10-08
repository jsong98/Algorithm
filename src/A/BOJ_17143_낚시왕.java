package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int r, c, m;
	static Shark[][] map;
	static boolean[][] visited;
	static int[] row;
	static int[] col;
	static int res;

	static class Shark {
		int r;
		int c;
		int speed;
		int dir;
		int size;

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
			this.speed = speed;
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[r][c];
		row = new int[2*r-2];
		col = new int[2*c-2];
		int idx = 0;
		for(int i = 0; i < row.length; i++) {
			if(i < r-1) {
				row[i] = idx++;
			} else {
				row[i] = idx--;
			}
		}
		System.out.println(Arrays.toString(row));
		idx = 0;
		for(int i = 0; i < col.length; i++) {
			if(i < c-1) {
				col[i] = idx++;
			} else {
				col[i] = idx--;
			}
		}
		System.out.println(Arrays.toString(col));

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken())-1;
			int sc = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			Shark s = new Shark(sr, sc, speed, dir, size);
			map[sr][sc] = s;
		}

		int t = 0;
		t++; // step1
		fishing(t); // step2
		move(); // step3;
	}

	public static void fishing(int t) {
		for (int i = 0; i < r; i++) {
			if (map[i][t] != null) {
				res += map[i][t].size;
				map[i][t] = null;
				return;
			}
		}
	}

	public static void move() {
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != null && !visited[i][j]) {
					Shark s = map[i][j];
					int temp = s.speed;
					if (s.dir == 0) {
						temp = temp % row.length;
						int tr = s.r;
						int idx = 0;
						while(tr != 0) {
							tr--;
							idx++;
						}
						temp -= idx;
					} else if(s.dir == 1) {
						
					} else if(s.dir == 2) {
						
					} else {
						
					}
				}
			}
		}
	}

	/*
	  0 1 2 3 4 5
	-     *
	0: 2 -> 2
	1: 2 -> 1
	2: 2 -> 0
	3: 2 -> 1
	4: 2 -> 2
	5: 2 -> 3
	6: 2 -> 4
	7: 2 -> 5
	8: 2 -> 4
	9: 2 -> 3
	10: 2 -> 2
	11: 2 -> 1
	12: 2 -> 0
	13: 2 -> 1
	14: 2 -> 2
	15: 2 -> 3
	16: 2 -> 4
	*/
	
	public static int dirConvert(int d) {
		if (d == 0)
			return 1;
		if (d == 1)
			return 0;
		if (d == 2)
			return 3;
		if (d == 3)
			return 2;

		return 0;
	}

}
