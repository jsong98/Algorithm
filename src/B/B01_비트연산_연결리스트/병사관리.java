package B.B01_비트연산_연결리스트;

class UserSolution
{
    public class Node { // 병사들을 Node로 하는 연결리스트 구현
        int id;
        int v;
        Node nxt;

        Node() {}

        Node(int id, int v) {
            this.id = id;
            this.v = v;
            this.nxt = null;
        }

        Node(int id, int v, Node nxt) {
            this.id = id;
            this.v = v;
            this.nxt = nxt;
        }
    }

    public Node[] node = new Node[200055];
    public int cnt = 0;
    public int[] version = new int[100055];  // version[i] := ID 가 i 인 사람의 최신 버전
    public int[] num = new int[100055];      // num[i] := ID 가 i 인 사람의 team 번호

    // 병사가 최대 100,000명이므로, init에서 미리 Node들을 초기화시키고 하나씩 불러서 사용
    public Node getNewNode(int id, Node nxt) {
        Node ret = node[cnt++];
        ret.id = id;
        ret.nxt = nxt;
        ret.v = ++version[id];
        return ret;
    }

    public class Team { // 각 팀의 head와 tail 저장, mScore 1~5까지 따로 저장
        Node[] head = new Node[6];
        Node[] tail = new Node[6];
    }
    // Team은 Array로 접근
    public Team[] t = new Team[6];

    public void init() {
        cnt = 0;
        for (int i=0;i<200055;i++){
            if (node[i] == null) node[i] = new Node();
        }
        for (int i = 1; i <= 5; i++) {
            t[i] = new Team();
            for (int j = 1; j <= 5; j++) {
                t[i].tail[j] = t[i].head[j] = getNewNode(0, null);
            }
        }

        for (int i = 0; i <= 100000; i++) {
            version[i] = 0;
            num[i] = 0;
        }
    }

    public void hire(int mID, int mTeam, int mScore) {  // O(1)
        Node newNode = getNewNode(mID, null);
        t[mTeam].tail[mScore].nxt = newNode;
        t[mTeam].tail[mScore] = newNode;
        num[mID] = mTeam;
    }

    public void fire(int mID) {  // O(1)
        version[mID] = -1;
    }

    // 실제로 업데이트 하지 않고, version만 다른 새로운 node를 hire하는 것으로 처리
    public void updateSoldier(int mID, int mScore) {  // O(1)
        hire(mID, num[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {  // O(1)
        // j == 변경 전 mScore, k == 변경 후 mScore
        /*
        updateTeam 처리 자체를 Team이라는 연결 리스트의 연결 상태 변화로 처리
        이 때, mChangeScore가 0보다 클 때와 0보다 작을 때의 처리가 달라야 함.
        ex. mChageScore가 0보다 클 때 mScore가 1인 연결리스트부터 조회하면 전부 mScore = 5가 됨
        */
        if (mChangeScore < 0) {
            for (int j = 1; j <= 5; j++) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (t[mTeam].head[j].nxt == null) continue;
                t[mTeam].tail[k].nxt = t[mTeam].head[j].nxt;
                t[mTeam].tail[k] = t[mTeam].tail[j];
                // 아래 두 줄은 mScore == j인 LinkedList를 empty 처리하는 과정
                t[mTeam].head[j].nxt = null;
                t[mTeam].tail[j] = t[mTeam].head[j];
            }
        }
        if (mChangeScore > 0) {
            for (int j = 5; j >= 1; j--) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (t[mTeam].head[j].nxt == null) continue;
                t[mTeam].tail[k].nxt = t[mTeam].head[j].nxt;
                t[mTeam].tail[k] = t[mTeam].tail[j];
                t[mTeam].head[j].nxt = null;
                t[mTeam].tail[j] = t[mTeam].head[j];
            }
        }
    }

    public int bestSoldier(int mTeam) {  // O(N)
        // 어차리 최대 mScore는 5점이기 때문에, mTeam의 mScore == 5인 LinkedList부터 차례대로 탐색
        for (int j = 5; j >= 1; j--) {
            Node node = t[mTeam].head[j].nxt;
            if (node == null) continue;

            int ans = 0;
            while (node != null) {
                // 현재 node의 version과, version Array에 저장된 값이 같을 때만 확인
                if (node.v == version[node.id]) {
                    ans = ans < node.id ? node.id : ans;
                }
                node = node.nxt;
            }
            if (ans != 0) return ans;
        }
        return 0;
    }
}