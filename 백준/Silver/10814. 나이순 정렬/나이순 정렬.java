import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Member[] arr;
    static class Member {
        int age;
        String name;
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Member[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.age, b.age));

        for(int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}