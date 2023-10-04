package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
4
1 1 0 1 0 0 0 1 1 0
0 1 0 0 0 1 0 0 0 1
0 1 0 1 1 1 1 1 1 0
1 1 0 1 0 1 0 1 0 0
0 1 1 1 1 1 1 1 0 1
1 1 0 1 0 0 0 1 1 0
1 1 1 1 1 0 1 0 0 0
0 1 0 1 1 1 1 1 1 0
1 1 0 1 0 1 0 1 0 0
0 1 1 1 1 1 1 1 0 1
1 1 1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 1 0 1
1 1 1 1 1 1 1 0 1 1
1 1 1 1 1 1 0 1 1 1
1 1 1 1 1 0 1 1 1 1
1 1 0 1 0 1 0 1 0 1
0 1 1 0 1 0 1 1 0 1
1 1 0 1 0 1 0 1 1 0
1 0 0 0 1 0 1 0 0 0
0 1 0 1 1 1 1 1 1 0
 
*/

public class Algo2_서울_5반_송준석 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] arr = {0,1,2,3,4}; // 놀이판을 배치할 경우의 수를 위한 배열
	static int[] output;			// 놀이판을 배치할 경우의 수를 위한 배열
	static boolean[] visitedP;		// 놀이판을 배치할 경우의 수를 위한 배열
	static List<int[]> cases;		// 순열로 생성된 경우의 수를 저장할 배열
	static int[][] record;			// 처음 입력을 저장할 2차원 배열
	static int[][] board;			// 순열로 생성된 경우의 수에 따른 놀이판 배치를 저장할 배열
	static int cnt;					// 결과를 count할 변수
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;		// dfs를 위한 배열
	static boolean flag;			// dfs 결과를 확인하기 위한 변수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		output = new int[arr.length];
		visitedP = new boolean[arr.length];
		cases = new ArrayList<>();
		perm(0);	// 순열로 놀이판을 결합하는 경우의 수 생성. 이 경우의 수는 항상 일정함.
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			cnt = 0;
			record = new int[5][10];
			for(int i = 0; i < 5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 10; j++) {
					record[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 순열로 생성된 경우의 수마다 놀이판을 통과할 수 있는지 체크
			for(int[] arr : cases) {
				board = new int[5][10];
				for(int i = 0; i < 5; i++) {
					for(int j = 0; j < 10; j++) {
						board[i][j] = record[arr[i]][j];
					}
				}
				
				if(chk(board)) cnt++;
			}
			
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
	
	
	public static boolean chk(int[][] board) {
		for(int i = 0; i < 10; i++) {
			if(board[0][i] == 0) {
				visited = new boolean[5][10];
				visited[0][i] = true;
				flag = false;
				dfs(0, i);
				if(flag) return true;
			}
		}
		
		return false;
	}
	
	public static void dfs(int r, int c) {
		if(r == 4) {
			flag = true;
			return ;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= 5 || nc < 0 || nc >= 10 || board[nr][nc] == 1) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
	
	public static void perm(int depth) {
		if(depth == output.length) {
			int[] temp = new int[output.length];
			for(int i = 0; i < output.length; i++) {
				temp[i] = output[i];
			}
			cases.add(temp);
			return ;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!visitedP[i]) {
				visitedP[i] = true;
				output[depth] = arr[i];
				perm(depth+1);
				visitedP[i] = false;
			}
		}
	}
}
