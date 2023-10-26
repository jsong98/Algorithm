package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
1
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[] 
*/

public class BOJ_5430_AC {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static String[] input;
	static Deque<String> deq;
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		outer:
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			String[] cmd = str.split("");
			int n = Integer.parseInt(br.readLine());
			input = br.readLine().replace("[", "").replace("]", "").split(",");
			deq = new LinkedList<>();
			flag = true;
			for(int i = 0; i < input.length; i++) {
				if(input[i].equals("")) {
					continue;
				}
				deq.addLast(input[i]);
			}
			
			for(int i = 0; i < cmd.length; i++) {
				if(cmd[i].equals("R")) {
					if(flag) {
						flag = false;
					} else {
						flag = true;
					}
				} else {
					if(deq.size() == 0) {
						sb.append("error" + "\n");
						continue outer;
					}
					if(flag) {
						deq.removeFirst();
					} else {
						deq.removeLast();
					}
				}
			}
			
			int len = deq.size();
			sb.append("[");
			for(int i = 0; i < len; i++) {
				if(flag) {
					if(i == len-1) {
						sb.append(deq.removeFirst());
						break;
					}
					sb.append(deq.removeFirst()+",");
				} else {
					if(i == len-1) {
						sb.append(deq.removeLast());
						break;
					}
					sb.append(deq.removeLast()+",");
				}
			}
			sb.append("]" + "\n");
			
		}
		
		System.out.println(sb);
	}
}
