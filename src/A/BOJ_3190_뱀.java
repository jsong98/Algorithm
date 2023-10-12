package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*

*/

public class BOJ_3190_뱀 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, k, l;
	static int[][] map;
	static HashMap<Integer, String> dirChange;
	static Snake snake;
	
	static class Snake {
		int r;
		int c;
		int dir;	// 0, 1, 2, 3 == 우 하 좌 상
		Queue<Integer> que;
		
		public Snake(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			que = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		int num = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = num++;
			}
		}	// map의 각 위치를 식별하기 위해 넘버링
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 111111 + i;
		}	// 사과가 있는 위치는 0으로
		snake = new Snake(1, 1, 0);	// 뱀 초기화
		snake.que.add(map[1][1]);	// 시작 위치를 que에 넣어줌.
		dirChange = new HashMap<>();
//		for(int[] test : map) {
//			System.out.println(Arrays.toString(test));
//		}
		
		l = Integer.parseInt(br.readLine());
		for(int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			dirChange.put(t, d);
		}
		
		int t = 0;
		int d = 1;
		while(true) {
			t++;
			move();
//			System.out.println(t + " : ("  + snake.dir + ") " + snake.r + " " + snake.c + " <" + snake.que.size() + ">");
			
			if(snake.r < 1 || snake.r > n || snake.c < 1 || snake.c > n) {
//				System.out.println("chk1");
				break;
			}
			if(snake.que.contains(map[snake.r][snake.c])) {
//				System.out.println("chk2");
				break;
			}
			
			if(map[snake.r][snake.c] > 100000) {
				map[snake.r][snake.c] = 100000 - d++;
				snake.que.add(map[snake.r][snake.c]);
			} else {
				snake.que.add(map[snake.r][snake.c]);
				snake.que.poll();
			}
			if(dirChange.containsKey(t)) {
				changeDir(dirChange.get(t));
			}
		}
		System.out.println(t);
	}
	
	public static void move() {
		if(snake.dir == 0) {
			snake.c++;
		} else if(snake.dir == 1) {
			snake.r++;
		} else if(snake.dir == 2) {
			snake.c--;
		} else {
			snake.r--;
		}
	}
	
	public static void changeDir(String s) {
		if(s.equals("D")) {
			snake.dir++;
			if(snake.dir == 4) {
				snake.dir = 0;
			}
		} else {
			snake.dir--;
			if(snake.dir == -1) {
				snake.dir = 3;
			}
		}
		
	}
}
