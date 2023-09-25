package theory;

public class 순열_재귀 {
	public static void main(String[] args) {
		// n개의 숫자 중에서 r개를 뽑아서 나열
		int[] arr = {1, 2, 3, 4}; // n == arr.length개의 숫자
		int r = 2; // 뽑는 개수
		boolean[] visited = new boolean[arr.length]; // 방문처리(앞에 숫자가 이미 뽑혔는지 체크)
		int[] res = new int[r]; // 각각의 뽑은 경우를 저장할 배열
		
		perm(arr, visited, res, 0, r);	
	}

	private static void perm(int[] arr, boolean[] visited, int[] res, int i, int r) {
		// 기저조건
		// i가 0부터 출발 => r이 되면 멈춘다
		if( i == r) {
			for(int k=0; k<res.length; k++) {
				System.out.print(res[k]+" ");
			}
			System.out.println();
			return; // 함수 끝내기
		}
				
		// 유도조건
		// arr의 모든 원소를 돌면서
		// visited가 false라면(뽑지 않았다면)
		// 그 수를 뽑고(visited[j] = true)
		// 그 다음 위치의 수를 뽑으러 감
		for(int j=0; j < arr.length; j++) {
			if(!visited[j]) { // 이전에 뽑은 적이 없다면
				visited[j] = true; // 그 수를 뽑는다(방문처리)
				res[i] = arr[j]; // i번째 수를 뽑아서 결과 배열 res에 저장
				perm(arr, visited, res, i+1, r);
				
				visited[j] = false; // j번째 수 방문처리 초기화
			}
		}
		
	}
}
