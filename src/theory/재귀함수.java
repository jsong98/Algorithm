package theory;

public class 재귀함수 {
	
	public static void main(String[] args) {
		// 반복문
//		for(int i=0; i<5; i++) {
//			System.out.println(i);
//		}
		
		// 재귀함수
		// 자기가 자기 자신을 호출하는 함수
		// 두 가지 부분으로 구성
		// - 기저 조건(Basis part) : 호출을 끝내기 위한 조건(무한히 호출하면 안되므로)
		// - 유도 조건 : 자기 자신을 호출하는 조건
		
		recursiveFor(0, 8);
	}

	// 재귀함수로 for문 구현
	private static void recursiveFor(int i, int end) {
		// 기저조건
		if(i==end) return; // 함수 종료
		
		// 유도조건
		// if(i!=end){
		System.out.println(i);
		recursiveFor(i+1, end);
		// }
	}

}
