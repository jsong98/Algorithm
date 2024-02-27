package B.practice.승강제리그;

import java.util.*;

class UserSolution {

    static class Player {
        int id;
        int ability;

        Player(int id, int ability) {
            this.id = id;
            this.ability = ability;
        }
    }
    static class League {
        TreeSet<Player> front;
        TreeSet<Player> rear;
    }
    List<League> leagues;
    static int playerNum;
    static int leagueNum;
    void init(int N, int L, int[] mAbility) {
        playerNum = N;
        leagueNum = L;
        int playerPerLeague = N / L;
        leagues = new ArrayList<>();
        int playerId = 0;  // 초기 상태 정렬을 위한 변수, mAbility의 index 담당
        PriorityQueue<Player> pq = new PriorityQueue<>(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if(p1.ability == p2.ability) return p1.id - p2.id;
                else return p2.ability - p1.ability;
            }
        }); // 초기 정렬상태를 위한 pq
        for (int i = 0; i < L; i++) {
            for (int p = 0; p < playerPerLeague; p++) {
                Player player = new Player(playerId, mAbility[playerId]);
                playerId++;
                pq.add(player);
            }

            // 리그 생성
            League league = new League();
            // 리그에 소속될 선수를 저장할 자료구조 선언
            TreeSet<Player> front = new TreeSet<>(new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    if(p1.ability == p2.ability) return p1.id - p2.id;
                    else return p2.ability - p1.ability;
                }
            });
            TreeSet<Player> rear = new TreeSet<>(new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    if(p1.ability == p2.ability) return p1.id - p2.id;
                    else return p2.ability - p1.ability;
                }
            });
            
            // 선수 생성 및 자료구조에 저장
            for (int j = 0; j < playerPerLeague / 2; j++) {
                front.add(pq.poll());
            }

            for (int k = 0; k < playerPerLeague / 2 + 1; k++) {
                rear.add(pq.poll());
            }
            
            // 리그에 자료구조 저장 및 리그를 저장할 리스트에 리그 넣기
            league.front = front;
            league.rear = rear;
            leagues.add(league);
        }

    }

    int move() {
        int result = 0;
        List<Player[]> playerToMove = new ArrayList<>();
        for(int i = 0; i < leagueNum-1; i++) {
            League higher = leagues.get(i);     // 상위 리그
            League lower = leagues.get(i+1);    // 하위 리그

            Player phigher = higher.rear.pollLast();     // 상위 리그의 가장 나쁜 선수
            Player plower = lower.front.pollFirst();    // 하위 리그의 가장 좋은 선수

            playerToMove.add(new Player[] {phigher, plower});

            // return할 값
            result += phigher.id;
            result += plower.id;
        }

        for (int i = 0; i < leagueNum - 1; i++) {
            League higher = leagues.get(i);     // 상위 리그
            League lower = leagues.get(i+1);    // 하위 리그

            Player phigher = playerToMove.get(i)[0];     // 상위 리그의 가장 나쁜 선수
            Player plower = playerToMove.get(i)[1];    // 하위 리그의 가장 좋은 선수

            // 상위 리그 처리
            Player comp = higher.front.last();
            // 하위 리그에서 올라온 선수와 상위리그 front의 마지막 선수 비교
            if(comp.ability == plower.ability) {    // 능력이 같은 경우
                if(comp.id > plower.id) {   // id를 비교해서, plower의 id가 더 낮은 경우
                    higher.rear.add(higher.front.pollLast());   // 상위리그 front에서 마지막을 뽑아서 rear에 넣고
                    higher.front.add(plower);                   // 상위리그 front에 plower를 넣음
                } else {    // id를 비교해서, plower의 id가 더 높은 경우
                    higher.rear.add(plower);    // higher.rear에 넣음
                }
            } else if(comp.ability > plower.ability) {  // 상위리그 front의 마지막보다 ability가 낮은 경우
                higher.rear.add(plower);    // higher.rear에 넣음
            } else {    // 상위 리그 front의 마지막보다 ability가 높은 경우
                higher.rear.add(higher.front.pollLast());   // 상위리그 front에서 마지막을 뽑아서 rear에 넣고
                higher.front.add(plower);                   // 상위리그 front에 plower를 넣음
            }

            // 하위 리그 처리 ---------- 하위리그는 front를 채워야 함
            comp = lower.rear.first();  // front를 채워야 하기 때문에 rear의 first와 비교
            // 상위 리그에서 내려온 선수와 하위리그 rear의 첫번째 선수 비교
            if(comp.ability == phigher.ability) {    // 능력이 같은 경우
                if(comp.id > phigher.id) {   // id를 비교해서, phigher의 id가 더 낮은 경우
                    lower.front.add(phigher);    // higher.rear에 넣음
                } else {    // id를 비교해서, phigher의 id가 더 높은 경우
                    lower.front.add(lower.rear.pollFirst());   // 하위리그 rear에서 첫번째를 뽑아서 front에 넣고
                    lower.rear.add(phigher);                   // 하위리그 rear에 phigher를 넣음
                }
            } else if(comp.ability > phigher.ability) {  // 하위리그 rear의 첫번째보다 ability가 낮은 경우
                lower.front.add(lower.rear.pollFirst());   // 하위리그 rear에서 첫번째를 뽑아서 front에 넣고
                lower.rear.add(phigher);                   // 하위리그 rear에 phigher를 넣음
            } else {    // 하위리그 rear의 첫번째보다 ability가 높은 경우
                lower.front.add(phigher);    // higher.rear에 넣음
            }
        }
        return result;
    }

    int trade() {
        int result = 0;
        List<Player[]> playerToMove = new ArrayList<>();
        for(int i = 0; i < leagueNum-1; i++) {
            League higher = leagues.get(i);     // 상위 리그
            League lower = leagues.get(i+1);    // 하위 리그

            Player phigher = higher.rear.pollFirst();     // 상위 리그의 가장 나쁜 선수
            Player plower = lower.front.pollFirst();    // 하위 리그의 가장 좋은 선수

            playerToMove.add(new Player[] {phigher, plower});

            // return할 값
            result += phigher.id;
            result += plower.id;
        }

        for (int i = 0; i < leagueNum - 1; i++) {
            League higher = leagues.get(i);     // 상위 리그
            League lower = leagues.get(i+1);    // 하위 리그

            Player phigher = playerToMove.get(i)[0];     // 상위 리그의 가장 나쁜 선수
            Player plower = playerToMove.get(i)[1];    // 하위 리그의 가장 좋은 선수

            // 상위 리그 처리
            Player comp = higher.front.last();
            // 하위 리그에서 올라온 선수와 상위리그 front의 마지막 선수 비교
            if(comp.ability == plower.ability) {    // 능력이 같은 경우
                if(comp.id > plower.id) {   // id를 비교해서, plower의 id가 더 낮은 경우
                    higher.rear.add(higher.front.pollLast());   // 상위리그 front에서 마지막을 뽑아서 rear에 넣고
                    higher.front.add(plower);                   // 상위리그 front에 plower를 넣음
                } else {    // id를 비교해서, plower의 id가 더 높은 경우
                    higher.rear.add(plower);    // higher.rear에 넣음
                }
            } else if(comp.ability > plower.ability) {  // 상위리그 front의 마지막보다 ability가 낮은 경우
                higher.rear.add(plower);    // higher.rear에 넣음
            } else {    // 상위 리그 front의 마지막보다 ability가 높은 경우
                higher.rear.add(higher.front.pollLast());   // 상위리그 front에서 마지막을 뽑아서 rear에 넣고
                higher.front.add(plower);                   // 상위리그 front에 plower를 넣음
            }

            // 하위 리그 처리 ---------- 하위리그는 front를 채워야 함
            comp = lower.rear.first();  // front를 채워야 하기 때문에 rear의 first와 비교
            // 상위 리그에서 내려온 선수와 하위리그 rear의 첫번째 선수 비교
            if(comp.ability == phigher.ability) {    // 능력이 같은 경우
                if(comp.id > phigher.id) {   // id를 비교해서, phigher의 id가 더 낮은 경우
                    lower.front.add(phigher);    // higher.rear에 넣음
                } else {    // id를 비교해서, phigher의 id가 더 높은 경우
                    lower.front.add(lower.rear.pollFirst());   // 하위리그 rear에서 첫번째를 뽑아서 front에 넣고
                    lower.rear.add(phigher);                   // 하위리그 rear에 phigher를 넣음
                }
            } else if(comp.ability > phigher.ability) {  // 하위리그 rear의 첫번째보다 ability가 낮은 경우
                lower.front.add(lower.rear.pollFirst());   // 하위리그 rear에서 첫번째를 뽑아서 front에 넣고
                lower.rear.add(phigher);                   // 하위리그 rear에 phigher를 넣음
            } else {    // 하위리그 rear의 첫번째보다 ability가 높은 경우
                lower.front.add(phigher);    // higher.rear에 넣음
            }
        }
        return result;
    }

//    void check() {
//        for (League league : leagues) {
//            for (Player p : league.front) {
//                System.out.print(p.id + "/" + p.ability + " ");
//            }
//            System.out.print("||| ");
//            for (Player p : league.rear) {
//                System.out.print(p.id + "/" + p.ability + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
