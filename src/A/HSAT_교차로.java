package A;

import java.io.*;
import java.util.*;

public class Main {

    static class Car {
        int time;//들어온시간
        int num;//넘버링
        public Car(int time, int num) {
            this.time = time;
            this.num = num;
        }
    }

    static int time;//절대시간
    static int[] ret;// 결과를 저장할 배열
    static List<Queue<Car>> roads;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        roads = new ArrayList<>();
        Queue<Car> roadA = new LinkedList<>();
        Queue<Car> roadB = new LinkedList<>();
        Queue<Car> roadC = new LinkedList<>();
        Queue<Car> roadD = new LinkedList<>();
        roads.add(roadA);
        roads.add(roadB);
        roads.add(roadC);
        roads.add(roadD);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ret = new int[N];
        Arrays.fill(ret, -1);
        time = 0;
        int num = 0;//자동차 넘버링
        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(sc.next());
            String r = sc.next();
            Car car = new Car(t, num++);
            if(t != time) {
                time = t;
                if(i == 0) {
                    if(r.equals("A")) {
                        roadA.add(car);
                    }
                    if(r.equals("B")) {
                        roadB.add(car);
                    }
                    if(r.equals("C")) {
                        roadC.add(car);
                    }
                    if(r.equals("D")) {
                        roadD.add(car);
                    }
                    continue;
                }
                // 메인 로직
                visited = new boolean[4];
                for(int j = 0; j < 4; j++) {
                    if(!roads.get(j).isEmpty()) {
                        if(roads.get((j+3)%4).isEmpty()) {
                            visited[j] = true;
                        }
                    }
                }
                for(int j = 0; j < 4; j++) {
                    if(visited[j]) {
                        ret[roads.get(j).poll().num] = time;
                    }
                }
            }
            if(r.equals("A")) {
                roadA.add(car);
            }
            if(r.equals("B")) {
                roadB.add(car);
            }
            if(r.equals("C")) {
                roadC.add(car);
            }
            if(r.equals("D")) {
                roadD.add(car);
            }
        }

        System.out.println(N);
    }
}

