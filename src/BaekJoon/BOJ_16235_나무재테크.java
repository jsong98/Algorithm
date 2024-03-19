package BaekJoon;

import java.io.*;
import java.util.*;

/*
봄: 자신의 나이만큼 양분을 먹고, 나이가 1 증가. 자신의 칸의 양분만, 여러 개의 나무가 있으면 어린 나무부터. 못먹으면 즉사
여름: 봄에 죽은 나무가 양분으로. 있던 자리에 (나무나이/2)만큼 양분 추가
가을: 나이가 5의 배수인 나무의 번식, 인접 8칸에 나이가 1인 나무 생성.
겨울: 초기 입력값만큼 각 칸에 양분 추가.
return (k년 후에 살아남은 나무의 개수)

양분값을 저장할 2차원 배열?
나무 - 위치(r, c) + 나이 ==> pq
각 위치마다 전부 pq를 생성?
2차원 pq를 저장하는 배열. 각 pq는 나무 객체 저장(나무는 나이값 저장) 굳이? 그냥 나이만 저장.
번식하는 나무의 개수 저장하는 2차원 int 배열 따로 만들기

*/

class Tree implements Comparable<Tree> {
    int x, y, age;

    public Tree(int x, int y, int age) {
        super();
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }
}

public class BOJ_16235_나무재테크 {
    static int[] adj_x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] adj_y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][N + 1];
        int[][] eat = new int[N + 1][N + 1]; // 양분
        Deque<Tree> tree_list = new LinkedList<>();

        // A[r][c] 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                eat[i][j] = 5;
            }
        }

        // 나무 리스트에 추가
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tree_age = Integer.parseInt(st.nextToken());
            tree_list.add(new Tree(x, y, tree_age));
        }

        while (K > 0) {
            Queue<Tree> die_tree_list = new LinkedList<>();

            // 봄
            for (int i = 0; i < tree_list.size();) {
                Tree cur = tree_list.poll();
                if (eat[cur.x][cur.y] >= cur.age) {
                    eat[cur.x][cur.y] -= cur.age;
                    cur.age++;
                    i++;
                    tree_list.add(cur);
                } else {
                    die_tree_list.add(cur);
                }
            }

            // 여름
            for (Tree t : die_tree_list) {
                eat[t.x][t.y] += t.age / 2;
            }

            // 가을
            Queue<Tree> temp_list = new LinkedList<>();
            for (Tree t : tree_list) {
                if (t.age % 5 == 0) {
                    temp_list.add(t);
                }
            }
            while (!temp_list.isEmpty()) {
                Tree t = temp_list.poll();

                for (int i = 0; i < 8; i++) {
                    int next_x = t.x + adj_x[i];
                    int next_y = t.y + adj_y[i];
                    if (next_x >= 1 && next_x <= N && next_y >= 1 && next_y <= N) {
                        tree_list.addFirst(new Tree(next_x, next_y, 1));
                    }
                }
            }

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    eat[i][j] += A[i][j];
                }
            }

            K--;
        }

        bw.write(tree_list.size() + "\n");
        bw.flush();
        bw.close();
    }
}
