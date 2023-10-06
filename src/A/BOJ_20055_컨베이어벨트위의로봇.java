package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, k;
	static Node head, front, rear;
	static Node first;

	static class Node {
		Node prev;
		Node next;
		int dura;
		boolean robot;

		public Node(int dura) {
			this.dura = dura;
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		head = new Node(0);

		st = new StringTokenizer(br.readLine());
		front = new Node(Integer.parseInt(st.nextToken()));
		head.next = front;
		Node temp = front;
		for (int i = 1; i < 2 * n; i++) {
			Node cur = new Node(Integer.parseInt(st.nextToken()));
			temp.next = cur;
			cur.prev = temp;
			if (i == n - 1) {
				rear = cur;
			}
			temp = cur;
			if(i == 2*n -1) {
				cur.next = front;
				front.prev = cur;
			}
		}
		
		
		int cnt = 0;
		while(true) {
			cnt += 1;
			step1();
			step2();
			step3();
			if(step4()) break;
		}
		
		System.out.println(cnt);
		
	}

	public static void step1() {
		rear = rear.prev;
		front = front.prev;
		head.next = front;
		rear.robot = false;
	}

	public static void step2() {
		Node cur = rear.prev;
		while(true) {
			if(cur.robot) {
				if(!cur.next.robot && cur.next.dura > 0) {
					cur.robot = false;
					cur.next.robot = true;
					cur.next.dura -= 1;
				}
			}
			if(cur.next == rear) rear.robot = false;
			cur = cur.prev;
			
			if(cur == rear) break;
		}
		
	}

	public static void step3() {
		if(front.dura != 0) {
			front.robot = true;
			front.dura -= 1;
		}
	}

	public static boolean step4() {
		int cnt = 0;
		Node cur = front;
		while(true) {
			if(cur.dura == 0) {
				cnt += 1;
			}
			if(cnt == k) return true;
			cur = cur.next;
			if(cur == front) break;
		}
		return false;
	}
	
//	public static void status() {
//		Node cur = front;
//		while(true) {
//			if(cur.robot) {
//				System.out.print(cur.dura + "*" + " ");
//			} else {
//				System.out.print(cur.dura + " ");
//			}
//			cur = cur.next;
//			if(cur == front) break;
//		}
//		System.out.println();
//	}
}
