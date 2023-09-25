package theory;

public class 순열 {
	public static void main(String[] args) {
		// 1, 2, 3, 4의 네 가지 숫자 중에서 2개를 뽑아서 나열하는 경우의 수
		// => (1, 2), (1, 3), (1, 4), ... (4, 3)
		
		// 반복문으로
		// 2개 뽑으면 => 2중 for문
		// 3개 뽑으면 => 3중 for문
		// n개 뽑으면 => n중 for문
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				if(i != j) {
					System.out.println(i+","+j);
				}
			}
		}
		
		
	}
}
