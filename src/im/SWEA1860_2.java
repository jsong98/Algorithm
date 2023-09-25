package im;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1860_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            boolean check = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            ArrayList<Integer> visit = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int time = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    visit.add(time);
                }

                for (int k = 0; k < j; k++) {
                    if (visit.get(k) >= time) {
                        visit.add(k, time);
                        break;
                    }

                    visit.add(time);
                }
            }

            int gaesu = 0;
            int sell = 0;
            for (int j = 0; j < visit.size(); j++) {
                gaesu = (visit.get(j) / M) * K - sell;
                if (gaesu <= 0) {
                    check = true;
                    break;
                }

                sell++;
            }

            if (check) {
                System.out.printf("#%d Impossible\n", i + 1);
            }

            else {
                System.out.printf("#%d Possible\n", i + 1);
            }
        }
    }
}