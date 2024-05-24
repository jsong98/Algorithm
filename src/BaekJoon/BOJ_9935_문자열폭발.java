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
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        int bombIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == bomb.charAt(0)) {

            }
            stack.add(arr[i]);

        }
    }
}
