package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BruteForce
// PriorityQueue

public class BOJ_18111_마인크래프트 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] ground;
	static int N;
	static int M;
	static int B;
	
	public static class Pair{	
		// 각 층별로 땅다지기를 한 결과, 해당 높이와 걸린 시간을 저장하는 클래스
		int height; 
		int time;
		
		public Pair(int height, int time) {
			this.height = height;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		ground = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			// 2차원 배열 ground에 저장함과 동시에 최소값과 최대값을 찾음
			// 최소값은 최소 높이, 최대값은 최대 높이로 쓰이며,
			// 최소 높이 ~ 최대 높이까지 모든 높이를 brute force로 탐색
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if(ground[i][j] < min) {
					min = ground[i][j];
				}
				if(ground[i][j] > max) {
					max = ground[i][j];
				}
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			// 우선순위 큐, Pair 객체의 time을 기준으로 time이 낮을수록 앞으로 가게 정렬.
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.time == p2.time) {
					// time이 같으면 높이를 기준으로, 높이가 높을수록 앞으로 가게 정렬.
					return p2.height - p1.height;
				}
				
				return p1.time - p2.time;
			}

		});
		
		for(int h = min; h <= max; h++) {
			// 최소 높이 ~ 최대 높이까지 완전 탐색
			int more = getMore(ground, h);	// 특정 높이를 기준으로 초과하는 블록의 개수 more
			int less = getLess(ground, h);	// 특정 높이를 기준으로 미치지 못하는 블록의 개수 less

			if(more+B<less) {
				// 초과하는 블록의 개수와 기존에 인벤토리에 가지고 있던 블록의 개수의 합이 less보다 작으면
				// 그 층수를 검사하는 것은 무의미하므로 continue.
				continue;
			}
			
			pq.add(new Pair(h, getTime(more, less)));
			// getTime 메서드로 해당 층수로 땅을 다질 때 걸리는 시간을 구하고, 층수 data와 함께 Pair 객체를 생성해서 pq에 저장
		}
		
		Pair res = pq.poll();
		System.out.println(res.time+ " " +res.height);
		
	}
	
	public static int getMore(int[][] a, int height) {
		int more = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(a[i][j] > height) {
					more += a[i][j]-height;
				}
			}
		}
		
		return more;
	}
	
	public static int getLess(int[][] a, int height) {
		int less = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(a[i][j] < height) {
					less += height - a[i][j];
				}
			}
		}
		return less;
	}
	
	public static int getTime(int more, int less) {
		int time = 0;
		
		time += more*2;
		time += less;
		
		return time;
	}
}
