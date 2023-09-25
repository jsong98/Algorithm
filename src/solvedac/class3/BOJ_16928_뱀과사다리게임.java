package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Integer> ladder;
	static Map<Integer, Integer> snake;
	static int res;
	static boolean visited[];
	
	static class Dice{
		int idx;
		int num;
		
		public Dice(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		ladder = new HashMap<Integer, Integer>();
		snake = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ladder.put(start, end);
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			snake.put(start, end);
		}
		
		visited = new boolean[101];
		res = 0;
		bfs();
		System.out.println(res);
	}
	
	public static void bfs() {
		Queue<Dice> que = new LinkedList<>();
		que.add(new Dice(1, 0));
		int min = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			Dice p = que.poll();
//			System.out.println(p.idx + " " + p.num);
			if(ladder.containsKey(p.idx)) p.idx = ladder.get(p.idx);
			if(snake.containsKey(p.idx)) p.idx = snake.get(p.idx);
			if(p.idx>=100) {
				if(p.num<min) {
					min = p.num;
				}
				continue;
			}
			for(int i = 1; i <= 6; i++ ) {
				int nIdx = p.idx + i;
				int nNum = p.num + 1;
				if(nIdx>100) continue;
				if(ladder.containsKey(nIdx) && !visited[nIdx]) {
					que.offer(new Dice(ladder.get(nIdx), nNum));
				} else if (snake.containsKey(nIdx) && !visited[nIdx]) {
					visited[nIdx] = true;
					que.offer(new Dice(snake.get(nIdx), nNum));
				} else {
					if(!visited[nIdx]) {
						que.offer(new Dice(nIdx, nNum));
				}
			}
			
		}
		res = min;
	}
	}
}
