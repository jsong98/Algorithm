package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int l, c;
	static char[] arr;
	static char[] output;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		output = new char[l];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == output.length) {
			String s = "";
			for(int i = 0; i < output.length; i++) {
				s += output[i];
			}
			if(isValid(s)) {
				System.out.println(s);
			}
			
			return ;
		}
		if(idx == arr.length) return ;
		
		output[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
	
	public static boolean isValid(String s) {
		boolean flag = false;
		List<Character> consonant = new ArrayList<>();
		consonant.add('a');
		consonant.add('e');
		consonant.add('i');
		consonant.add('o');
		consonant.add('u');
		int cnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(consonant.contains(s.charAt(i)) ) {
				flag = true;
			} else {
				cnt++;
			}
		}
		
		
		if(flag && cnt>1) return true;
		return false;
	}
}
