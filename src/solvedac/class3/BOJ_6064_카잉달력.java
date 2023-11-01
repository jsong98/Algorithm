package solvedac.class3;

import java.util.Scanner;

/*
1
10 12 3 9
10 12 7 2
13 11 5 6

if(x < m) x' = x + 1
else x' = 1

if(y < n) y' = y + 1
else y' = 1

m = 10, n = 12

*/

public class BOJ_6064_카잉달력 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();

			int lcm = M * N / gcd(M, N);
			int n = 0;
			int ans = -1;
			while (n * M < lcm) {
				if ((n * M + x - y) % N == 0) {
					ans = n * M + x;
					break;
				}
				n++;
			}

			System.out.println(ans);
		}
	}

	static int gcd(int n1, int n2) {
		if (n2 == 0)
			return n1;
		return gcd(n2, n1 % n2);
	}

}
