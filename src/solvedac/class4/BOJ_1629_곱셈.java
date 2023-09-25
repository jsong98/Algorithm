package solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long a, b, c;
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        
        System.out.println(pow(a, b));
    }
    
    public static long pow(long a, long exponent) {
        
        if(exponent==1) {
            return a % c;
        }
        
        long temp = pow(a, exponent/2);
        
        
        if(exponent%2==1) {
            return (temp * temp % c) * a % c;
        }
            
            
        return temp * temp % c;
    }

}
