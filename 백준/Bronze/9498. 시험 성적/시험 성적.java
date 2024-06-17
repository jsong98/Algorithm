import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String ret = (score >= 90 && score <= 100) ? "A" :
                        (score >= 80 && score < 90) ? "B" :
                                (score >= 70 && score < 80) ? "C" :
                                        (score >= 60 && score < 70) ? "D" : "F";
        System.out.println(ret);
    }
}