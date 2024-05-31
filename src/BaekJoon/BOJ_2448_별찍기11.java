package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
bb*bb
b*b*b
*****

N   numOfPyramid
3       1
6       3
12      9
24      27

3       0
6       3
12      6+3
24      12+6+3

12      1~3 = 3+6, 4~6 = 6, 7~9 = 3, 10~12 = 0
24      1~3 = 3+6+12, 4~6 = 6+12, 7~12 = 12, 13~24 = 0

5       1*5+0
11      2*5+(2-1)       N/3 * 5 + (N/3 - 1)
23      4*5+(4-1)
47      8*5+(8-1)

3
  *
 * *
*****

6
     *
    * *
   *****
  *     *
 * *   * *
***** *****

                       *
                      * *
                     *****
                    *     *
                   * *   * *
                  ***** *****
                 *           *
                * *         * *
               *****       *****
              *     *     *     *
             * *   * *   * *   * *
            ***** ***** ***** *****
*/

public class BOJ_2448_별찍기11 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder temp = new StringBuilder();
    static int N, totalLength;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        totalLength = 5*(N/3) + (N/3-1);
        temp = new StringBuilder();
//        recur(N, 1);
    }

    static void recur(int n, int line) {
        if(n == 3) {
            if(line%3 == 1) {
                temp.append("  *  ");
            } else if(line%3 == 2) {
                temp.append(" * * ");
            } else {
                temp.append("*****");
            }
            return ;
        }
        for (int i = 0; i < n / 2; i++) {
            temp.append(" ");
        }
        recur(n/2, line);
        if(temp.length() <= totalLength) {
            temp.append(" ");
            recur(n/2,line);
        }
        for (int i = 0; i < n / 2; i++) {
            temp.append(" ");
        }
        if(temp.length() == totalLength) temp.append("\n");
    }
}
