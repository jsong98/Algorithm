package theory;

public class 조합_재귀 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4}; // n개의 숫자 (0 ~ n-1)
		int r = 2;
		boolean[] selected = new boolean[arr.length]; // n개의 숫자의 선택 여부 저장
		
		comb(arr, selected, 0, 0, r);
	}

	private static void comb(int[] arr, boolean[] selected, int start, int i, int r) {
		// 기저 조건
		if( i == r) {
			for(int k=0; k<arr.length; k++) {
				if(selected[k])
					System.out.print(arr[k]+" ");
			}
			System.out.println();
			
			return;
		}
		
		
		// 유도 조건
		for(int j=start; j < arr.length; j++) {
			selected[j] = true;
			comb(arr, selected, j+1, i+1, r);
			
			selected[j] = false;
		}
		
	}
}
