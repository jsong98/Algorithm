package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int r, c, t;
	static int res;
    static int[][] arr;
    static int[][] temp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]> purifier;
    static int[] upperPart;
    static int[] lowerPart;
    
    static class Pos{
    	int r;
    	int c;
    	
    	public Pos(int r, int c) {
    		this.r = r;
    		this.c = c;
		}
    }
    
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		temp = new int[r][c];
		purifier = new ArrayList<int[]>();
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = arr[i][j];
				if(arr[i][j] == -1) purifier.add(new int[] {i,j});
			}
		}
		upperPart = purifier.get(0);
		lowerPart = purifier.get(1);
		for(int i = 0; i < t; i++) {
			diffuse(arr);
			upperPurify();
			lowerPurify();
		}
		
		res = 2;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				res += arr[i][j]; 
			}
		}
		
		System.out.println(res);
	}
	
	public static void diffuse(int[][] input) {
		int[][] temp = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				temp[i][j] = input[i][j];
			}
		}
		
		for(int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(input[i][j] == -1) continue;
				if(input[i][j]!=0) {
					int sub = input[i][j]/5;
					int tempCnt = 0;
					for(int k = 0; k < 4; k++) {
						int ni = i + dr[k];
						int nj = j + dc[k];
						if(ni<0 || ni>=r || nj<0 || nj>=c || (arr[ni][nj]==-1)) continue;
						temp[ni][nj] = temp[ni][nj] + sub;
						tempCnt++;
					}
					temp[i][j] -= (tempCnt*sub);
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				arr[i][j] = temp[i][j];
			}
		}
		
	}
	
	public static void upperPurify() {
		int pr = upperPart[0]-1;
		int pc = upperPart[1];
		
		int nr = 0;
		int nc = 0;
		while(true) {
			nr = pr-1;
			nc = pc;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nr==0) break;
		}
		while(true) {
			nr = pr;
			nc = pc+1;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nc==c-1) break;
		}
		while(true) {
			nr = pr+1;
			nc = pc;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nr==upperPart[0]) break;
		}
		while(true) {
			nr = pr;
			nc = pc-1;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nc==1) {
				arr[nr][nc] = 0;
				break;
			}
		}
	}

	public static void lowerPurify() {
		int pr = lowerPart[0]+1;
		int pc = lowerPart[1];
		
		int nr = 0;
		int nc = 0;
		while(true) {
			nr = pr+1;
			nc = pc;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nr==r-1) break;
		}
		while(true) {
			nr = pr;
			nc = pc+1;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nc==c-1) break;
		}
		while(true) {
			nr = pr-1;
			nc = pc;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nr==lowerPart[0]) break;
		}
		while(true) {
			nr = pr;
			nc = pc-1;
			arr[pr][pc] = arr[nr][nc];
			pr = nr;
			pc = nc;
			if(nc==1) {
				arr[nr][nc] = 0;
				break;
			}
		}
	}

}
