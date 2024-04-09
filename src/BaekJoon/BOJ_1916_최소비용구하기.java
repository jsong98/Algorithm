package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916_최소비용구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, srt, dest;
    static List<List<Node>> graph;
    static int[] dist;
    static class Node {
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(srt).add(new Node(dest, weight));
        }
        st = new StringTokenizer(br.readLine());
        srt = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[srt] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Node(srt, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(dist[curNode.idx] < curNode.cost) continue;

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);

                if(dist[nextNode.idx] > curNode.cost + nextNode.cost) {
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    pq.add(new Node(nextNode.idx, curNode.cost + nextNode.cost));
                }
            }
        }

        System.out.println(dist[dest]);
    }
}
