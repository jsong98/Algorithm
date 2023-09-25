package solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] nArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] mArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		for(int i = 0; i < mArr.length; i++) {
			int start = 0;
			int end = nArr.length-1;
			boolean isExist = false;
			while(start<=end) {
				int mid = (start+end)/2;
				int pt = nArr[mid];
				if(mArr[i] == pt) {
					isExist = true;
					break;
				} else if(mArr[i] < pt) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			}
			if(isExist) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
