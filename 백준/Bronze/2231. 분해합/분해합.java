import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = i;
            int record = 0;
            while(temp > 10) {
                record += temp%10;
                temp = temp/10;
            }
            record += temp%10;
            if((record+i) == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}