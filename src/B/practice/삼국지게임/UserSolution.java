package B.practice.삼국지게임;

import java.util.HashMap;
import java.util.HashSet;

class UserSolution {

    static HashMap<Integer, Ally> allies;   // key(동맹번호)에 해당하는 동맹(연결리스트) value 매핑
    static HashMap<Integer, HashSet<Integer>> enemyRel; // key(동맹번호)와 적대관계(동맹번호집합) value 매핑
    static HashMap<String, Monarch> getMonarch;     // key(군주이름)과 동맹번호 value 매핑
    static int allyCount;

    static class Monarch {  // 군주 클래스
        String name;
        int allyNum;
        int r;
        int c;
        int soldierNum;
        Monarch next;

        Monarch() {

        }

        Monarch(String name, int allyNum, int r, int c, int soldierNum) {
            this.name = name;
            this.allyNum = allyNum;
            this.r = r;
            this.c = c;
            this.soldierNum = soldierNum;
        }
    }

    static class Ally { // 동맹 클래스(연결 리스트)
        Monarch head;
        Monarch tail;
        Ally(Monarch monarch) {
            this.head = monarch;
            this.tail = monarch;
        }
    }

    void init(int N, int[][] mSoldier, char[][][] mMonarch)
    {
//        int totalCount = N * N;
        allyCount = 0;  // 동맹번호
        allies = new HashMap<>();   // 동맹번호에 해당하는 동맹 매핑
        enemyRel = new HashMap<>(); // 동맹번호에 해당하는 동맹과 적대관계인 군주들 매핑
        getMonarch = new HashMap<>();   // 군주이름을 key로 동맹번호 value 매핑
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                allyCount += 1;
                String name = new String(mMonarch[i][j]);
                Monarch monarch = new Monarch(name, allyCount, i, j, mSoldier[i][j]);
                Ally ally = new Ally(monarch);
                allies.put(allyCount, ally);
                enemyRel.put(allyCount, new HashSet<>());
                getMonarch.put(name, monarch);
            }
        }
    }
    void destroy()
    {

    }
    int ally(char[] mMonarchA, char[] mMonarchB)
    {
//        check();
        String a = new String(mMonarchA);   // A군주 이름
        String b = new String(mMonarchB);   // B군주 이름
//        System.out.println("-----------------" + a + " " + b + " " + getMonarch.get(a).allyNum + " " + getMonarch.get(b).allyNum);
        int allyA = getMonarch.get(a).allyNum;      // A군주가 포함된 동맹 번호
        int allyB = getMonarch.get(b).allyNum;      // B군주가 포함된 동맹 번호
        if(allyA == allyB) return -1;   // A와 B가 동맹관계인 경우
        if(enemyRel.get(allyA).contains(allyB)) return -2;  // A군주와 적대관계인 set에서 b를 포함하고 있으면 -2

        // A군주가 포함된 동맹(연결리스트)의 tail 뒤에 B군주가 포함된 동맹의 head를 연결
        allies.get(allyA).tail.next = allies.get(allyB).head;

        // A군주가 포함된 동맹(연결리스트)의 tail에 B군주가 포함된 동맹의 tail을 매핑
        allies.get(allyA).tail = allies.get(allyB).tail;

        // B군주와 적대관계인 군주들을 A군주 동맹에 포함시킴
        enemyRel.get(allyA).addAll(enemyRel.get(allyB));

        // B군주와 적대관계였던 군주들의 적대관계에 A군주 추가
        for(int i : enemyRel.get(allyB)) {
            enemyRel.get(i).add(allyA);
        }

        // allyB에 속한 Monarch들의 allyNum을 allyA로 바꿔줌
        Monarch node = allies.get(allyB).head;
        while(node != null) {
            node.allyNum = allyA;
            node = node.next;
        }

        return 1;
    }
    int attack(char[] mMonarchA, char[] mMonarchB, char[] mGeneral)
    {
//        check();
        String a = new String(mMonarchA);
        String b = new String(mMonarchB);
        String g = new String(mGeneral);
        int allyA = getMonarch.get(a).allyNum;      // A군주가 포함된 동맹 번호
        int allyB = getMonarch.get(b).allyNum;      // B군주가 포함된 동맹 번호

        if(allyA == allyB) return -1;   // A와 B가 동맹관계인 경우

        // 전장 좌표
        int destR = getMonarch.get(b).r;
        int destC = getMonarch.get(b).c;

        // 공격 동맹 중 전장과 인접한 곳이 있는지 확인, 인접하면 보유한 병사 수의 절반을 공격병사 수에 더함
        int attacker = 0;   // 공격 병사 수
        int attackerNodeCount = 0;
        Monarch attackerNode = allies.get(allyA).head;
        while(attackerNode != null) {
            if(attackerNode.name == null) {
                attackerNode = attackerNode.next;
                continue;
            }

            if(Math.abs(attackerNode.r - destR) <= 1 && Math.abs(attackerNode.c - destC) <= 1) {
                int soldiers = attackerNode.soldierNum/2;
                attackerNode.soldierNum -= soldiers;
                attacker += soldiers;
                attackerNodeCount++;
            }

            attackerNode = attackerNode.next;
        }

        if(attackerNodeCount == 0) return -2;    // 전투가 일어나지 않은 경우

        int defender = 0;   // 방어 병사 수
        Monarch defenderNode = allies.get(allyB).head;
        while(defenderNode != null) {
            if(defenderNode.name == null) {
                defenderNode = defenderNode.next;
                continue;
            }

            if(Math.abs(defenderNode.r - destR) <= 1 && Math.abs(defenderNode.c - destC) <= 1) {
                if(defenderNode.name.equals(b)) {   // 자기 자신인 경우
                    defender += getMonarch.get(b).soldierNum;
                } else {
                    int soldiers = defenderNode.soldierNum/2;
                    defenderNode.soldierNum -= soldiers;
                    defender += soldiers;
                }
            }

            defenderNode = defenderNode.next;
        }

        //적대관계 처리
        enemyRel.get(allyA).add(allyB);
        enemyRel.get(allyB).add(allyA);

        if(attacker > defender) {   // 공격 성공
            Monarch origin = getMonarch.get(b);
            origin.name = null; // 연결리스트에서 지우지는 않고, 군주이름을 null처리

            // 장수를 군주로 하는 새로운 인스턴스 생성, 군주A와 같은 동맹. allyA LinkedList 뒤에 연결
            Monarch newMonarch = new Monarch(g, allyA, origin.r, origin.c, attacker-defender);
            allies.get(allyA).tail.next = newMonarch;
            allies.get(allyA).tail = newMonarch;
            getMonarch.put(g, newMonarch);

            return 1;
        } else {    // 공격 실패
            getMonarch.get(b).soldierNum = defender - attacker; // 병사 수만 남은 병사 수로

            return 0;
        }

//        return -3;
    }
    int recruit(char[] mMonarch, int mNum, int mOption)
    {
//        check();
        String a = new String(mMonarch);

        if(mOption == 0) {
            getMonarch.get(a).soldierNum += mNum;
            return getMonarch.get(a).soldierNum;
        } else if (mOption == 1) {
            int count = 0;
            Monarch monarch = allies.get(getMonarch.get(a).allyNum).head;
            while(monarch != null) {
                if(monarch.name == null) {

                    monarch = monarch.next;
                    continue;
                }
                monarch.soldierNum += mNum;
                count += monarch.soldierNum;

                monarch = monarch.next;
            }

            return count;
        }


        return -1;
    }

//    void check() {
//        for (int i = 1; i <= 16; i++) {
//            Monarch monarch = allies.get(i).head;
//            System.out.print(i + " ");
////            while (monarch != null) {
////                System.out.print(monarch.name + "/" + monarch.allyNum + " ");
////
////                monarch = monarch.next;
////            }
////            System.out.println();
//            System.out.println(enemyRel.get(i).toString());
//        }
//        System.out.println();
//    }
}