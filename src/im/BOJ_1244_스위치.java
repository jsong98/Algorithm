package im;

import java.util.Scanner;

public class BOJ_1244_스위치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] status = new int[num+1];
		for(int i = 1; i <= num; i++) {
			status[i] = sc.nextInt();
		}
		int stdNum = sc.nextInt();
		
		for(int i = 1; i <= stdNum; i++) {
			int gender = sc.nextInt();
			int idx = sc.nextInt();
			
			if(gender == 1) {
				while(idx <= status.length) {
					if(status[idx] == 1) {
						status[idx] = 0;
					} else if(status[idx] == 0){
						status[idx] = 1;
					}
					idx += idx;
				}
			}
			
			if(gender == 2) {
				
				if(status[idx] == 0) {
					status[idx] = 1;
				} else{
					status[idx] = 0;
				}
				
				if(idx-1 >= 0 && idx+1 < 8) {
					if(status[idx-1] == status[idx+1]) {
						int dup = 1;
						while(idx-dup > 0 && idx+dup < status.length) {
							if(status[idx-dup] == status[idx+dup]) {
								dup++;
							} else {
								break;
							}
						}
						
						for(int j = 1; j <= dup; j++) {
							if(idx-j >= 0) {
								if(status[idx-j] == 1) {
									status[idx-j] = 0;
								} else if(status[idx-j] == 0){
									status[idx-j] = 1;
								}
							}
							
						}
						for(int j = 1; j <= dup; j++) {
							if(idx+j < status.length) {
								if(status[idx+j] == 1) {
									status[idx+j] = 0;
								} else if(status[idx+j] == 0){
									status[idx+j] = 1;
								}
							}
							
						}
					}
				}
			}
			
			for(int k : status) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		int cnt = 0;
		for(int i : status) {
			System.out.print(i + " ");
			cnt++;
			if(cnt%20 == 0) {
				System.out.println();
			}
		}
	}
	
}
