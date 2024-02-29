package B.practice.메모장프로그램;

import java.util.*;

class UserSolution
{
    static final int NODE_INTERVAL = 100000;
    static final int NODE_REMAIN = 301;
    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return Long.compare(n1.id, n2.id);
        }
    }
    static class Pointer {
        int h;
        int w;
        Node node;
        Pointer(int h, int w, Node node) {
            this.h = h;
            this.w = w;
            this.node = node;
        }
    }
    static class Node {
        long id;
        long remain;
        char value;
        Node prev;
        Node next;
        Node(long id, long remain, char c) {
            this.id = id;
            this.remain = remain;
            this.value = c;
        }
        Node(long id) { this.id = id; }
    }
    static HashMap<Character, TreeSet<Node>> getNodeSet;
    static HashMap<Integer, Node> getRowHead;
    static Pointer pointer;
    static Node lastNode;
    static int lastNodeH;
    static int lastNodeW;
    static int width;
    static int cmdCnt;
    void init(int H, int W, char[] mStr)
    {
        width = W;
        getNodeSet = new HashMap<>(); 
        getRowHead = new HashMap<>();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            getNodeSet.put(ch, new TreeSet<Node>(new NodeComparator()));
        }   // char a부터 char z까지를 key로, NodeSet을 value로 하는 getNodeSet에 value 추가

        int length = 0;
        while (mStr[length] != '\0') {
            length++;
        }   // 주어진 문자열 길이 구하기
        
        // headNode 생성 및 처리
        Node head = new Node(0, NODE_REMAIN, mStr[0]);
        getRowHead.put(0, head);        // 첫번째 줄 맨 앞, getRowHead에 추가
        getNodeSet.get(mStr[0]).add(head);  // char값에 맞는 NodeSet에 추가

        // Pointer 생성
        pointer = new Pointer(0, 0, head);

        // 주어진 문자열 길이만큼 while문을 돌면서 node를 만들고 각각 처리
        Node ptNode = head;
        long idx = 1;
        int widthCount = 1;
        int heightCount = 0;
        while((int)idx != length) {
            Node newNode = new Node(idx * NODE_INTERVAL, NODE_REMAIN, mStr[(int) idx]); // id = idx * 100,000
            getNodeSet.get(mStr[(int) idx]).add(newNode);
            // row의 첫번째 node면 getRowHead에 저장
            if(widthCount == 0) getRowHead.put(heightCount, newNode);
            // 새로 만든 노드와 기존 노드 연결
            ptNode.next = newNode;
            newNode.prev = ptNode;

            ptNode = newNode;
            idx++;  // 인덱스 이동
            widthCount++;

            if (widthCount == width) {   // 줄바꿈을 해야 하는 경우
                widthCount = 0;
                heightCount++;
            }
        }
        // 마지막 node & 위치값 저장
        lastNode = ptNode;
        if((length % W) == 0) {
            lastNodeH = (length / W)-1;
            lastNodeW = W-1;
        } else {
            lastNodeH = (length / W)-1;
            lastNodeW = (length % W)-1;
        }
        return ;
    }

    void insert(char mChar)
    {
        if(pointer.node == null) {
            // Pointer가 아무 node도 가리키지 않고 있는 경우
            Node newNode = new Node(lastNode.id+NODE_INTERVAL, NODE_REMAIN, mChar);
            if(getNodeSet.get(mChar).contains(newNode)) System.out.println("********************************1");
            getNodeSet.get(mChar).add(newNode);
            if(lastNode != null) {  // 메모장이 아예 비어있는 경우
                lastNode.next = newNode;
                newNode.prev = lastNode;
            }
            lastNode = newNode;     // 새로운 node 만들고, lastNode 뒤에 연결해주고, lastNode 업데이트
            if(pointer.w == 0) { // 새로 들어온 node가 비어있는 row를 차지하는 경우
                getRowHead.put(pointer.h, newNode); // getRowHead에 넣어줌
            }
            updatePointer();        // pointer 업데이트
            updateLastNodePos();    // 마지막 노드 좌표 업데이트
            return ;
        }

        Node ptNode = pointer.node;
        // 새 node 생성, id는 ptNode.id - ptNode.remain
        Node newNode = new Node(ptNode.id - ptNode.remain, NODE_REMAIN, mChar);
        ptNode.remain -= 1;
        System.out.println("=====" + ptNode.id + " " + ptNode.remain + " " + newNode.id);
        if(getNodeSet.get(mChar).contains(newNode)) System.out.println("********************************2");
        getNodeSet.get(mChar).add(newNode);
        if(ptNode.prev == null) {
            ptNode.prev = newNode;
            newNode.next = ptNode;  // ptNode와 연결
        } else {
            ptNode.prev.next = newNode;
            newNode.prev = ptNode.prev; // ptNode.prev와 연결
            ptNode.prev = newNode;
            newNode.next = ptNode;  // ptNode와 연결
        }
        updatePointer();    // pointer 업데이트
        updateLastNodePos();    // 마지막 노드 좌표 업데이트

        // rowHead 업데이트
        if(pointer.h == lastNodeH) {    // 마지막 줄인경우
            if(pointer.w == 0) getRowHead.put(pointer.h, ptNode);
            if(pointer.w == 1) getRowHead.put(pointer.h, newNode);
            // pointer가 가리키는 node | pointer 앞의 node가 갱신된 경우

        } else {
            if(pointer.w == 0) getRowHead.put(pointer.h, ptNode);
            if(pointer.w == 1) getRowHead.put(pointer.h, newNode);
            // pointer가 가리키는 node | pointer 앞의 node가 갱신된 경우

            for (int i = pointer.h+1; i <= lastNodeH; i++) {
                Node origin = getRowHead.get(i);
                if(origin == null) {
                    getRowHead.put(lastNodeH, lastNode);
                    continue;
                }
                getRowHead.put(i, origin.prev);
            }
        }
        if(mChar == 'o') {
            System.out.println("------------------------------------" + getNodeSet.get('o').size());
            System.out.println(pointer.node.value);
        }
        System.out.println("insert");
        check();
        System.out.println();

    }

    char moveCursor(int mRow, int mCol)
    {
        int row = mRow-1;
        int col = mCol-1;
        if((row > lastNodeH) || (row == lastNodeH && col > lastNodeW)){
            pointer.h = lastNodeH;
            pointer.w = lastNodeW;
            pointer.node = lastNode;
            System.out.println('$');
            return '$';
        }
        int count = 0;
        Node ptNode = getRowHead.get(row);
        while (count != col) {
            ptNode = ptNode.next;
            count++;
        } // getRowHead로 주어진 row의 head를 구하고 mCol만큼 이동해서 node찾기
        pointer.h = row;
        pointer.w = col;
        pointer.node = ptNode;

        System.out.println("moveCursor");
        check();
        System.out.println(pointer.node.value);
        System.out.println();

        return pointer.node.value;
    }

    int countCharacter(char mChar)
    {
        System.out.println("countChar");
        check();
        System.out.println(pointer.node.value + " " + mChar + " " + pointer.node.id);
        System.out.println(getNodeSet.get(mChar).tailSet(new Node(pointer.node.id-1), true).size());
        for(Node node : getNodeSet.get(mChar)) System.out.print(node.id + " ");
        System.out.println();
        for(Node node : getNodeSet.get(mChar).tailSet(new Node(pointer.node.id-1), true)) System.out.print(node.id + " ");
        System.out.println();

        int checkPointerNode = 0;
//        if(pointer.node.value == mChar) checkPointerNode = 1;

        return getNodeSet.get(mChar).tailSet(new Node(pointer.node.id-1), true).size() + checkPointerNode;
    }

    void updatePointer() {
        // pointer의 위치 업데이트
        if (pointer.w == (width - 1)) {
            pointer.h += 1;
            pointer.w = 0;
        } else {
            pointer.w += 1;
        }
        return ;
    }
    void updateLastNodePos() {
        if(lastNodeW == (width-1)) {
            lastNodeW = 0;
            lastNodeH += 1;
        } else {
            lastNodeW += 1;
        }
    }
    void check() {
        System.out.println("commandNum: " + ++cmdCnt);
        System.out.println("Pointer: " + pointer.h + " " + pointer.w + " " + pointer.node.value + " lastNode: " + lastNodeH + " " + lastNodeW);
        Node pt = getRowHead.get(0);
        while (pt != null) {
            System.out.print(pt.value);
            pt = pt.next;
        }
        System.out.println();
        for (int i = 0; i <= lastNodeH; i++) {
            System.out.print(i + ": " + getRowHead.get(i).value + " ");
        }
        System.out.println();
    }
}