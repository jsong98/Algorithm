package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, r, c;
	static int count;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, n);
		count = 0;
		
		recur(size, r, c);
		System.out.println(count);
	}
	
	public static void recur(int size, int r, int c) {
		if(size == 1)
			return;
		
		if(r < size/2 && c < size/2) {
			recur(size/2, r, c);
		}
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4;
			recur(size/2, r, c - size/2);
		}
		else if(r >= size/2 && c < size/2) {
			count += (size * size / 4) * 2;
			recur(size/2, r - size/2, c);
		}
		else {
			count += (size * size / 4) * 3;
			recur(size/2, r - size/2, c - size/2);
		}
	}
}
