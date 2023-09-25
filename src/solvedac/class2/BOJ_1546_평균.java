package solvedac.class2;

import java.util.Scanner;

public class BOJ_1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int subjNum = sc.nextInt();
		double[] grade = new double[subjNum];
		for(int n = 0; n < subjNum; n++) {
			grade[n] = sc.nextInt();
		}
		
		double max = Integer.MIN_VALUE;
		for(int i = 0; i < subjNum; i++) {
			if(grade[i] > max) {
				max = grade[i];
			}
		}
		
		double[] newGrade = new double[subjNum];
		for(int i = 0; i < subjNum; i++) {
			if(grade[i] != max) {
				newGrade[i] = (grade[i]/max)*100;
			} else {
				newGrade[i] = (grade[i]/grade[i])*100;
			}
		}
		
		double sum = 0;
		for(int i = 0; i < subjNum; i++) {
			sum+=newGrade[i];
		}
		
		double result = sum/subjNum;
		
		System.out.println(result);
	}

}
