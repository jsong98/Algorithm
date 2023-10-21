package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
1+2+3-4+5+6-7
*/

public class BOJ_1541_잃어버린괄호 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split("");
		List<String> list = new ArrayList<>(); 
		
		String tmp = "";
		for(int i = 0; i < input.length; i++) {
			if(input[i].equals("+") || input[i].equals("-")) {
				if(!tmp.equals("")) {
					list.add(tmp);
					tmp = "";
				}	
				list.add(input[i]);
			} else {
				tmp += input[i];
				if(i == input.length-1) {
					list.add(tmp);
				}
			}
		}
		
//		System.out.println(list.toString());
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("+")) {
				int a = Integer.parseInt(list.get(i-1));
				int b = Integer.parseInt(list.get(i+1));
				list.set(i+1, Integer.toString(a+b));
				list.set(i-1, "");
				list.set(i, "");
			}
		}
//		System.out.println(list.toString());
		
		List<Integer> resList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("") || list.get(i).equals("-")) continue;
			resList.add(Integer.parseInt(list.get(i)));
		}
//		System.out.println(resList.toString());
		
		int res = resList.get(0);
		for(int i = 1; i < resList.size(); i++) {
			res -= resList.get(i);
		}
		System.out.println(res);
	}
}
