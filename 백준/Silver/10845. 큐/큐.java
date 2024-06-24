import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        int lastEle = 0;
        int k = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(st.hasMoreTokens()) {
                k = Integer.parseInt(st.nextToken());
            }
            switch (command) {
                case "push" :
                    que.add(k);
                    lastEle = k;
                    break;
                case "pop" :
                    System.out.println(que.isEmpty() ? -1 : que.poll());
                    break;
                case "size" :
                    System.out.println(que.size());
                    break;
                case "empty" :
                    System.out.println(que.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    System.out.println(que.isEmpty() ?  -1 : que.peek());
                    break;
                case "back" :
                    System.out.println(que.isEmpty() ?  -1 : lastEle);
                    break;
            }
        }
    }
}