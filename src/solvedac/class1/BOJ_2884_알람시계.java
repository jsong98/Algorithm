package solvedac.class1;

import java.util.Scanner;

public class BOJ_2884_알람시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		if(m < 45) {
			m += 15;
			h -= 1;
			if(h < 0) {
				h += 24;
			}
		} else if(m == 45) {
			m = 0;
		} else {
			m -= 45;
		}
		System.out.println(h + " " + m);
	}

}
