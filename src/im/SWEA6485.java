package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
2
1 3
2 5
5
1
2
3
4
5
 */

// 삼성시의 버스 노선
public class SWEA6485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());	//노선의 개수
		int[][] noseon = new int[n][5000];			//노선을 저장할 2차원 배열
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());			//노선의 시작
			int end = Integer.parseInt(st.nextToken());				//노선의 끝
			System.out.println(start + "/" + end);
			for(int j = 0; j <= end-start; j++) {
				noseon[i][j] = start;
				System.out.println(start);
				start++;
			}
		}
		int p = Integer.parseInt(br.readLine());
		int[] stop = new int[p];
		for(int i = 0; i < p; i++) {
			stop[i] = Integer.parseInt(br.readLine());
		}
		
//		int[] result = new int[p];
//		
//		for(int i = 0; i < p; i++) {
//			for(int j = 0; j < n; j++) {
//				int cnt = 0;
//				if(Arrays.asList(noseon[j]).contains(p[i])) {
//					cnt++;
//				}
//			}
//		}
		
		System.out.println(Arrays.toString(noseon[0]));
		System.out.println(Arrays.toString(noseon[1]));
	}

}
