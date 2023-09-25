package solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {    
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws NumberFormatException, IOException  {
        int target = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
        
        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int n = Integer.parseInt(st.nextToken());
            broken[n] = true;
        }
        
        int result = Math.abs(target - 100); //초기값 설정
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                    isBreak = true; 
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                result = Math.min(min, result);
            }
        }        
        System.out.println(result);
    }
}


//public class BOJ_1107_리모컨 {
//	
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringBuilder sb = new StringBuilder();
//	static int[] button = new int[10];
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(br.readLine());
//		if(M==0) {
//			System.out.println(Math.min(Integer.toString(N).length(), makeNoNum(N)));
//			return;
//		}
//		for(int i = 0; i < 10; i++) {
//			button[i] = i;
//		}
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < M; i++) {
//			int broken = Integer.parseInt(st.nextToken());
//			button[broken] = -1;
//		}
//		
//		int closeMore = makeCloseMore(N);
//		int closeLess = makeCloseLess(N);
//		int noNum = makeNoNum(N);
//		System.out.println("upper : " + closeMore + " , lower : " + closeLess + " , noNum : " + noNum);
//		System.out.println(Math.min(Math.min(closeMore, closeLess), noNum));
//	}
//	
//	public static int makeCloseMore(int n) {
//		String[] arr = Integer.toString(n).split("");
//		int std = 0;	// 숫자버튼으로 만들 수 없는 가장 큰 자릿수
//		int idx = 0;	// 숫자버튼으로 만들 수 없는 가장 큰 자릿수의 index
//		
//		for(int i = 0; i < arr.length; i++) {
//			std = Integer.parseInt(arr[i]);
//			if(button[std]==-1) {
//				idx = i;
//				break;
//			}
//			if(i == arr.length-1) return arr.length;  
//		}
//		
//		for(int i = std; i < button.length; i++) {		// std보다 큰 버튼중에 고장나지 않은 가장 작은 버튼
//			if(button[i]!=-1) {
//				arr[idx] = Integer.toString(i);
//				break;
//			}
//			if(i==button.length-1) return Integer.MAX_VALUE;
//		}
////		System.out.println(Arrays.toString(arr));
//		
//		for(int i = 0; i < button.length; i++) {		// 고장나지 않은 버튼 중 가장 큰 버튼을 찾아서
//			if(button[i]!=-1) {
//				for(int j = idx+1; j < arr.length; j++) {	// arr의 나머지를 다 채움.
//					arr[j] = Integer.toString(i);
//				}
//				break;
//			}
//		}
////		System.out.println(Arrays.toString(arr));
//		
//		String s = "";
//		for(int i = 0; i < arr.length; i++) {
//			s += arr[i];
//		}
//		int res = Integer.parseInt(s)-n+arr.length;
//		return res;
//	}
//	
//	public static int makeCloseLess(int n) {
//		String[] arr = Integer.toString(n).split("");
//		int std = 0;	// 숫자버튼으로 만들 수 없는 가장 큰 자릿수의 수
//		int idx = 0;	// 숫자버튼으로 만들 수 없는 가장 큰 자릿수의 arr 내부의 index
//		for(int i = 0; i < arr.length; i++) {
//			std = Integer.parseInt(arr[i]);
//			if(button[std]==-1) {
//				idx = i;
//				break;
//			}
//			if(i == arr.length-1) return arr.length; 
//		}
//		
//		for(int i = std; i >= 0; i--) {		// std보다 작은 버튼중에 고장나지 않은 가장 큰 버튼
//			if(button[i]!=-1) {
//				arr[idx] = Integer.toString(i);
//				break;
//			}
//			if(i==0) {
//				arr[idx] = "0";
//			}
//		}
////		System.out.println(Arrays.toString(arr));
//		
//		for(int i = button.length-1; i >=0; i--) {		// 고장나지 않은 버튼 중 가장 작은 버튼을 찾아서
//			if(button[i]!=-1) {
//				for(int j = idx+1; j < arr.length; j++) {	// arr의 나머지를 다 채움.
//					arr[j] = Integer.toString(i);
//				}
//				break;
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		String s = "";
//		for(int i = 0; i < arr.length; i++) {
//			s += arr[i];
//		}
//		int len = arr.length;
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i].equals("0")) {
//				len--;
//			}
//			if(i == arr.length-1) {
//				if(len==0) len = 1;
//			}
//		}
//		int res = n-Integer.parseInt(s)+len;
//		return res;
//	}
//	
//	public static int makeNoNum(int n) {
//		return Math.abs(n-100);
//	}
//
//}
