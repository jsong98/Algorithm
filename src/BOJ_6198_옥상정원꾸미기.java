import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
1 <= N <= 80,000
1 <= h<= 1,000,000,000

input 1
6
1
2
3
4
5
10

output 1
5
*/

public class BOJ_6198_옥상정원꾸미기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int res;

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        N = Integer.parseInt(br.readLine());
        res = 0;
        for (int i = 0; i < N; i++) {
            temp.add(Integer.parseInt(br.readLine()));
        }
        while (!temp.isEmpty()) {  
            stack.add(temp.pop());
        }   // 입력 뒤집기
        
        int size = stack.size();
        for (int i = 0; i < size-1; i++) {
            int cur = stack.pop();

            outer:
            while (!stack.isEmpty()) {
                int comp = stack.pop();
                if (comp < cur) {
                    res++;
                    temp.add(comp);
                    if (stack.isEmpty()) {
                        while (!temp.isEmpty()) {
                            stack.add(temp.pop());
                        }
                        break outer;
                    }
                } else {
                    stack.add(comp);
                    while (!temp.isEmpty()) {
                        stack.add(temp.pop());
                    }
                    break outer;
                }
            }
        }

        System.out.println(res);
    }
}
