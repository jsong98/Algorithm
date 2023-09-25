package theory;

public class 부분집합_재귀 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		boolean[] visited = new boolean[arr.length];
		
		subset(arr, visited, 0);
	}

	private static void subset(int[] arr, boolean[] visited, int i) {
		// 기저조건
		if(i == arr.length) {
			for(int k=0; k< arr.length; k++) {
				if(visited[k])
					System.out.print(arr[k]+" ");
			}
			System.out.println();
			return;
		}
		
		// 유도파트
		visited[i] = true; // 계단 1
		subset(arr, visited, i+1);
		visited[i] = false; // 계단 2
		subset(arr, visited, i+1);
		
	}
}
