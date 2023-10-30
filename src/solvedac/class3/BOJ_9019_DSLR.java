package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3
1234 3412
1000 1
1 16

1
0 9999
*/

public class BOJ_9019_DSLR {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int start, end;
	static boolean[] visited;
	
	static class Record {
		int num;
		String cmd;
		
		public Record(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			visited = new boolean[10001];
			
			bfs(new Record(start, ""));
		}
		System.out.println(sb);
	}

	public static void bfs(Record rec) {
		Queue<Record> que = new LinkedList<>();
		visited[rec.num]= true; 
		que.offer(rec);
		
		while(true) {
			Record p = que.poll();
			
//			System.out.println(p.num + " " + p.cmd);
			if(p.num == end) {
				sb.append(p.cmd + "\n");
				break;
			}
			
			Record dp = dCommand(p);
			if(!visited[dp.num]) {
				visited[dp.num] = true;
				que.offer(dp);
			}
			Record sp = sCommand(p);
			if(!visited[sp.num]) {
				visited[sp.num] = true;
				que.offer(sp);
			}
			Record lp = lCommand(p);
			if(!visited[lp.num]) {
				visited[lp.num] = true;
				que.offer(lp);
			}
			Record rp = rCommand(p);
			if(!visited[rp.num]) {
				visited[rp.num] = true;
				que.offer(rp);
			}
		}
		
	}

	public static Record dCommand(Record rec) {
		int n = rec.num * 2;
		String s = rec.cmd + "D";
		
		if(n > 9999) {
			n = n % 10000;
		}
		
		return new Record(n, s);
	}

	public static Record sCommand(Record rec) {
		int n = rec.num - 1;
		String s = rec.cmd + "S";
		
		if(n == -1) {
			n = 9999;
		}
		
		return new Record(n, s);
	}

	public static Record lCommand(Record rec) {
		int n = rec.num;
		String s = rec.cmd + "L";
		
		if(n < 1000) {
			n = n * 10;
		} else {
			n = (n%1000)*10 + n/1000;
		}
		
		return new Record(n, s);
	}
	
	public static Record rCommand(Record rec) {
		int n = rec.num;
		String s = rec.cmd + "R";
		
		n = (n%10)*1000 + (n/10);
		
		return new Record(n, s);
	}

}
