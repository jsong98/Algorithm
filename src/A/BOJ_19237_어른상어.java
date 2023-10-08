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

/*
4 2 6
1 0 0 0
0 0 0 0
0 0 0 0
0 0 0 2
4 3
1 2 3 4
2 3 4 1
3 4 1 2
4 1 2 3
1 2 3 4
2 3 4 1
3 4 1 2
4 1 2 3
*/

public class BOJ_19237_어른상어 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, k;
	static Scope[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Shark> sharkList;
	static int sharkNum;
	
	static class Scope {
		int num;
		int r;
		int c;
		int t;
		int dir;		
		Shark shark;
		
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
		sharkNum = m;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num != 0) { //상어가 있는 칸인 경우
					Scope scope = new Scope(num, i, j, k);
					map[i][j] = scope;
					Shark s = new Shark(num, i, j);
					sharkList.add(s);
					map[i][j].shark = s;
				} else {	// 상어가 없는 칸인 경우
					Scope scope = new Scope(num, i, j, 0);
					map[i][j] = scope;
				}
			}
		}
		//상어를 번호 순서대로 정렬
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
		while(sharkNum != 1) {
			move();
//			status();
//			System.out.println();
			t++;
			if(t > 1000) {
				System.out.println(-1);
				return;
			}
				
		}
		
		System.out.println(t);
	}
	
	public static void move() {
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			outer: for (int j = 0; j < n; j++) {
				boolean flag = false;
				if (map[i][j].shark != null && !visited[i][j]) {
					Shark s = map[i][j].shark;
					// 해당 영역에 상어가 있으면 이동시킴
					for (int dir : s.priorDir[s.dir - 1]) {
						int nr = s.r + dr[dir - 1];
						int nc = s.c + dc[dir - 1];
						if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
						// 일단 4방 탐색에서 냄새 남아있지 않은 영역이 아니면 continue
						if (map[nr][nc].num != 0) continue;
						flag = true;
						// 해당 좌표에 이미 상어가 있고, 그 상어의 num이 이동하려는 상어의 num보다 작은 경우
						if (map[nr][nc].shark != null && map[nr][nc].shark.num < s.num) {
							map[i][j].shark = null; // 이동하려는 상어 삭제
							sharkNum -= 1;
							continue outer;
						} else {
							if(map[nr][nc].shark != null ) sharkNum -= 1;
							visited[nr][nc] = true;
							// 상어의 좌표값과 방향을 수정한 후, scope의 sharks에 추가
							s.r = nr;
							s.c = nc;
							s.dir = dir;
							map[nr][nc].shark = s;
							break;
						}
					}
					// 냄새가 남아있지 않은 영역, scope의 num이 0인 경우가 없을 때,
					if (!flag) {
						for (int dir : s.priorDir[s.dir - 1]) {
							int nr = s.r + dr[dir - 1];
							int nc = s.c + dc[dir - 1];
							if (nr < 0 || nr >= n || nc < 0 || nc >= n)
								continue;
							// 4방 탐색해서 자신의 냄새가 남아 있는 영역으로 이동
							if (map[nr][nc].num == s.num) {
								visited[nr][nc] = true;
								// 상어의 좌표값과 방향을 수정한 후, scope의 sharks에 추가
								s.r = nr;
								s.c = nc;
								s.dir = dir;
								map[nr][nc].shark = s;
								break;
							}
						}
					}
					// 기존 좌표 scope의 sharks 초기화
					map[i][j].shark = null;
				}
			}
		}
		
		// map에 남아있는 상어의 정보를 바탕으로 scope의 변수 초기화
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].shark != null) {
					Shark s = map[i][j].shark;
					map[i][j].num = s.num;
					map[i][j].t = k;
				}
				if(map[i][j].shark == null && map[i][j].t != 0) {
					map[i][j].t -= 1;
					if(map[i][j].t == 0) map[i][j].num = 0;
				}
			}
		}
		
	}
	
	public static void status() {
		int r = 0, c = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].shark != null) {
					System.out.print("*("+map[i][j].shark.dir+")");
				}
				System.out.print(map[i][j].num + " " + map[i][j].t + " | ");
			}
			System.out.println();
		}
	}
	
}
