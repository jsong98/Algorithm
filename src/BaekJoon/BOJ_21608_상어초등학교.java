package BaekJoon;

/*

인접 = 상하좌우
1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로
2. 1을 만족하는 칸이 여러 개면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로
3. 2를 만족하는 칸이 여러 개면, 행우선, 그 다음 열우선.

3 <= N <= 20

return 만족도 총합

1. 현재 자리에 좋아하는 학생이 없는 경우
    1) 비어있는 칸 중에서, 인접하는 칸이 비어있는 칸이 제일 많은 칸
     -어떻게 빨리 찾음? --> 모든 좌표에 대해, 비어있는 인접칸 개수 저장?
    2) 1-1)이 여러 개면 행우선 -> 열우선
     -1-1에 대해 행우선 -> 열우선으로 정렬, 비어있는 인접칸 기준 pq? n이 최대 20인데 굳이?
2. 좋아하는 학생이 있는 경우
    1) 1명인 경우
     -그 1명의 인접 칸 중에서 비어있는 칸이 제일 많은 칸
     -여러 개면 행우선 -> 열우선
    2) 여러 명인 경우
     -
class node {
    int r;
    int c;
    int adjEmpty;
    int likeCnt;
}
likeCnt - adjEmpty - r - c 순으로 정렬되는 pq만들기
모든 학생마다 모든 칸에 완탐 돌리면서,
인접 node에 좋아하는 학생이 있으면 해당 node.likeCnt++하고 pq에 집어넣음
 -likeCnt는 학생의 id를 key로, 좋아하는 학생의 id가 담겨있는 HashSet을 Value로 하는 HashMap을 기반으로 판단
모든 칸 완탐이 끝난 시점에서 pq에서 뽑으면 그 자리 배정.

input 1
3
4 2 5 1 7
3 1 9 4 5
9 8 1 2 3
8 1 9 3 4
7 2 3 4 8
1 9 2 5 7
6 5 2 3 4
5 1 9 2 8
2 9 3 1 4

output 1
54
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_21608_상어초등학교 {

    static class Node {
        int r;
        int c;
        int stdId;  // 앉아있는 학생
        int adjEmpty;   // 인접 칸 중 비어있는 칸 개수
        int likeCnt;    // 인접 칸 중 좋아하는 학생이 있는 개수, 모든 case마다 update

        public Node(int r, int c, int stdId, int adjEmpty, int likeCnt) {
            this.r = r;
            this.c = c;
            this.stdId = stdId;
            this. adjEmpty = adjEmpty;
            this.likeCnt = likeCnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, res;
    static Node[][] room;
    static boolean[][] visited;
    static HashMap<Integer, HashSet<Integer>> map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int stdNum = N * N; // 학생 수
        room = new Node[N+1][N+1];
        visited = new boolean[N+1][N+1];
        map = new HashMap<>();   // 학생들의 좋아하는 학생 정보를 담는 map
        Queue<Integer> seq = new LinkedList<>();    // 학생 순서
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            // likecnt - adjEmpty - r - c 순으로 비교해서 정렬
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.likeCnt != o2.likeCnt) {
                    return o2.likeCnt - o1.likeCnt;
                } else if(o1.adjEmpty != o2.adjEmpty) {
                    return o2.adjEmpty - o1.adjEmpty;
                } else if (o1.r != o2.r) {
                    return o1.r - o2.r;
                } else {
                    return o1.c - o2.c;
                }
            }
        });

        for (int i = 1; i <= N; i++) { // 교실 초기화
            for (int j = 1; j <= N; j++) {
                room[i][j] = new Node(i, j, 0, 0, 0);
                for (int k = 0; k < 4; k++) {   // 비어있는 인접 칸 개수
                    int nr = room[i][j].r + dr[k];
                    int nc = room[i][j].c + dc[k];
                    if(nr <= 0 || nr > N ||  nc <= 0 || nc > N) continue;
                    room[i][j].adjEmpty++;
                }
            }
        }

        for (int i = 1; i <= stdNum; i++) {   // map 초기화
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < stdNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stdId = Integer.parseInt(st.nextToken());
            seq.add(stdId);
            for (int j = 0; j < 4; j++) {   // 각 학생마다 4명씩 좋아하는 학생을 저장
                map.get(stdId).add(Integer.parseInt(st.nextToken()));
            }
        }   // input

        // Main logic
        while (!seq.isEmpty()) {
            int std = seq.poll();
            initRoom();
            for (int i = 1; i <= N; i++) {  // 교실 전체 완탐
                for (int j = 1; j <= N; j++) {
                    if(visited[i][j]) continue;
                    for (int k = 0; k < 4; k++) {   // 인접 칸 탐색
                        int nr = room[i][j].r + dr[k];
                        int nc = room[i][j].c + dc[k];
                        if(nr <= 0 || nr > N ||  nc <= 0 || nc > N || !visited[nr][nc]) continue;  // 좌표를 벗어나거나 비어있으면 넘어감
                        if(map.get(std).contains(room[nr][nc].stdId)) room[i][j].likeCnt++; // 앉아있는 학생이 좋아하는 학생이면
                    }
                    pq.add(room[i][j]);
                }
            }
            Node pos = pq.poll();
            System.out.println(std + " " + pos.r + " " + pos.c);
            pos.stdId = std;
            visited[pos.r][pos.c] = true;
            pq.clear();
        }

        getRes();

        System.out.println(res);

    }

    static void initRoom() {    // likeCnt 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                room[i][j].likeCnt = 0;
            }
        }
    }

    static void getRes() {
        res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int std = room[i][j].stdId;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = room[i][j].r + dr[k];
                    int nc = room[i][j].c + dc[k];
                    if(nr <= 0 || nr > N ||  nc <= 0 || nc > N) continue;
                    if (map.get(std).contains(room[nr][nc].stdId)) {
                        cnt++;
                    }
                }

                if (cnt == 1) {
                    res += 1;
                } else if (cnt == 2) {
                    res += 10;
                } else if (cnt == 3) {
                    res += 100;
                } else if (cnt == 4) {
                    res += 1000;
                }
            }
        }
    }
}
