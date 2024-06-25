import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Person[] personArr = new Person[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            personArr[i] = new Person(height, weight);
            arr[i] = 1;
        }
        Person temp;
        for (int i = 0; i < N; i++) {
            temp = personArr[i];
            for (int j = 0; j < N; j++) {
                if(personCompare(personArr[j], temp) == 1) {
                    arr[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int personCompare(Person p1, Person p2) {
        if((p1.height > p2.height) && (p1.weight > p2.weight)) {
            return 1;
        } else {
            return -1;
        }
    }
}