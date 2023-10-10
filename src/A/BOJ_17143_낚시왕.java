package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
3 3 9
1 1 1000 1 1
1 2 999 2 2
2 1 1000 3 3
2 2 999 4 4
1 3 1000 1 5
3 1 999 2 6
2 3 1000 3 7
3 2 999 4 8
3 3 1000 1 9
*/

public class BOJ_17143_낚시왕 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int r, c, m;
	static Shark[][] map;
	static boolean[][] visited;
	static int[] row;
	static int[] col;
	static int res;
	static List<Shark> sharkList;
	static boolean[] deadList;

	static class Shark {
		int r;
		int c;
		int speed;
		int dir;
		int size;

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[r][c];
		row = new int[2 * r - 2];
		col = new int[2 * c - 2];
		deadList = new boolean[10001];
		int idx = 0;
		for (int i = 0; i < row.length; i++) {
			if (i < r - 1) {
				row[i] = idx++;
			} else {
				row[i] = idx--;
			}
		}
//		System.out.println(Arrays.toString(row));
		idx = 0;
		for (int i = 0; i < col.length; i++) {
			if (i < c - 1) {
				col[i] = idx++;
			} else {
				col[i] = idx--;
			}
		}
//		System.out.println(Arrays.toString(col));

		sharkList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			Shark s = new Shark(sr, sc, speed, dir, size);
			map[sr][sc] = s;
			sharkList.add(s);
		}

		int t = 0;
		while(true) {
//			status();
			fishing(t); // step2
//			status();
			move(); // step3
//			status();
			reset();
			t++;	// step1
			if (t == c) break;
		}
		System.out.println(res);
	}

	public static void fishing(int t) {
		for (int i = 0; i < r; i++) {
			if (map[i][t] != null) {
				Shark s = map[i][t];
				res += s.size;
				deadList[s.size] = true;
				map[i][t] = null;
				return;
			}
		}
	}

	public static void move() {
		visited = new boolean[r][c];
		for (Shark s : sharkList) {
			if(deadList[s.size]) continue;
			int temp = s.speed;
			if (s.dir == 1) { // up
				if (temp < s.r) {
					s.r = s.r - temp;
				} else {
					temp = temp - s.r;
					temp = temp % row.length;
					s.r = row[temp];
					if (temp == 0) {
						s.dir = 1;
					} else if (temp > 0 && temp <= row.length / 2) {
						s.dir = 2;
					} else {
						s.dir = 1;
					}
				}
			} else if (s.dir == 2) { // down
				if (temp < row.length - s.r) {
					int idx = s.r + temp;
					s.r = row[idx];
					if (idx == 0) {
						s.dir = 1;
					} else if (idx > 0 && idx <= row.length / 2) {
						s.dir = 2;
					} else {
						s.dir = 1;
					}
				} else {
					temp = temp - (row.length - s.r);
					temp = temp % row.length;
					s.r = row[temp];
					if (temp == 0) {
						s.dir = 1;
					} else if (temp > 0 && temp <= row.length / 2) {
						s.dir = 2;
					} else {
						s.dir = 1;
					}
				}
			} else if (s.dir == 4) { // left
				if (temp < s.c) {
					s.c = s.c - temp;
				} else {
					temp = temp - s.c;
					temp = temp % col.length;
					s.c = col[temp];
					if (temp == 0) {
						s.dir = 4;
					} else if (temp > 0 && temp <= col.length / 2) {
						s.dir = 3;
					} else {
						s.dir = 4;
					}
				}
			} else { // right
				if (temp < col.length - s.c) {
					int idx = s.c + temp;
					s.c = col[idx];
					if (idx == 0) {
						s.dir = 4;
					} else if (idx > 0 && idx <= col.length / 2) {
						s.dir = 3;
					} else {
						s.dir = 4;
					}
				} else {
					temp = temp - (col.length - s.c);
					temp = temp % col.length;
					s.c = col[temp];
					if (temp == 0) {
						s.dir = 4;
					} else if (temp > 0 && temp < col.length / 2) {
						s.dir = 3;
					} else {
						s.dir = 4;
					}
				}
			}
			if (visited[s.r][s.c] && map[s.r][s.c] != null) {
				Shark os = map[s.r][s.c];
				if (os.size < s.size) {
					map[s.r][s.c] = s;
					deadList[os.size] = true;
				} else if(os.size > s.size){
					deadList[s.size] = true;
				}
			} else {
				visited[s.r][s.c] = true;
				map[s.r][s.c] = s;
			}
		}
	}
	
	public static void reset() {
		map = new Shark[r][c];
		for(Shark s : sharkList) {
			if(deadList[s.size]) continue;
			map[s.r][s.c] = s; 
		}
	}
	
	public static void status() {
		for(Shark s : sharkList) {
			if(deadList[s.size]) continue;
			System.out.println(s.size + " : " + s.r + " " + s.c + " " + s.dir );
		}
		System.out.println();
	}
}
