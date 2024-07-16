package numbertheory;

import java.util.Scanner;

public class Baek_1934 {
    //최소 공배수 구하는 거임..
    // A * B / 최대 공약수 = 최소공배수
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = A * B / uclid(A,B);
            System.out.println(C);
        }
    }

    private static int uclid(int A, int B) {
        if(B == 0) {
            return A;
        }else {
            return uclid(B, A % B);
        }
    }
}
