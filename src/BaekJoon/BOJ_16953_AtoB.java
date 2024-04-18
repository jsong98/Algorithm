package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16953_AtoB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Pos {
        int num;
        int cnt;

        public Pos(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        PriorityQueue<Pos> pq = new PriorityQueue<Pos>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return Integer.compare(o1.cnt, o2.cnt);
            }
        });
        pq.add(new Pos(a, 1));
        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            if(p.num < 1 || p.num > 1000000000) continue;
            if (p.num == b) {
                System.out.println(p.cnt);
                System.exit(0);
            }
            pq.add(new Pos(p.num*2, p.cnt+1));
            if(p.num > 220000000) continue;
            pq.add(new Pos(p.num*10+1, p.cnt+1));
        }
        System.out.println(-1);
    }
}
