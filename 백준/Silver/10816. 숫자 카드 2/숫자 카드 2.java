import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(map.containsKey(k)) {
                map.replace(k, map.get(k)+1);
            } else {
                map.put(k, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        int[] cnt = new int[M];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(!map.containsKey(k)) {
                sb.append(0).append(" ");
                continue;
            }
            sb.append(map.get(k)).append(" ");
        }

        System.out.println(sb.toString());
    }
}