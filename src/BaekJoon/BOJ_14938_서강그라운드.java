package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14938_서강그라운드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m, r;
    static int[] items;
    static class Edge {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    static class Move {
        int curPos;
        int cost;
        public Move(int curPos, int cost) {
            this.curPos = curPos;
            this.cost = cost;
        }
    }
    static List<List<Edge>> graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(srt).add(new Edge(dest, cost));
            graph.get(dest).add(new Edge(srt, cost));
        }


        int max = Integer.MIN_VALUE;
        for (int t = 1; t <= n; t++) {
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Move> pq = new PriorityQueue<Move>(new Comparator<Move>() {
                @Override
                public int compare(Move o1, Move o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
            });
            dist[t] = 0;
            pq.add(new Move(t, 0));
            while (!pq.isEmpty()) {
                Move m = pq.poll();

                for (int i = 0; i < graph.get(m.curPos).size(); i++) {
                    int dest = graph.get(m.curPos).get(i).dest;
                    int cost = m.cost + graph.get(m.curPos).get(i).cost;
                    if(dist[m.curPos]+cost < dist[dest]) {
                        dist[dest] = dist[m.curPos]+cost;
                        pq.add(new Move(dest, m.cost));
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < dist.length; i++) {
                if(dist[i] <= m) result.add(i);
            }

            int ret = 0;
            for (int i : result) {
                ret += items[i];
            }

            if(ret > max) max = ret;
        }

        System.out.println(max);
    }
}
