package im;

import java.util.Scanner;

public class BOJ_1244_스위치SOL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 스위치 개수
		int[] arr = new int[N+1]; // 1부터 N까지의 인덱스를 사용
		
		// 스위치 상태 입력 받기
		for(int i=1; i<=N; i++) { 
			arr[i] = sc.nextInt(); 
		}
		
		int M = sc.nextInt(); // 학생 수
		
		for(int i=0; i<M; i++) { // 학생 수만큼 반복
			int gender = sc.nextInt(); // 학생의 성별
			int num = sc.nextInt(); // 학생이 받은 숫자
			
			if(gender == 1) { // 남학생이라면
				// for문
				for(int j=num; j<=N; j=j+num) {
					arr[j] = arr[j] == 1 ? 0 : 1;
				}
				
				// while문?
//				int temp = 0;
//				while((temp = temp + num) <= N) {
//					arr[temp] = arr[temp] == 1 ? 0 : 1;
//				}
				
				// while문2
//				int temp = num;
//				while(num <= N) {
//					arr[temp] = arr[temp] == 1 ? 0 : 1;
//					temp = temp + num;
//				}
			}
			if(gender == 2) { // 여학생이라면
				// 받은 수에서 시작
				// 양 옆의 수가 대칭이라면, 대칭인 구간 만큼
				// 먼저 가운데 있는 수(그 학생이 받은 수) 스위치 1개 상태 바꾸기
				arr[num] = arr[num] == 1 ? 0 : 1;
				
				int d = 1; // 가운데 수로부터 거리
				while(num + d <= N && num - d >= 1 
						&& (arr[num + d] == arr[num - d])) { // 범위 안에 있고 대칭이면
					// 대칭인 양 옆의 두 스위치의 상태를 바꾸고
					arr[num+d] = arr[num+d] == 1 ? 0 : 1;
					arr[num-d] = arr[num-d] == 1 ? 0 : 1;
					d++; // 그 다음 스위치 비교하러 감
				}
			}
		} // 학생 수의 for문
		
		// 출력
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i]+" ");
			if(i % 20 == 0)
				System.out.println();
		}
		
		
	}
}





