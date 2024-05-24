package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Input
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

Output
7

Input
5 4
1 4 1
1 3 1
3 2 1
2 5 1
3 4

Output
5

*/

public class BOJ_1504_특정한최단경로 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Pos {
        int from;
        int move;
        public Pos(int from, int move) {
            this.from = from;
            this.move = move;
        }
    }
    static int N, E, u, v, max;   // 2 <= N <= 800, 0 <= E <= 200,000
    static List<List<int[]>> graph;
    static PriorityQueue<Pos> pq;
    // 간선은 항상 양방향으로 주어짐, 1 <= 간선의 길이 <= 1,000
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, distance});
            graph.get(end).add(new int[]{start, distance});
        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        // input
        max = Integer.MAX_VALUE;
        pq = new PriorityQueue<Pos>((a, b) -> Integer.compare(a.move, b.move));
        // init pq by Pos.move
        int[] from1 = dijkstra(1);
        int[] fromN = dijkstra(N);
        if((from1[u] == max && from1[v] == max) || (fromN[u] == max && fromN[v] == max)) {
            System.out.println(-1);
            return ;
        }
        int[] fromU = dijkstra(u);
        int[] fromV = dijkstra(v);
        if(fromU[v] == max) {
            System.out.println(-1);
            return ;
        }

        /*
        case1.  1 - u - v - N
        case2.  1 - v - u - N
        case3.  1 - u - v - u - N
        case4.  1 - v - u - v - N
        */
        boolean flag = false;
        if((from1[u] == max && fromN[u] == max) || from1[v] == max && fromN[v] == max) {
            flag = true;
        }
        int startToU = from1[u];
        int startToV = from1[v];
        int uToV = fromU[v];
        int uToN = fromN[u];
        int vToN = fromN[v];
        int ret = 0;
        if(flag) {
            ret += 2 * uToV;
            ret += Integer.min((startToV + vToN), (startToU + uToN));
        } else {
            ret += uToV;
            ret += Integer.min((startToV + uToN), (startToU + vToN));
        }

        System.out.println(ret);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, max);
        pq.add(new Pos(start,0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Pos p = pq.poll();
            for (int[] edge : graph.get(p.from)) {
                int dest = edge[0];
                int cost = edge[1];
                if(p.move + cost < dist[dest]) {
                    dist[dest] = p.move + cost;
                    pq.add(new Pos(dest, p.move+cost));
                }
            }
        }
        return dist;
    }
}
