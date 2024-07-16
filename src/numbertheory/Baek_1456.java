package numbertheory;

import java.util.Scanner;

public class Baek_1456 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        scanner.close();

        int max = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체로 소수 판별
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // 거의 소수 찾기
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                long power = (long) i * i;
                while (power <= B) {
                    if (power >= A) {
                        count++;
                    }
                    if (power > B / i) break; // 오버플로 방지
                    power *= i;
                }
            }
        }

        System.out.println(count);
    }
}