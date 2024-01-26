package BaekJoon;

/*
input1
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0
1 & 4 vs 2 & 3
output1
0

input2
6
0 1 2 3 4 5
1 0 2 3 4 5
1 2 0 3 4 5
1 2 3 0 4 5
1 2 3 4 0 5
1 2 3 4 5 0

output2
2

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, res;
    static int[][] ap;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ap = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
    }

    static void comb(int[] arr, int[] output, int idx, int sidx) {
        if (sidx == output.length) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println("chk");
            return ;
        }
        if (idx == arr.length) {
            return ;
        }

        output[sidx] = arr[idx];
        comb(arr, output, idx + 1, sidx + 1);
        comb(arr, output, idx + 1, sidx);
    }
}
