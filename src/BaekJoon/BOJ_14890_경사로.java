package BaekJoon;

/*
2 <= N <= 100
1 <= L <= N
1 <= 칸의 높이 <= 10

6 2

3 3 3 3 3 3
3 3 3 3 2 2
2 2 2 3 3 3
2 2 3 3 2 2
3 3 3 3 2 2

3 2 1 1 2 3
3 2 2 2 3 3
1 2 2 3 3 3
1 1 2 3 3 3
1 1 2 3 3 2

가면서 같은 길이였던 칸들의 개수를 저장
if 다음 칸이 더 높은 칸인 경우 {
    다음 칸과 현재 칸의 높이 차이 비교, 2이상이면 바로 break
    높이 차가 1이면 지금까지 저장된 같은 길이의 칸 개수와 L을 비교
    같은 길이의 칸이 L보다 크거나 같으면 continue, 저장된 칸 개수 초기화
} else 다음 칸이 더 낮은 칸인 경우 {
    다음칸과 현재 칸의 높이 차이 비교, 2이상이면 바로 break
    높이 차가 1이면 저장된 같은 길이의 칸 개수 초기화, 칸 확인
    같은 길이의 칸이 L칸만큼 존재한다면 continue, 저장된 칸 개수 초기화
}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, L, count, record, height;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;  // 지나갈 수 있는 길의 개수 저장
        outer:
        for (int r = 0; r < N; r++) {   // 행 검사
            record = 1; // 행이 초기화될 때마다 1로 초기화
            height = map[r][0]; // 행이 초기화될 때마다 해당 행의 첫번째 열의 값으로 초기화
            visited = new boolean[N];   // 매 행마다 초기화
            visited[0] = true;
            inner:
            for (int c = 1; c < N; c++) {
                if(visited[c]) {
                    if(c == (N-1)) {
                        count++;
                        continue outer;
                    } else {
                        continue inner;
                    }
                }
                int compare = map[r][c];    // height와 비교할 칸의 높이
                if(Math.abs(height - compare) >= 2) continue outer; // 높이 차가 2 이상이면 바로 넘어감
                if(height == compare) { // 칸의 높이가 같다면 record += 1 해주고 넘어감
                    visited[c] = true;  // 방문처리
                    record++;   
                }

                if(height < compare) {  // 높은 칸으로 이동하는 경우
                    if(record >= L) { // 올라갈 수 있는 경우
                        visited[c] = true;  // 방문처리 해주고
                        record = 1;     // 저장된 같은 길이의 칸 초기화
                        height = compare;   // 현재 칸의 높이 변경
                    } else {
                        continue outer;
                    }
                } else if(height > compare) {    //  낮은 칸으로 이동하는 경우
                    height = compare;
                    record = 0;
                    int pt = c;
                    for (int k = 0; k < L; k++) {   // L만큼 height-1 높이의 칸이 존재하는지 여부 파악
                        if((pt+k) >= N) continue outer; // map을 벗어나는 경우
                        if(map[r][pt+k] == compare) {
                            visited[pt+k] = true;
                        } else {    // L만큼 height-1 높이의 칸이 존재하지 않는 경우
                            continue outer;
                        }
                    }


                }
                if(c == (N-1)) {
                    count++;
                }
            }
        }

//        System.out.println(count);

        outer:
        for (int c = 0; c < N; c++) {   // 열 검사
            record = 1; // 열이 초기화될 때마다 1로 초기화
            height = map[0][c]; // 열이 초기화될 때마다 해당 열의 첫번째 행의 값으로 초기화
            visited = new boolean[N];   // 매 열마다 초기화
            visited[0] = true;
            inner:
            for (int r = 1; r < N; r++) {
                if(visited[r]) {
                    if(r == (N-1)) {
                        count++;
                        continue outer;
                    } else {
                        continue inner;
                    }
                }
                int compare = map[r][c];    // height와 비교할 칸의 높이
                if(Math.abs(height - compare) >= 2) continue outer; // 높이 차가 2 이상이면 바로 넘어감
                if(height == compare) { // 칸의 높이가 같다면 record += 1 해주고 넘어감
                    visited[r] = true;  // 방문처리
                    record++;
                }

                if(height < compare) {  // 높은 칸으로 이동하는 경우
                    if(record >= L) { // 올라갈 수 있는 경우
                        visited[r] = true;  // 방문처리 해주고
                        record = 1;     // 저장된 같은 길이의 칸 초기화
                        height = compare;   // 현재 칸의 높이 변경
                    } else {
                        continue outer;
                    }
                } else if(height > compare) {    //  낮은 칸으로 이동하는 경우
                    height = compare;
                    record = 0;
                    int pt = r;
                    for (int k = 0; k < L; k++) {   // L만큼 height-1 높이의 칸이 존재하는지 여부 파악
                        if((pt+k) >= N) continue outer; // map을 벗어나는 경우
                        if(map[pt+k][c] == compare) {
                            visited[pt+k] = true;
                        } else {    // L만큼 height-1 높이의 칸이 존재하지 않는 경우
                            continue outer;
                        }
                    }


                }
                if(r == (N-1)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
