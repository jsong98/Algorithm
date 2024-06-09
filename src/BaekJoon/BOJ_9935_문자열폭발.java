package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if(stack.size() >= bombLength) {
                boolean flag = true;
                for(int j = 0; j < bombLength; j++) {
                    if(stack.get(stack.size()-bombLength+j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }

            }
        }
        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}
