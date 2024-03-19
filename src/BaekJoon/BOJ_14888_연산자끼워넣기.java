package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
+ - * /

input 2
3
3 4 5
1 0 1 0

output 2
35
17

input 3
6
1 2 3 4 5 6
2 1 1 1

output 3
54
-24
*/

public class BOJ_14888_연산자끼워넣기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, max, min;
    static int[] num, cal;
    static List<int[]> numList,calList;

    public static void main(String[] args) throws IOException {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        num = new int[N];   // 연산에 사용될 수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        cal = new int[N - 1];   // 연산자 저장
        int c = 0;      // 연산자를 나타내는 변수, 0:+/1:-/2:*/3:`/`
        int calIdx = 0;  // cal 배열의 idx
        st = new StringTokenizer(br.readLine());
        int r = 0;
        for (int i = 0; i < 4; i++) {
            r = Integer.parseInt(st.nextToken());
            if(r == 0) {    // 해당 연산자가 0번 나왔으면 변수만 바꿔주고 넘어감
                c++;
                continue;
            }
            for (int j = 0; j < r; j++) {   // 해당 연산자가 1번 이상나왔으면 cal변수에 그 횟수만큼 넣어줌
                cal[calIdx] = c;
                calIdx++;
            }
            c++;
        }
        int[] output = new int[cal.length];
        boolean[] visited = new boolean[cal.length];
        calList = new ArrayList<>();
        perm(cal, output, visited, 0, cal.length, cal.length, calList);

        System.out.println(max + "\n" + min);
    }

    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int size, int subSize, List<int[]> list) {
        if (depth == subSize) {
            int res = calculator(num, output);
            if(res > max) max = res;
            if(res < min) min = res;

            return ;
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth+1, size, subSize, list);
                visited[i] = false;
            }
        }
    }

    public static int calculator(int[] nums, int[] cals) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cal = cals[i-1];
            if(cal == 0) {
                res = res + nums[i];
            } else if (cal == 1) {
                res = res - nums[i];
            } else if (cal == 2) {
                res = res * nums[i];
            } else {
                res = res / nums[i];
            }
        }

        return res;
    }
}
