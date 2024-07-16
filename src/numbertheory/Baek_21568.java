package numbertheory;

import java.util.Scanner;

public class Baek_21568 {
    //A,B,C 입력이 들어옴
    //만약 A,B의 최대공약수 배수가 C가 아니면 -1 출력.
    //배수가 맞다면 최대공약수로 둔 다음. 확장 유클리드 시작.
    //재귀함수 쓰는게 맞을듯함.

    //x = y' y = x' - y' * q
    private static int x = 1;
    private static int y = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int uclidResult = uclid(A,B);
        if(C % uclidResult != 0) {
            System.out.println(-1);
            return;
        }

        int multi = C / uclidResult;
        System.out.print(x * multi + " ");
        System.out.print(y * multi + " ");
    }

    private static int uclid(int A, int B) {
        if (B == 0) {
            return A;
        } else {
            int m = uclid(B, A % B);

            int n = A / B;
            int yPrime = y;
            int xPrime = x;

            x = yPrime;
            y = xPrime - (yPrime * n);

            return m;
        }
    }
}
