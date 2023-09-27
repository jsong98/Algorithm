package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
9
noon
is
lunch
for
most
noone
waits
until
two 

5
abab
abaa
abcdab
abcda
abcdaa

5
ae
ab
ac
aa
ad

4
abc
def
defg
abcd
*/

public class BOJ_2179_비슷한단어 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(!list.contains(s)) {
				list.add(s);
			}
		}
		
		int str1 = 0;
		int str2 = 0;
		int max = 0;
		for(int i = 0; i < n; i++) {
			String s1 = list.get(i);
			for(int j = i+1; j < n; j++) {
				int cnt = 0;
				String s2 = list.get(j);
				int size=Math.min(s1.length(), s2.length());
				for(int k=0;k<size;k++) {
					if(s1.charAt(k)==s2.charAt(k)) cnt++;
					else break;
				}
				if(cnt>max) {
					str1=i;
					str2=j;
					max=cnt;
				}
			}
		}
		
		System.out.println(list.get(str1));
		System.out.println(list.get(str2));
		
	}
}
