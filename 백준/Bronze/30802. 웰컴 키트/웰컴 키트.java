import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, T, P;
    static int[] sizes;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sizes = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            int size = Integer.parseInt(st.nextToken());
            sizes[i] = size;
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int ret = 0;
        for (int i = 0; i < 6; i++) {
            if(sizes[i] == 0) continue;
            if(sizes[i]%T == 0) {
                ret += sizes[i]/T;
            } else {
                ret += (sizes[i]/T+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ret).append("\n").append(N/P).append(" ").append(N%P);
        System.out.println(sb.toString());
    }
}