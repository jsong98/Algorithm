package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1181_단어정렬 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					for(int i = 0; i < o1.length(); i++) {
						if(o1.charAt(i) != o2.charAt(i)) {
							return o1.charAt(i) - o2.charAt(i);
						}
					}
				}
				
				return o1.length()-o2.length();
			}
		});
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(!pq.contains(str)) {
				pq.add(str);
			}
		}

		while(!pq.isEmpty()) {
			sb.append(pq.poll() + "\n");
		}
		
		System.out.println(sb);
	}
}
