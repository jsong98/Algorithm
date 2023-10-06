package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, k;
	static Scope[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Shark> sharkList;
	
	static class Scope {
		int num;
		int r;
		int c;
		int t;
		int dir;
		
		public Scope(int num, int r, int c, int t) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	static class Shark {
		int num;
		int r;
		int c;
		int dir;
		int[][] priorDir;
		
		public Shark(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
			priorDir = new int[4][4];
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new Scope[n][n];
		visited = new boolean[n][n];
		sharkList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num != 0) { //상어가 있는 칸인 경우
					Scope scope = new Scope(num, i, j, k);
					map[i][j] = scope;
					Shark s = new Shark(num, i, j);
					sharkList.add(s);;
				} else {	// 상어가 없는 칸인 경우
					Scope scope = new Scope(num, i, j, 0);
					map[i][j] = scope;
				}
			}
		}
		Collections.sort(sharkList, new Comparator<Shark>() {
			@Override
			public int compare(Shark o1, Shark o2) {
				return o1.num - o2.num;
			}
		});
		// 상어의 최초 방향 입력 및 영역 리스트 초기화
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			sharkList.get(i).dir = Integer.parseInt(st.nextToken());
		}
		// 상어 별 방향 우선순위 저장
		for(int i = 0; i < m; i++) {
			int[][] priorDir = sharkList.get(i).priorDir;
			for(int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int l = 0; l < 4; l++) {
					priorDir[j][l] = Integer.parseInt(st.nextToken());
				}
			}
		}	// 여기까지 입력
		
		int t = 0;
//		while(!check()) {
//			move();
//			t += 1;
//			status();
//			System.out.println();
//		}
		
		move();
		status();
		System.out.println();
		
		move();
		status();
		System.out.println();
		
		move();
		status();
		System.out.println();
		
		move();
		status();
		System.out.println();
		
//		System.out.println(t);
	}
	
	// 겹치는 상어가 있다면 처리 및 종료가능하면 종료.
	public static boolean check() {
		int cnt = 0;
		for(Shark s : sharkList) {
			if(s == null) continue;
			cnt += 1;
		}
		if(cnt == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void move() {
		for(Shark s : sharkList) {
			if(s == null) continue;
			PriorityQueue<Scope> pq = new PriorityQueue<>(new Comparator<Scope>() {
				// scope의 num을 기준으로 heap 생성
				public int compare(Scope o1, Scope o2) {
					return o1.num - o2.num;
				}
			});
			map[s.r][s.c].t -= 1;
			visited[s.r][s.c]= false; 
			for(int dir : s.priorDir[s.dir-1]) {
				int nr = s.r + dr[dir-1];
				int nc = s.c + dc[dir-1];
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				// Scope의 num이 0이거나 해당 상어의 번호인 경우만 pq에 offer
				if(map[nr][nc].num != 0 && map[nr][nc].num != s.num) continue;
				Scope scope = new Scope(map[nr][nc].num, nr, nc, map[nr][nc].t);
				scope.dir = dir;	// 이동 후 상어의 방향 설정
				pq.offer(scope);
			}
			Scope scope = pq.poll();
			if(visited[scope.r][scope.c]) {
				// 이동하려는 영역에 상어가 있으면 그 상어의 번호를 기준으로 sharkList에서 제거
				if(s.num > sharkList.get(scope.num-1).num) {
					sharkList.set(s.num-1, null);
					continue;
				} else {
					sharkList.set(scope.num-1, null);
				}
			}
			s.r = scope.r;
			s.c = scope.c;
			visited[s.r][s.c]= true; 
			s.dir = scope.dir;
			scope.num = s.num;
			scope.t = k;
			map[scope.r][scope.c] = scope;
		}
	}
	
	public static void status() {
		for(Shark s : sharkList) {
			System.out.println(s.r + " " + s.c + " " + s.dir);
		}
	}
	
}
