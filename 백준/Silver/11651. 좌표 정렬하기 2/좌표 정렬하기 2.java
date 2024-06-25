import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class PosComparator implements Comparator<Pos> {
        @Override
        public int compare(Pos p1, Pos p2) {
            if(p1.y > p2.y) {
                return 1;
            } else if(p1.y == p2.y) {
                if(p1.x > p2.x) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pos> pq = new PriorityQueue<>(new PosComparator());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Pos(x, y));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.println(sb.toString());
    }

}