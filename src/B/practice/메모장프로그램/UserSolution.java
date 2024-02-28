package B.practice.메모장프로그램;

import java.util.*;

class UserSolution
{
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
        Node prev;
        char value;
        Node next;
        Node(long id, char c) {
            this.id = id;
            this.value = c;
        }

    }
    static HashMap<Character, TreeSet<Node>> getNodeSet;
    static HashMap<Integer, Node> getRowHead;
    static int lastElemH;
    static int lasElementW;
    static Pointer pointer;
    static int lastElementH;
    static int lastElementW;
    void init(int H, int W, char[] mStr)
    {
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
        Node head = new Node(0, mStr[0]);
        getRowHead.put(0, head);        // 첫번째 줄 맨 앞, getRowHead에 추가
        getNodeSet.get(mStr[0]).add(head);  // char값에 맞는 NodeSet에 추가

        // Pointer 생성
        pointer = new Pointer(0, 0, head);

        // 주어진 문자열 길이만큼 while문을 돌면서 node를 만들고 각각 처리
        Node prev = head;
        long idx = 1;
        int widthCount = 1;
        int heightCount = 1;
        while(idx < length) {
            Node newNode = new Node(idx * 100000, mStr[(int) idx]); // id = idx * 100,000
            getNodeSet.get(mStr[(int) idx]).add(newNode);

            // 새로 만든 노드와 기존 노드 연결
            prev.next = newNode;
            newNode.prev = prev;

            prev = newNode;
            idx++;  // 인덱스 이동
            widthCount++;

            if (widthCount > W) {   // 줄바꿈을 해야 하는 경우
                getRowHead.put(heightCount, prev);  // 현재 prev는 새로 만든 node
                // getRowHead에 저장해주고, widthCount와 heightCount 초기화
                widthCount = 0;
                heightCount++;
            }
        }
        
        // 마지막 node 좌표 저장
        lastElementH = length/H;
        lastElementW = (length % W) - 1;

//        // Check
//        while(head != null) {
//            System.out.println(head.id);
//            head = head.next;
//        }
//        System.out.println(lastElementH);
//        System.out.println(lastElementW);
//        System.out.println(getRowHead.get(0).id);
//        System.out.println(getRowHead.get(1).id);
//        System.out.println(getNodeSet.get('b').size());
//        System.out.println(getNodeSet.get('c').size());
//        System.out.println(getNodeSet.get('d').size());
//        System.out.println(getNodeSet.get('e').size());
//        System.out.println(getNodeSet.get('g').size());
//        System.out.println(getNodeSet.get('a').size());

        return ;
    }

    void insert(char mChar)
    {
        if(pointer.h == lastElementH && pointer.w == (lasElementW+1)) {
            // 포인터가 마지막 node 오른쪽에 있는 경우, Pointer가 아무 node도 가리키지 않고 있는 경우

        }


    }

    char moveCursor(int mRow, int mCol)
    {
        return '$';
    }

    int countCharacter(char mChar)
    {
        return -1;
    }
}