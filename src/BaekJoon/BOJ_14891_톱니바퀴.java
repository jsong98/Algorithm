package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
input1
10101111
01111101
11001110
00000010
2
3 -1
1 1

output1
7
---------------------------------
N극 = 0/S극 = 1
방향: 1 = 시계/-1 = 반시계

돌릴 시계 찾는 로직
    돌릴 시계 다 찾고 나서 한번에 돌리기
        while문
            왼쪽으로 보내는 로직
        while문
            오른쪽으로 보내는로직
시계로 돌면 rpt--, lpt--
반시계로 돌면 rpt++, lpt++


01234567

10101111
  *   *
01111101
  *   *
11001110
  *   *
00000010
  *   *
*/

public class BOJ_14891_톱니바퀴 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int rpt;
        int lpt;
        int[] value;
        
        public Node() {
            this.rpt = 2;
            this.lpt = 6;
            this.value = new int[8];
        }
    }
    static Node[] nodeArr;
    public static void main(String[] args) throws IOException {
        nodeArr = new Node[5];
        for (int i = 1; i <= 4; i++) {
            String[] s = br.readLine().split("");
            Node node = new Node();
            for (int j = 0; j < 8; j++) {
                node.value[j] = Integer.parseInt(s[j]);
            }
            nodeArr[i] = node;
        }
        
        int cmdNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < cmdNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int cmd = Integer.parseInt(st.nextToken());
            int[] visited = new int[5];
            // 돌릴 톱니 찾는 로직
            visited[nodeNum] = cmd;
            int temp = nodeNum;
            while(true) {
                temp-=1;
                if(temp<1) break;
                if(nodeArr[temp+1].value[nodeArr[temp+1].lpt] == nodeArr[temp].value[nodeArr[temp].rpt])
                    break;
                visited[temp] = visited[temp+1] == -1 ? 1 : -1;
            }
            temp = nodeNum;
            while(true) {
                temp+=1;
                if(temp>4) break;
                if(nodeArr[temp-1].value[nodeArr[temp-1].rpt] == nodeArr[temp].value[nodeArr[temp].lpt])
                    break;
                visited[temp] = visited[temp-1] == -1 ? 1 : -1;
            }

            // 톱니 돌리는 로직
            for (int j = 1; j <= 4; j++) {
                if(visited[j]==0) continue;
                if(visited[j]==-1) {
                    nodeArr[j].rpt = nodeArr[j].rpt==7 ? 0 : nodeArr[j].rpt+1;
                    nodeArr[j].lpt = nodeArr[j].lpt==7 ? 0 : nodeArr[j].lpt+1;
                }else {
                    nodeArr[j].rpt = nodeArr[j].rpt==0 ? 7 : nodeArr[j].rpt-1;
                    nodeArr[j].lpt = nodeArr[j].lpt==0 ? 7 : nodeArr[j].lpt-1;
                }
            }

        }
        int ret = 0;
        for (int i = 1; i <= 4; i++) {
            int t = nodeArr[i].rpt;
            t = t-2 <0 ? t+6 : t-2;
            if(nodeArr[i].value[t]==0) continue;
            ret+= (int) Math.pow(2,i-1);
        }
        System.out.println(ret);
    }
}
