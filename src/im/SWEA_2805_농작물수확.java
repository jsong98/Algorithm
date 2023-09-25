package im;

import java.util.Scanner;

public class SWEA_2805_농작물수확 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수
		for(int tc=1; tc<= T; tc++) { // 테스트 케이스 수만큼 반복
			int N = sc.nextInt(); // 행렬의 크기
			
			int[][] arr = new int[N][N]; // 2차원 배열
			
			// 2차원 행렬 입력받기
			for(int r=0; r<N; r++) { // r: row
				String str = sc.next(); // 문자열 한 줄 입력받기
				// sc.next() => 공백 단위로 끊어진 문자열(토큰)을 입력받음
				// sc.nextLine() => 한 줄 전체를 입력받음(\n 포함해서)
				
				// 각 문자열은 N개의 문자로 구성되어 있음
				// 문자열 (String) => 문자의 배열(char[])
				char[] charArr = str.toCharArray();
				// "14024" => {'1', '4', '0', '2', '4'};
				for(int c=0; c<N; c++) {
					arr[r][c] = charArr[c] - '0';
//					arr[r][c] = str.charAt(c) - '0';
				}
			}
			
//			for(int r=0; r<N; r++) {
//				for(int c=0; c<N; c++) {
//					System.out.print(arr[r][c]+" ");
//				}
//				System.out.println();
//			}
			
			// 마름모 꼴로 더하기
			// N => N/2 => 대칭된 값 만들기
			int sum = 0; // 합을 저장할 변수
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int mid = N / 2; // 정가운데 열의 인덱스
					int d = Math.abs(r - mid);
//					if (d < 0) d *= -1; // 절댓값 구하기
					int start = 0 + d; // 더할 범위의 시작
					int end = (N-1) - d;
					if(start <= c && c <= end) {
						sum += arr[r][c];
					}
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
		
	}
}
